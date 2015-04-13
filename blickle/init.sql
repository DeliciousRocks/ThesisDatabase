----------Create Database----------

CREATE TABLE users
(
  username character varying(255),
  userid integer,
  password character varying(255),
  role integer,
  CONSTRAINT userid_pkey PRIMARY KEY (userid)
);

CREATE TABLE application
(
  appid serial,
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
  CONSTRAINT appid_pkey PRIMARY KEY (appid),
  CONSTRAINT addedby_fkey FOREIGN KEY (addedby) REFERENCES users (userid)
);

CREATE TABLE framework
(
  frameworkname character varying(255),
  potentiallyinsecure boolean,
  CONSTRAINT frameworkname_pkey PRIMARY KEY (frameworkname)
);

CREATE TABLE permission
(
  permissionname character varying(255),
  potentiallyinsecure boolean,
  CONSTRAINT permissionname_pkey PRIMARY KEY (permissionname)
);

CREATE TABLE apphasframework
(
  appid integer,
  frameworkname character varying(255),
  CONSTRAINT androidid_fkey FOREIGN KEY (appid) REFERENCES application
(appid),
  CONSTRAINT frameworkname_fkey FOREIGN KEY (frameworkname) REFERENCES
framework (frameworkname)
);

CREATE TABLE apphaspermission
(
  appid integer,
  permissionname character varying(255),
  CONSTRAINT androidid_fkey FOREIGN KEY (appid) REFERENCES application
(appid),
  CONSTRAINT permissionname_fkey FOREIGN KEY (permissionname)
REFERENCES permission (permissionname)
);

----------Functions----------

CREATE OR REPLACE FUNCTION login
(
	  name text,
	  pass text
)
RETURNS boolean AS $$
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
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION numberOfApps ()
RETURNS integer AS $$
DECLARE
	found integer;
	BEGIN
		select count(*) into found
		from application;
		return found;

	end;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION numberOfIOSApps ()
RETURNS integer AS $$
DECLARE
	found integer;
	BEGIN
		select count(*) into found
		from application
		where os = 'iOS';
		return found;

	end;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION numberOfAndroidApps ()
RETURNS integer AS $$
DECLARE
	found integer;
	BEGIN
		select count(*) into found
		from application
		where os = 'Android';
		return found;

	end;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getUserId
(
name text
)
RETURNS integer AS $$
DECLARE
	found integer;
	BEGIN
		select userid into found
		from users
		where username = name;

		return found;

	end;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION addNewApp
(
    filename text,
    packagename text,
    minimumversion double precision,
    targetversion double precision,
    versioncode text,
    versionname text,
    username text,
    os text,
    appname text,
    developer text
)
RETURNS integer AS $$
DECLARE
	appId integer;
	userId integer;
BEGIN
	Select numberOfApps() into appId;
	Select getUserId(userName) into userId;

	Insert into application values
(appId,appname,filename,packagename,minimumversion,targetversion,
versioncode,versionname,Now(),userId,developer,os);
	return appId;
end;
$$
  LANGUAGE plpgsql;














create or replace function addNewPermission() returns trigger as $$
begin
	if (new.permissionname not in (select permission.permissionname from permission)) then
		insert into permission values (new.permissionname, null);
	end if;
	return new;
end;
$$ language plpgsql;

drop trigger AddNewPermissionTrigger on apphaspermission;
create trigger AddNewPermissionTrigger before insert on apphaspermission
	for each row execute procedure addNewPermission();




select addNewApp('f1.txt', 'pack1', 1.0, 2.0, '100', '1.0.0', 'walter', 'Android', 'MyApp', 'squires, inc.');

