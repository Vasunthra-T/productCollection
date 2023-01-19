create table product(
id int primary key,
product_id int not null,
product_name varchar(30),
stock int,
price int,
gst int
)
create table wholesaler(
id int primary key,
product_id int not null,
wholesaler_id int not null,
wholesaler_name varchar(30),
constraint pr_id_fk foreign key (product_id) references product(id)
)

create table retailer(
id int primary key,
wholesaler_id int not null,
retailer_id int not null,
retailer_name varchar(30),
constraint ws_id_fk foreign key (wholesaler_id) references wholesaler(id)
)

insert into  wholesaler (id,product_id,wholesaler_id,wholesaler_name)
values (1,101,201,'Coimbatore'),
 (2,102,202,'Erode'),
  (3,101,203,'Tirupur')
  
 insert into  product (id,product_id,product_name,stock,price,gst)
values (1,101,'Laptop',1000,45000,18),
 (2,102,'Mobile',1200,20000,15),
  (3,103,'Keyboard',800,1000,10)
  
  alter table retailer add column product_id  int

  
  insert into retailer(id,product_id,wholesaler_id,retailer_id,retailer_name)
values (1,101,201,301,'Dell'),
 (2,102,202,302,'HP'),
  (3,101,203,303,'Asus')
  
 update wholesaler set wholesaler_id=4 where id=1
  
  update retailer set retailer_name='Mac' where id=1
  
  select * from wholesaler where product_id=101
  
delete from product 
where product_id=1

select * from product

select id,wholesaler_name as name  from wholesaler order by 2 asc, name desc

select upper(retailer_name) from retailer where lower(retailer_name) like '%a%'


select * from product where stock between 500 and 800


select product_id,count(1) from wholesaler group by 1




select * from retailer limit 2 offset 2

select count(1) from product





 

