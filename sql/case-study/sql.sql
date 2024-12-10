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
phone varchar(10) unique,
email varchar(50) unique,
id_province int not null
);

alter table person add foreign key(id_province) references province(code);
select v.*,c.numberSeats from vehicle as v join car as c on v.id = c.id where v.id = 30;

create table vehicle(
id int not null primary key auto_increment,
yearManafactured date not null ,
manafacture varchar(30),
price double check(price>0),
color varchar(20),
id_province int not null,
id_person int not null,
typeVehicle varchar(30)
);

alter table vehicle add foreign key(id_province) references province(code);
alter table vehicle add foreign key (id_person) references person(id);

create table car(
	 id int not null primary key,
     numberSeats int not null,
     foreign key(id) references vehicle(id)
);
insert into car(id,numberSeats) values(10,5);

create table motorbike(
	id int not null primary key,
    speed double not null,
    foreign key (id) references vehicle(id)
);




