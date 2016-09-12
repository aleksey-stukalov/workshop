-- begin WORKSHOP_CLIENT
create table WORKSHOP_CLIENT (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE_NUMBER varchar(50) not null,
    EMAIL varchar(20) not null,
    --
    primary key (ID)
)^
-- end WORKSHOP_CLIENT
-- begin WORKSHOP_MECHANIC
create table WORKSHOP_MECHANIC (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    HOURLY_RATE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end WORKSHOP_MECHANIC
-- begin WORKSHOP_SPARE_PART
create table WORKSHOP_SPARE_PART (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    DESCRIPTION longvarchar,
    PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end WORKSHOP_SPARE_PART
-- begin WORKSHOP_ORDER
create table WORKSHOP_ORDER (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_ID varchar(36) not null,
    MECHANIC_ID varchar(36) not null,
    DESCRIPTION longvarchar,
    HOURS_SPENT integer,
    AMOUNT decimal(19, 2),
    STATUS integer,
    --
    primary key (ID)
)^
-- end WORKSHOP_ORDER
-- begin WORKSHOP_ORDER_SPARE_PART_LINK
create table WORKSHOP_ORDER_SPARE_PART_LINK (
    ORDER_ID varchar(36) not null,
    SPARE_PART_ID varchar(36) not null,
    primary key (ORDER_ID, SPARE_PART_ID)
)^
-- end WORKSHOP_ORDER_SPARE_PART_LINK
