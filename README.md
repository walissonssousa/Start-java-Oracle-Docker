## templates-backend-oracle



**para subir o oracle database:**

    $ docker-compose up -d oracle  

**para rodar a aplicação pelo docker:**

    $ docker-compose up -d --build

**rodar liquibase:**
    $./mvnw liquibase:update

## conectar com db oracle


**usar oracle SQL Develop**


## conectar um novo banco


**name: jornada_db**

**usuário: sys as sysdba**

**senha: Oradoc_db1**

**SID: ORCLCDB**

**Conectar**


## Dentro do Execultor de scripts rodar seguinte código
    
    
    
    ALTER SESSION SET "_ORACLE_SCRIPT"=true;
    -- Create New Table Space
    CREATE TABLESPACE dbtemplates_tablespace
    DATAFILE 'dbtemplates_tablespace.dbf'
    SIZE 100M;
    -- ALTER TABLESPACE dbtemplates_tablespace
    --     ADD DATAFILE 'dbtemplates_tablespace2.dbf'
    --     SIZE 100M;
    -- Create New User
    CREATE USER dbtemplates IDENTIFIED BY "dbtemplates"
    DEFAULT TABLESPACE dbtemplates_tablespace
    quota unlimited on dbtemplates_tablespace;
    -- Grant Permissions
    grant create session to dbtemplates;
    grant create table to dbtemplates;
    alter user dbtemplates quota unlimited on dbtemplates_tablespace;
    grant create view, create procedure, create sequence to dbtemplates;
    -- Grant Permissions to Table Space
    grant UNLIMITED TABLESPACE TO dbtemplates;
    ALTER USER dbtemplates IDENTIFIED BY "dbtemplates"
 

## conectar um novo banco


**name: dbtemplates_db**

**usuário: dbtemplates**

**senha: dbtemplates**

**SID: ORCLCDB**

**Conectar**


## Como fazer um restart limpo do docker

Stop the container(s) using the following command:

    $ docker-compose down

Delete all containers using the following command:

    $ docker rm -f $(docker ps -a -q)

Delete all volumes using the following command:

    $ docker volume rm $(docker volume ls -q)

Restart the containers using the following command:

    $ docker-compose up -d

