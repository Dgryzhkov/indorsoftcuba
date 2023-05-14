create table INDORSOFTKUBA_PROJECT_EMPLOYEE_LINK (
    EMPLOYEE_ID varchar(36) not null,
    PROJECT_ID varchar(36) not null,
    primary key (EMPLOYEE_ID, PROJECT_ID)
);
