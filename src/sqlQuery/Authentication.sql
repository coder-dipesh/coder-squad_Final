
create database codersquad;

#creating table to register for admin 

create table admin_register(
account_id int not null auto_increment,
first_name varchar(50)not null,
last_name varchar(50)not null,
email_id varchar(100)not null,
username varchar(50)not null,
password varchar(50)not null,
constraint pk_account_id primary key(account_id)
);


##creating table to register for client

create table client_register(
account_id int not null auto_increment,
first_name varchar(50)not null,
last_name varchar(50)not null,
email_id varchar(100)not null,
username varchar(50)not null,
password varchar(50)not null,
constraint pk_account_id primary key(account_id)
);

create table category(
category varchar(50),
constraint pk_category primary key(category)
);

create table product_admin(
product_id int not null,
product_name varchar(50) not null,
product_qty int not null,
category varchar(50) not null,
price int not null,
description varchar(200),
constraint pk_product_id primary key(product_id)
);



create table cart(
product_id int not null,
product_name varchar(50) not null,
product_qty int not null,
category varchar(50) not null,
price int not null,
description varchar(200),
constraint pk_product_id primary key(product_id)
);




select * from admin_register;
select * from client_register;
select * from product_admin;
select * from cart;
select * from category;


INSERT INTO product_admin VALUES(0122, 'Cooling fan' ,44, 'ELECTRONICS', 5000, 'A high quality laptop cooling pad');

INSERT INTO product_admin VALUES(0123, 'mobile phone' ,50,'ELECTRONICS',35500,'A high quality smart phone');
INSERT INTO product_admin VALUES(0124, 'Jacket' ,33,'CLOTHE',2000,'A high quality wind proof jacket');
INSERT INTO product_admin VALUES(0125, 'Tshirt' ,40,'CLOTHE',1200,'A high quality cotton shirt');
INSERT INTO product_admin VALUES(0126, 'Smart watch' ,47,'ELECTRONICS',7550,'1.47 large touch screen smart watch');
INSERT INTO product_admin VALUES(0127, 'Mobile stand' ,2,'ELECTRONICS',750, 'Mobile stand design with aluminium alloy');

INSERT INTO product_admin VALUES(0128, 'Keyboard' ,90,'ELECTRONICS',5000,'Mechanical keyboard with RGB light');
INSERT INTO product_admin VALUES(0129, 'Mouse' ,88,'ELECTRONICS',3500,'A gaming mouse with RGB light');
INSERT INTO product_admin VALUES(0130, 'Bed' ,77,'FURNITURE',35000,'European white bed size-5Ft*6.5Ft');
INSERT INTO product_admin VALUES(0131, 'Bed sheet' ,97,'CLOTHE',3500,'Double bed sheet printed in super vela with pillo covers');
INSERT INTO product_admin VALUES(0132, 'Bag' ,45,'BAG',2750,'A high quality leather bag');

INSERT INTO product_admin VALUES(0133, 'Halfpant' ,33,'CLOTHE',1985,'Summer cutton half pant');
INSERT INTO product_admin VALUES(0134, 'Kitchen lighter' ,22,'UTENSILS',350,'Classic cookware kitchen lighter fullus ss chrome');
INSERT INTO product_admin VALUES(0135, 'Pressure cooker' ,67,'UTENSILS',3100,'A high qualitY baltra megna pressure cooker');
INSERT INTO product_admin VALUES(0136, 'Rice cooker' ,2,'ELECTRONICS',4500,'Philips rice cooker 2 Ltr HD3119/66');
INSERT INTO product_admin VALUES(0137, 'Comb' ,44,'COSMETIC',100,'Pine wooden comb with handle');

INSERT INTO product_admin VALUES(0138, 'Laptop' ,50,'ELECTRONICS',880,'Lenovo ideaPad Slim 3 10th Gen');
INSERT INTO product_admin VALUES(0139, 'Nailpolish' ,33,'COSMETIC',2000,'Revlon nail Enamel 8ml');
INSERT INTO product_admin VALUES(0140, 'Hair dryer' ,40,'ELECTRONIC',1200,'Philips thermoprotect hair dryer HP8230/03');
INSERT INTO product_admin VALUES(0141, 'Trouser' ,47,'CLOLTHE',7550,'Free size 100% cutton trouser');
INSERT INTO product_admin VALUES(0142, 'Mobile charger' ,32,'ELECTRONICS',800, 'Mobile stand design with aluminium alloy');

INSERT INTO product_admin VALUES(0143, 'Pant' ,90,'CLOTHE',5000,'New stylist pant of brand name FOD');
INSERT INTO product_admin VALUES(0144, 'Fan' ,88,'ELECTRONICS',3500,'Alpha Home Mini Clip Electric Table Fan');
INSERT INTO product_admin VALUES(0145, 'Fridge' ,77,'ELECTRONIC',35000,'reba Chest Fridge HTGI 327');
INSERT INTO product_admin VALUES(0146, 'Oven' ,97,'ELECTRONIC',17000,'High quality ovan with aluminium tray ');
INSERT INTO product_admin VALUES(0147, 'Telivision' ,45,'ElECTRONIC',27500,'Videocon 32"  Android 9.0 smart Led Tv');

INSERT INTO product_admin VALUES(0148, 'Shoes' ,88,'SHOES',1985,'Goldstar shoes for women vibes golden white');
INSERT INTO product_admin VALUES(0149, 'Tablet' ,22,'ELECTRONIC',23500,' Apple ipadpro M1,11" 128GB Wifi');
INSERT INTO product_admin VALUES(0150, 'Fashwash' ,67,'COSMETIC',1100,'Acenes 3S Series');
INSERT INTO product_admin VALUES(0151, 'Table' ,2,'FURNITURE',4000,'Smart Multi-purpose laptop Table ');
INSERT INTO product_admin VALUES(0152, 'Coke' ,44,'SOFT DRINKS',5000,'Coca cola 2.25L pet');

INSERT INTO product_admin VALUES(0153, 'Gorkha Strong' ,50,'LIQUOR','15000','Gorkha strong beer bottle 650ml');
INSERT INTO product_admin VALUES(0154, 'Mixture Grinder' ,33,'ELECTRONIC',5500,'Baltra Dream 3 jar Mixer Grinder');
INSERT INTO product_admin VALUES(0155, 'Tracksuit' ,40,'CLOTHE',1200,'Premium Navy Blue cotton tracksuit');
INSERT INTO product_admin VALUES(0156, '8848 Vodka' ,47,'LIQUOR','1200','8848 Vodka 750ml');
INSERT INTO product_admin VALUES(0157, 'Dining Table' ,10,'FURNITURE',22000, 'Modern style dining set with 2 chair');

INSERT INTO product_admin VALUES(0158, 'Fanta' ,90,'SOFT DRINKS',425,'Fanta orange 2.25l pet');
INSERT INTO product_admin VALUES(0159, 'Monitor',24,'ELECTRONIC',3500,'Lenovo G25-10 Gaming Monitor 144hz Display');
INSERT INTO product_admin VALUES(0160, 'Iron' ,77,'ELECTRONIC',2500,'Konka 1399W Steam & Dry IRON (ES 280))');
INSERT INTO product_admin VALUES(0161, 'Wardrobe' ,97,'FURNITURE',35000,'Ply wood Wardrobe 4*6Ft');
INSERT INTO product_admin VALUES(0162, 'Printer' ,45,'ELECTRONIC',27500,'hP dESKJET 2130 All-In_One Printer');

INSERT INTO product_admin VALUES(0163, 'Multiplug' ,33,'ELECTRONIC',1985,'4 USB hexagon power socket Extension Plug Electrical outlet');
INSERT INTO product_admin VALUES(0164, 'Pen' ,22,'STATIONERY',350,'Bullet pen fish LSZ-5101');
INSERT INTO product_admin VALUES(0165, 'Copy' ,67,'STATIONERY',300,'Set of 6 class met Burj khalifa');
INSERT INTO product_admin VALUES(0166, 'Computer' ,2,'ELECTRONICS',55000,'Dell Optiplex 5270-I5-9500-8GB-TB');
INSERT INTO product_admin VALUES(0167, 'Body lotion' ,44,'COSMETIC',500,'NIVEA Body Lotion,Nourishing body milk,For Very Dry Skin,400ml');

INSERT INTO product_admin VALUES(0168, 'Shirt' ,50,'CLOTHE',3300,'SEA GREEN half Sleeves Cotton Shirt for men');
INSERT INTO product_admin VALUES(0169, 'Blanket' ,33,'CLOTHE',2000,'Soft heavy fieece polar blanket');
INSERT INTO product_admin VALUES(0170, 'Bulb' ,40,'ELECTRONIC',120,'Wega 3W Energy saving Led Bulb');
INSERT INTO product_admin VALUES(0171, 'Plate' ,47,'UTENSILS',75,'Stainless steel plate');
INSERT INTO product_admin VALUES(0172, 'Lays' ,2,'FOOD',75, 'LAys Magic Masala Chips');

INSERT INTO product_admin VALUES(0173, 'Kurkure' ,90,'FOOD',50,'Kurkure magic masala munch');
INSERT INTO product_admin VALUES(0174, 'Towel' ,88,'CLOTHE',350,'Korean Micro fiber towel');
INSERT INTO product_admin VALUES(0175, 'One piece' ,77,'CLOTHE',3500,'Bodycon one piece ladies dress');
INSERT INTO product_admin VALUES(0176, 'Boxer' ,97,'CLOTHE',350,'Robber original men printed Boxer');
INSERT INTO product_admin VALUES(0177, 'Two piece' ,45,'CLOTHE',2750,'Yello two piece tank top');

INSERT INTO product_admin VALUES(0178, 'Halfpant' ,33,'CLOTHE',1985,'Summer cutton half pant');
INSERT INTO product_admin VALUES(0179, 'Haircream' ,22,'COSMETIC',350,'A highquality THC hair cream');
INSERT INTO product_admin VALUES(0180, 'Khukuri rum' ,67,'LIQUOR',1740,'Khukuri XXX Rum 750ml');
INSERT INTO product_admin VALUES(0181, 'Bucket' ,2,'UTENSILS',500,'360 Spin mod blue');
INSERT INTO product_admin VALUES(0182, 'Tourch lilght' ,44,'ELECTRONICS',500,'LED sensor waterproof Tourchlight 9114W ');

INSERT INTO product_admin VALUES(0183, 'Shoe rack' ,50,'FURNITURE',7800,'Shoe rack made with high quality wood');
INSERT INTO product_admin VALUES(0184, 'Body moisturizer' ,33,'COSMETIC',2000,'vasline intensive care cocoa radiant');
INSERT INTO product_admin VALUES(0185, 'Half vest' ,40,'CLOTHE',1200,'Combo of 2 amul comfy white RNS half vest');
INSERT INTO product_admin VALUES(0186, 'Rice' ,47,'FOOD',1725,'Big choice premium jira masino rice 25kg');
INSERT INTO product_admin VALUES(0187, 'Mineral Water' ,2,'WATER',75, 'Kinley water(still) 1L PET');













