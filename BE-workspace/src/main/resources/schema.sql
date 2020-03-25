drop table if exists user;
drop table if exists interest;

create table user (
    id bigint auto_increment primary key,
    user_id varchar(64),
    password varchar(64),
    email varchar(64),
    username varchar,
    gender varchar,
    mobile varchar,
    birth_date varchar
);

create table interest
(
    id bigint auto_increment primary key ,
    interest_name varchar,
    user_id bigint references user(id),
    interest_key int
)


