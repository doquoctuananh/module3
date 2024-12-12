create database finalmodule3;
use finalmodule3;

create table category(
id int not null primary key auto_increment,
name varchar(50) not null unique
);

insert into category(name)
values("phone"),
("tivi"),
("computer"),
("may giat");

create table product(
id int not null primary key auto_increment,
name varchar(50) not null,
price double not null,
quantity int,
color varchar(30),
description text,
id_category int,
foreign key(id_category) references category(id)
);
INSERT INTO product (name, price, quantity, color, description, id_category)
VALUES 
('Laptop Dell Inspiron', 750.00, 10, 'Silver', 'A powerful laptop with 16GB RAM and 512GB SSD.', 1),
('Smartphone Samsung Galaxy', 500.00, 15, 'Black', 'Latest model with 5G connectivity and 128GB storage.', 2);


