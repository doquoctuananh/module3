create database manager_traffic;

use manager_traffic;

create table province(
code int not null primary key auto_increment,
name varchar(30) not null unique
);


create table person(
id int not null primary key auto_increment,
name varchar(50),
address varchar(30),
birthday date,
phone varchar(10),
email varchar(50)
);
alter table person add unique(phone);
alter table person add unique(email);
alter table person add column id_province int not null;
alter table person add foreign key(id_province) references province(code);
insert into person(name,address,birthday,phone,email,id_province) 
values ("tuan anh","Xom dong phu xa dong hieu","2001/04/12","0968955144","tuanhanh@gmail.com",8);

create table vehicle(
id int not null primary key auto_increment,
yearManafactured date not null ,
manafacture varchar(30),
price double check(price>0),
color varchar(20),
id_province int not null,
id_person int not null
);
alter table vehicle add foreign key(id_province) references province(code);
alter table vehicle add foreign key (id_person) references person(id);

insert into vehicle (yearManafactured,manafacture,price,color,id_province,id_person)
values("2024-01-01","Susuki",20000000,"yellow",8,1);
insert into vehicle (yearManafactured,manafacture,price,color,id_province,id_person)
values("2023-01-01","Ford",100000000,"grey",11,3);


create table car(
	 id int not null,
     numberSeats int not null,
     foreign key(id) references vehicle(id)
);
insert into car(id,numberSeats) values(6,7);

create table motorbike(
	id int not null,
    speed double not null,
    foreign key (id) references vehicle(id)
);
insert into motorbike(id,speed) values(1,120);

select v.*,m.speed from vehicle as  v
join motorbike as m on v.id = m.id;

select v.*,c.numberSeats from vehicle as  v
join car as c on v.id = c.id;


