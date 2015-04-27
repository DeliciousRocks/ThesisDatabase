/***************
 * Main Tables *
 ***************/

CREATE TABLE users (
    userid serial primary key,--integer NOT NULL,
    username character varying(255) unique,
    password character varying(255),
    role integer,
    quota integer,
    appssubmitted integer
);


CREATE TABLE application (
    appid integer primary key,
    appname character varying(255),
    filename character varying(255),
    packagename character varying(255),
    minimumversion double precision,
    targetversion double precision,
    versioncode character varying(255),
    versionname character varying(255),
    dateadded timestamp with time zone,
    addedby integer,
    developer character varying(255),
    os character varying(255),
    genre character varying(255),

    constraint addedby_fkey FOREIGN KEY (addedby) REFERENCES users(userid)
);


CREATE TABLE framework (
    frameworkname character varying(255) primary key,
    potentiallyinsecure boolean
);


CREATE TABLE permission (
    permissionname character varying(255) primary key,
    potentiallyinsecure boolean
);



/******************
 * Support Tables *
 ******************/

CREATE TABLE apphaspermission (
    appid integer,
    permissionname character varying(255),
    requested boolean,
    required boolean,
    primary key (appid, permissionname),
    constraint androidid_fkey foreign key (appid) references application(appid),
    constraint permissionname_fkey foreign key (permissionname) references permission(permissionname)
);


CREATE TABLE apphasframework (
    appid integer,
    packagename character varying(255),
    primary key (appid, packagename),
    constraint androidid_fkey FOREIGN KEY (appid) REFERENCES application(appid),
    constraint packagename_fkey FOREIGN KEY (packagename) REFERENCES framework(frameworkname)
);



/*************
 * Functions *
 *************/

create function checkAppAndPermissionStatus(
	aid integer,
	permission character varying(255))
	returns integer
language plpgsql
as $$
declare
	isRequested boolean;
	isRequired boolean;
begin
	
	select	requested
	from	apphaspermission
	into	isRequested
	where	appid=aid
		and permission=permissionname;

	select	required
	from	apphaspermission
	into	isRequired
	where	appid=aid
		and permission=permissionname;

	-- good 0, under 1, over 2
	return ((isRequired::int) | (isRequested::int << 1)) % 3;
end $$;


create function checkAppPrivilegeStatus(aid integer)
	returns integer
language plpgsql
as $$
declare
	privilegeStatus integer := 0;
	r record;
begin
	for r in (select	appid, permissionname
		  from		apphaspermission
		  where		appid=aid) loop

		privilegeStatus = privilegeStatus | checkAppAndPermissionStatus(r.appid, r.permissionname);
		
	end loop;

	-- good 0, under 1, over 2, both 3
	return privilegeStatus;
end $$;

create function getAppsWithPrivilegeStatus(status integer)
	returns setof application
as $$
	select	*
	from	application
	where	(select * from checkAppPrivilegeStatus(appid))=status;
$$ language sql;


create function addnewapp(filename text, packagename text, minimumversion double precision, targetversion double precision, versioncode text, versionname text, os text, username text, appname text, developer text, genre text) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	appId integer;
	userId integer;
BEGIN
	Select numberOfApps() into appId;
	Select getUserId(userName) into userId;

	insert into application(appid,appname,filename,packagename,minimumversion,targetversion,versionname,versioncode,dateadded,addedby,developer,os,genre) 
	                values (appId,appname,filename,packagename,minimumversion,targetversion, versioncode,versionname,Now(),userId,developer,os,genre);
	return appId;
end;
$$;



CREATE FUNCTION addpackage(appid integer, packagename text) RETURNS void
    LANGUAGE plpgsql
    AS $$

BEGIN
	Insert into apphaspackage(appid,packageName) 
	                values (appId,packageName);
end;
$$;


CREATE FUNCTION addpermission() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 
	permissionExists integer;
BEGIN
	Select count(*) into permissionExists from permission where permissionname = new.permissionname;
	if (permissionExists = 0) then
		Insert Into permission values (new.permissionname, null);
	end if;
	--Insert into apphaspermission(appid,permissionname,requested,required) 
	--                values (appId,appname,permissionName,requested,required);
	return new;
end;
$$;

CREATE FUNCTION addframework()
  RETURNS trigger AS
$BODY$
DECLARE 
	FrameworkExists integer;
BEGIN
	Select count(*) into FrameworkExists from framework where frameworkname = new.packagename;
	if (FrameworkExists = 0) then
		Insert Into framework values (new.packagename, null);
	end if;
	--Insert into apphaspermission(appid,permissionname,requested,required) 
	--                values (appId,appname,permissionName,requested,required);
	return new;
end;
$BODY$
  LANGUAGE plpgsql;

create function incrementUserApps() returns trigger as $$
begin
	update users
	set appssubmitted=appssubmitted+1
	where users.userid=new.addedby;
	return new;
end; $$ language plpgsql;


create trigger ensurepermissionexists before insert on apphaspermission
	for each row
		execute procedure addpermission();

create trigger ensureFrameworkexists before insert on apphasframework
	for each row
		execute procedure addframework();

create trigger appadded after insert on application
	for each row
		execute procedure incrementUserApps();

/*
CREATE FUNCTION addpermission(appd integer, pname text, rted boolean, rred boolean) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE 
	permissionExists integer;
BEGIN
	Select count(*) into permissionExists from permission where permission.permissionname = pname;
	if(permissionExists = 0) then
		Insert Into permission values (pname, null);
	end if;
	Insert into apphaspermission(appid,permissionname,requested,required) 
	                values (appd,pname,rted,rred);
	--return new;
end;
$$;
*/




CREATE OR REPLACE FUNCTION getunknownframeworks()
  RETURNS SETOF text AS
$BODY$
 
	 Select frameworkname from framework where potentiallyinsecure is null;

$BODY$
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION getunknownpermissions()
  OWNER TO postgres;



CREATE FUNCTION getuserrole(name text)
  RETURNS integer AS
$BODY$
DECLARE 
	urole integer;
	BEGIN
		select role into urole
		from users
		where username = name;
		
		return urole;
			
	end;
$BODY$
  LANGUAGE plpgsql;


CREATE FUNCTION isRepeat(
    fileN text,
    vName text
    )
  RETURNS boolean AS
$BODY$
DECLARE
	repeat integer;
BEGIN
	Select count(*) into repeat from application where filename = fileN AND versionName =vName;
	if (repeat>0) 
	THEN 
		return true;
	else 
		return false;
	end if;
	END
$BODY$
  LANGUAGE plpgsql;


CREATE FUNCTION checkpermission() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
	
DECLARE
	permissionExists integer;
BEGIN 
	Select count(*) into permissionExists from permissions where permissionname = new.permissionname;
	if(permission = 0) then
		Insert Into permissions values (new.permissionname, null);
		RAISE EXCEPTION 'Nonexistent ID --> %', user_id USING HINT = 'Please check your user id';

	end if;
	return new;
END;
$$;


CREATE OR REPLACE FUNCTION getuserrole(n character varying)
  RETURNS integer AS
$BODY$
DECLARE 
	r integer;
BEGIN
	Select role into r from users where userName = n;
	return r;
	
end;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION getuserrole(character varying)
  OWNER TO postgres;

CREATE OR REPLACE FUNCTION getuserrole(name text)
  RETURNS integer AS
$BODY$
DECLARE 
	urole integer;
	BEGIN
		select role into urole
		from users
		where username = name;
		
		return urole;
			
	end;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION getuserrole(text)
  OWNER TO postgres;


CREATE OR REPLACE FUNCTION getusername(x integer)
  RETURNS text AS
$BODY$
DECLARE
y text;
BEGIN
	Select username into y from users where userid =x;
	return y;
	
end;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION getusername(integer)
  OWNER TO postgres;

  CREATE OR REPLACE FUNCTION getunknownpermissions()
  RETURNS SETOF text AS
$BODY$
 
	 Select permissionname from permission where potentiallyinsecure is null;

$BODY$
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION getunknownpermissions()
  OWNER TO postgres;



CREATE FUNCTION createappid() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	appId integer;
BEGIN
	Select numberOfApps() into appId;
	if (appId=0)
	THEN
		return 1;
	else
		select max(appid) from application into appId;
		return appId+1;
	end if;
end
$$;


--
-- TOC entry 201 (class 1255 OID 51223)
-- Name: createuser(text, text, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

create function createuser(
	name text,
	password text,
	role integer,
	quota integer) returns integer
    language plpgsql
    AS $$
declare
	userId integer;
begin
	--select createuserid() into userId;
	insert into users values(default,name,password,role, quota, 0);
	return userId;
end $$;


--
-- TOC entry 200 (class 1255 OID 51221)
-- Name: createuserid(); Type: FUNCTION; Schema: public; Owner: postgres
--

create FUNCTION createuserid() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	userId integer;
BEGIN
	Select numberOfusers() into userId;
	if (userId=0)
	THEN
		return 1;
	else
		select max(users.userid) from users into userId;
		return userId+1;
	end if;
end
$$;



CREATE FUNCTION getuserid(name text) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select userid into found
		from users
		where username = name;
		
		return found;
			
	end;
$$;



CREATE FUNCTION login(name text, pass text) RETURNS boolean
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from users
		where Username = name AND password = pass;

		if (found =1) then
			return true;
		end if;
		return false;
	end;
$$;



CREATE FUNCTION numberofandroidapps() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from application
		where os = 'Android';
		return found;
			
	end;
$$;



CREATE FUNCTION numberofapps() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from application;
		return found;
			
	end;
$$;



CREATE FUNCTION numberofiosapps() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from application
		where os = 'iOS';
		return found;
			
	end;
$$;


CREATE FUNCTION numberofusers() RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from users;
		return found;
			
	end;
$$;


