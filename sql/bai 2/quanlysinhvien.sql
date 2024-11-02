create database quanlysinhvien;
use quanlysinhvien;

create table class(
	classId int primary key auto_increment,
    className varchar(60) not null,
    startDate datetime,
    status bit
);

create table student(
	studentId int primary key auto_increment,
    studentname varchar(50),
    address varchar(50),
    phone varchar(20),
    status bit,
    classId int not null ,
    foreign key (classId) references class(classId)
);

create table subject(
	subId int primary key auto_increment,
    subName varchar(30) not null,
    credit tinyint default 1 check(credit >=1),
    status bit default 1
);

create table  mark(
	markId int primary key auto_increment,
    subId int not null unique,
    studentId int not null unique,
    mark float default 0 check (0<= mark <=100),
    examtimes tinyint default 1,
    foreign key (subId) references subject(subId),
    foreign key (studentId) references student(studentId)
);

