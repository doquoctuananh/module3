create database quanlydiemthi;
use quanlydiemthi;

create table hocsinh(
	mahs varchar(20) primary key,
    tenhs varchar(50),
    ngsinh datetime,
    lop varchar(20),
    gtinh varchar(20)
);

create table monhoc(
	maMh varchar(20) primary key,
    tenMh varchar(50),
    maGv varchar(20)
);

create table bangdiem(
	maHs varchar(20) ,
    maMh varchar(50),
    diemthi int,
    ngayKt datetime,
    primary key(maHs,maMh),
    foreign key (maHs) references hocsinh(mahs),
    foreign key (maMh) references monhoc(maMh)
);

create table giaovien(
	magv varchar(20) primary key,
    tengv varchar(50),
    sdt varchar(10)
);

alter table monhoc add foreign key (maGv) references giaovien(magv)