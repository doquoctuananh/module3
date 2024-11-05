create database quanlybanhang;
use quanlybanhang;

create table customer(
	cID int primary key auto_increment,
    cName varchar(50),
    cAge tinyint
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
alter table orderDetail add foreign key (pId) references product(pId);

insert into customer(cName,cAge)
values ('Minh Quan',10),
('Ngoc Oanh',20),
('Homng Ha',30);

insert into orders (cid,odate,ototalprice)
values(1,'2006-3-21',null),
(2,'2006-3-23',null),
(1,'2006-3-16',null);

insert into product (pname,pprice)
values('May giat',3),('Tu Lanh',5),
('Dieu Hoa',7),('Quat',1),
('Bep DIen',2);

insert into orderDetail (oId,pId,odQuanity)
values(1,1,3),(1,3,7),
(1,4,2),(2,1,1),
(3,1,8),(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select o.oid,o.odate,  p.pPrice * odet.odQuanity  
from orders as o
join orderdetail as odet on o.oid = odet.oid
join product as p on p.pid = odet.pid;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.cname,p.pname  from customer as c
join orders as o on c.cid = o.cid
join orderdetail as ode on o.oid = ode.oid
join product as p on p.pid = ode.pid;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.cname from customer as c where c.cid not in(
select distinct c.cid  from customer as c
join orders as o on o.cid = c.cid
join orderdetail as ode on o.oid = ode.oid
join product as p on p.pid = ode.pid);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o.oid,o.odate, sum( p.pPrice * odet.odQuanity )
from orders as o
join orderdetail as odet on o.oid = odet.oid
join product as p on p.pid = odet.pid
group by o.oid 
