create database dbproizvodi_53;

use dbproizvodi_53;


create table category
(
	CategoryId int not null auto_increment,
    Name varchar(50) not null,
    Gender varchar(1) not null default 'M',
    constraint PK_Category primary key(CategoryId)
);



insert into category(Name,Gender) values('Jackets','M');
insert into category(Name,Gender) values('Coats','M');
insert into category(Name,Gender) values('Jeans','M');
insert into category(Name,Gender) values('Accessories','M');
insert into category(Name,Gender) values('T-Shirt | POLOS','M');

insert into category(Name,Gender) values('Jackets','F');
insert into category(Name,Gender) values('Coats','F');
insert into category(Name,Gender) values('Jeans','F');
insert into category(Name,Gender) values('Accessories','F');
insert into category(Name,Gender) values('Skirts','F');
insert into category(Name,Gender) values('Shoes','F');
insert into category(Name,Gender) values('Bags','F');




select * from category





create table size
(
	SizeId int not null auto_increment,
    Size varchar(3) not null,
    constraint PK_Size primary key(SizeId)
);
insert into size (Size) values ("S");
insert into size (Size) values ("M");
insert into size (Size) values ("L");
insert into size (Size) values ("XL");
insert into size (Size) values ("XXL");
insert into size (Size) values ("N/A");



create table item
(
	ItemId int not null auto_increment,
    CategoryId int not null,
    SizeId int not null,
    Name varchar(50) not null,
	UnitPrice decimal(8,2) not null,
    Description varchar(1000),
    IsDiscounted bool not null,
    DiscountRate int,
    constraint PK_Item primary key(ItemId),
    constraint FK_Item_Category foreign key(CategoryId) references Category(CategoryId),
    constraint FK_Item_Size foreign key(SizeId) references Size(SizeId)
);


Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (1,5,'Standard denim jacket',55.55,'The ultimate denim jacket. Tailored to perfection in stretch denim that moves with you. Designed in a versatile medium wash with contrast stitching and functional pockets, this jacket is your go-to lightweight layer.',1,10);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (3,5,'Standard denim jeans',45.55,'The ultimate denim jeans. Tailored to perfection in stretch denim that moves with you. Designed in a versatile medium wash with contrast stitching and functional pockets, those jeans are your go-to lightweight layer.',1,10);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (4,6,'SWATCH',121.30,'Swatch was originally intended to re-capture entry level market share lost by Swiss manufacturers during the quartz crisis and the subsequent growth of Japanese companies such as Seiko and Citizen in the 1960s and 1970s, and to re-popularize analog watches at a time when digital watches had achieved wide popularity.',0,0);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (5,1,'Lacoste POLO',121.30,'Classic white Lacoste POLO T-Shirt.',0,0);

Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (6,5,'Standard denim jacket',55.55,'The ultimate denim jacket. Tailored to perfection in stretch denim that moves with you. Designed in a versatile medium wash with contrast stitching and functional pockets, this jacket is your go-to lightweight layer.',1,10);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (8,5,'Standard denim jeans',55.55,'The ultimate denim jeans. Tailored to perfection in stretch denim that moves with you. Designed in a versatile medium wash with contrast stitching and functional pockets, those jeans are your go-to lightweight layer.',1,10);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (9,6,'SWATCH',191.30,'Swatch was originally intended to re-capture entry level market share lost by Swiss manufacturers during the quartz crisis and the subsequent growth of Japanese companies such as Seiko and Citizen in the 1960s and 1970s, and to re-popularize analog watches at a time when digital watches had achieved wide popularity.',0,0);
Insert into item(CategoryId,SizeId,Name,UnitPrice,Description,IsDiscounted,DiscountRate) values (12,6,'Leather bag',121.30,'Classic black leather bag',0,0);




