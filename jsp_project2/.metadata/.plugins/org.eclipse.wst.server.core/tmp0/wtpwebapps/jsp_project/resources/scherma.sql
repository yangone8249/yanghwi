create user ‘jspuser’@’localhost’ identified by ‘mysql’;
grant all privileges on javadb.* to ‘javauser’@’localhost’ with grant option;
flush privileges;

create database jspdb;

create TABLE member(
num int auto_INCREMENT,
id varchar(100),
password varchar(100),
email varchar(100),
name varchar(20),
age int,
address varchar(50),
regdate DATEtime default now(),
phone VARCHAR(15),
lastLogin datetime DEFAULT null,
primary KEY(num));

-- 2023-05-17 새로 추가한 조회수 칼럼(속성) --
alter TABLE board add counter int DEFAULT 0;