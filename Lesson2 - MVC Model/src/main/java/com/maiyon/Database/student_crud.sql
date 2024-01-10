drop schema if exists student_crud;
create schema if not exists student_crud;
use student_crud;

drop table if exists student;
create table if not exists student(
    student_id bigint,
    student_name varchar(100),
    age int,
    gender bit
);