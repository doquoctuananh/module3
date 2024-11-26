create database users;

use users;

create table User(
	id int not null auto_increment primary key,
    name varchar(30) not null,
    email varchar(50) ,
    country varchar(30)
);

insert into User(name,email,country)
values("tuan anh","anh@gamil.com","viet nam"),
("peter","peter@gamil.com","America");