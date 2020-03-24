drop table if exists user;

create table user (
    id serial primary key,
    user_id varchar(64),
    password varchar(64),
    email varchar(64)
);