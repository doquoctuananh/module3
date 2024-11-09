create database view_store_index;
use view_store_index;

create table products(
	id int primary key auto_increment,
    productCode varchar(50),
    productName varchar(50),
    productPrice float,
    productAmount int,
    productDescription varchar(50),
    productStatus bit
);

INSERT INTO products (productCode, productName, productPrice, productAmount, productDescription, productStatus) VALUES
('P001', 'Laptop Dell', 1500.00, 10, 'High-end laptop', 1),
('P002', 'iPhone 12', 999.99, 5, 'Latest Apple smartphone', 1),
('P003', 'Samsung Galaxy S21', 850.50, 8, 'Samsung flagship phone', 1),
('P004', 'Sony Headphones', 199.99, 15, 'Noise-cancelling headphones', 1),
('P005', 'Smart Watch', 249.99, 20, 'Water-resistant smartwatch', 1),
('P006', 'Gaming Keyboard', 89.99, 12, 'RGB mechanical keyboard', 1),
('P007', 'Wireless Mouse', 25.00, 30, 'Ergonomic wireless mouse', 1);


create unique index index_productcode on products(productCode);

create index index_name_price on products(productName,productPrice);

create view view_product as
select p.productCode,p.productName,p.productPrice,p.productStatus
from products as p;

select * from view_product;

update view_product set view_product.productstatus = 0 where view_product.productCode ='P001';
drop view view_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create  procedure procedure_product ()
begin
	select * from products;
    
end //
delimiter ; 

--  Tạo store procedure sửa thông tin sản phẩm theo id

delimiter //
create procedure updateId 
(id int,
    productName varchar(50)
)
begin
	update products as p set p.productName = productName where p.id = id;
end //
delimiter ;

call updateId(2,'iphone 16');

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure addProducts 
(productCode varchar(50),
    productName varchar(50),
    productPrice float,
    productAmount int,
    productDescription varchar(50),
    productStatus bit)
begin
	insert into product (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    values (productCode, productName, productPrice, productAmount, productDescription, productStatus);
end //
delimiter ;

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure deleteId(id int)
begin
	delete from products as p where p.id = id;
end //
delimiter ;

call deleteId(7);