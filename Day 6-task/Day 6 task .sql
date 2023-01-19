create table warehouse 
(
id int primary key,
wcode varchar(20) not null,
wname varchar(30)
);

create table product
(
id int primary key,
pcode varchar(20) not null,
pname varchar(30),
price int,
gst decimal
);

create table warehouse_stock
(
id int primary key,
wid int,
pid int,
wstock int,
constraint wfk foreign key (wid) references warehouse(id),
constraint pfk foreign key (pid) references product(id)
);

create table wholesaler
(
id int primary key,
whcode varchar(20) not null,
whname varchar(30)
);

create table wholesaler_stock
(
id int primary key,
wid int,
pid int,
whid int,
whstock int,
pmargin int,
constraint wfk foreign key (wid) references warehouse(id),
constraint pfk foreign key (pid) references product(id),
constraint whfk foreign key (whid) references wholesaler(id)
);

create table retailer
(
id int primary key,
rcode varchar(20) not null,
rname varchar(30)
);

create table retailer_stock
(
id int primary key,
rid int,
pid int,
whid int,
rstock int,
pmargin int,
constraint rfk foreign key rid references retailer(id),
constraint pfk foreign key pid references product(id),
constraint whfk foreign key whid references wholesaler(id)
);

drop table warehouse;
drop table warehouse_stock;
drop table product;
drop table wholesaler;
drop table wholesaler_stock;
drop table retailer;
drop table retailer_stock;

insert into warehouse (id,wcode,wname)
values(1,'W001','AAA'),
(2,'W002','BBB'),
(3,'W003','CCC')

insert into product(id,pcode,pname,price,gst)
values(1,'P001','Laptop',40000,18),
(2,'P002','Mobile',12000,17.5),
(3,'P003','Keyboard',1000,15)

insert into warehouse_stock (id,wid,pid,wstock)
values(1,1,1,500),
(2,1,2,1000),
(3,2,1,1500)

insert into wholesaler (id,whcode,whname)
values(1,'WH001','ABC'),
(2,'WH002','CBE'),
(3,'WH003','Chennai')

insert into wholesaler_stock (id,wid,pid,whid,whstock,pmargin)
values(1,1,1,1,400,42000)

update wholesaler set wholesaler_id=4 where id=1
  
  update retailer set retailer_name='Mac' where id=1
  
  select * from wholesaler where product_id=101
  
delete from product 
where product_id=1






