drop schema if exists demo_spring_mvc;
create schema if not exists demo_spring_mvc;
use demo_spring_mvc;
drop table if exists category;
create table if not exists category(
    id int primary key auto_increment,
    name varchar(100) not null unique ,
    status bit(1) default(1)
);
drop table if exists product;
create table if not exists product(
    id int primary key auto_increment,
    name varchar(100) not null unique ,
    price float not null ,
    category_id int not null ,
    foreign key (category_id) references category(id),
    email varchar(255)
);
insert into category (id, name, status)
values (1, 'something', 1);