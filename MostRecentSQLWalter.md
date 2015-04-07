# ThesisDatabase

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
  appid integer,
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

CREATE TABLE "framework"
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
  packagename character varying(255),
  CONSTRAINT androidid_fkey FOREIGN KEY (appid) REFERENCES application (appid), 
  CONSTRAINT packagename_fkey FOREIGN KEY (packagename) REFERENCES  framework (frameworkname) 
);

CREATE TABLE apphaspermission
(
  appid integer,
  permissionname character varying(255),
  CONSTRAINT androidid_fkey FOREIGN KEY (appid) REFERENCES application (appid),
  CONSTRAINT permissionname_fkey FOREIGN KEY (permissionname) REFERENCES permission (permissionname) 
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
    os text,
    username text,
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

	Insert into application(appid,appname,filename,packagename,minimumversion,targetversion,versionname,versioncode,dateadded,addedby,developer,os) 
	                values (appId,appname,filename,packagename,minimumversion,targetversion, versioncode,versionname,Now(),userId,developer,os);
	return appId;
end;
$$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION createAppId()
RETURNS integer AS $$
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
$$
  LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION numberofusers()
RETURNS integer AS
$$
DECLARE 
	found integer;
	BEGIN
		select count(*) into found
		from users;
		return found;
			
	end;
$$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION createUserId()
RETURNS integer AS $$
DECLARE 
	userId integer;
BEGIN
	Select numberOfusers() into userId;
	if (userId=0)
	THEN
		return 1;
	else
		select max(userid) from users into userId;
		return userId+1;
	end if;
end
$$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION createUser
(
name text,
password text,
role text
)
RETURNS integer AS $$
DECLARE 
	userId integer;
BEGIN
	select createuserid() into userId;
	Insert into users values(text,userId,password,role);
	return userId;
end
$$
  LANGUAGE plpgsql;
