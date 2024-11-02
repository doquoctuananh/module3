create database quanlybanhang;
use quanlybanhang;

create table customer(
	cID int primary key auto_increment,
    cName varchar(50),
    cAge date
);

create table orders (
	oId int primary key auto_increment,
    cId int,
    oDate date,
    oTotalprice float,
    foreign key (cId) references customer(cID)
);

create table product (
	pId int primary key auto_increment,
    pName varchar(50),
    pPrice float
);

create table orderDetail(
	oId int,
    pId int,
    odQuanity int,
    primary key(oId,pId)
);
alter table orderDetail add foreign key (oId) references orders(oId);
alter table orderDetail add foreign key (pId) references product(pId)