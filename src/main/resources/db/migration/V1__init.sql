drop table if exists Member;

create table Member (
    id int primary key auto_increment,
    nickname varchar(50),
    age int
);

drop table if exists Artist;

create table ARTIST (
    ID int primary key auto_increment,
    NAME varchar(255),
    DESCRIPTION TEXT,
    COUNTRY varchar(255),
    BIRTHDAY DATE,
    AGENCY_NAME varchar(255),
    CREATED_AT DATETIME,
    CREATED_BY varchar(255)
);
