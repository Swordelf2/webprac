-- DBMS: PostgreSQL


alter database comoperator
    set datestyle to ISO, DMY;

set datestyle to ISO, DMY;

--
-- Create Statements
--

create table Author (
    id serial PRIMARY KEY,
    name varchar(30) not null
);

create table Publisher (
    id serial PRIMARY KEY,
    name varchar(30) not null
);

create table Book (
    id serial,
    author_id integer not null,
    title varchar(30)
);

\i db_insert.sql

alter table Book add constraint fk_book_author_id foreign key (author_id) references Author(id);
--alter table Book add constraint fk_book_publisherid foreign key (PublisherID) references Publisher(PublisherID);
