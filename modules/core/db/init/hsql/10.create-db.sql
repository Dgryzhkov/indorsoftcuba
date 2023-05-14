-- begin INDORSOFTKUBA_PROJECT
create table INDORSOFTKUBA_PROJECT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end INDORSOFTKUBA_PROJECT
-- begin INDORSOFTKUBA_EMPLOYEE
create table INDORSOFTKUBA_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end INDORSOFTKUBA_EMPLOYEE
-- begin INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK
create table INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK (
    EMPLOYEE_ID varchar(36) not null,
    PROJECT_ID varchar(36) not null,
    primary key (EMPLOYEE_ID, PROJECT_ID)
)^
-- end INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK
