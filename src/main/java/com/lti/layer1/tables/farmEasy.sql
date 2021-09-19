drop table bank_details cascade constraints;
drop table address_details  cascade constraints;
drop table farmer_details  cascade constraints;
drop table farmer_land_details  cascade constraints;
drop table bidder_details  cascade constraints;
drop table sell_request  cascade constraints;
drop table live_bid  cascade constraints;
drop table crop_details  cascade constraints;
drop table insurance_form  cascade constraints;



create table bank_details
( 
account_id number,
account_num varchar2(15),
ifsc_code varchar2(15),
 
Constraint accountid_pk1 Primary Key(account_id)
);

insert into bank_details values(1001,'6892847734','SBI1008976');
insert into bank_details values(1002,'2947687388','SBI1008977');
insert into bank_details values(1003,'4907648389','PNB100987');
insert into bank_details values(1004,'2098376389','BOB189376');





create table address_details
(
address_id number,
address_line varchar2(20),
city varchar2(15),
state varchar2(15),
Pincode number(10),
Constraint address_id_pk2 Primary Key(address_id)
);

Insert into address_details values (2001, '501-Park avenue', 'Bhagalpur', 'Bihar', 812006);
Insert into address_details values (2002, '502-Park avenue', 'Kota', 'Rajasthan', 324009);
Insert into address_details values (2003, '805-casa rio', 'Guwahati ', 'Assam', 783380);
Insert into address_details values (2004, '509-green avenue', 'Bhopal', 'MP', 535645);

create table farmer_details(
  farmer_email varchar2(20) primary key,
  farmer_name varchar2(15),
  contact_num varchar2(10),
  password varchar2(10),
  soil_ph_cert varchar2(15),
  aadhar_number varchar2(15),
  pancard_number varchar2(15),
  account_id number,
  address_id number,
  constraint acc_fk1 foreign key (account_id) references bank_details(account_id),
  constraint add_fk1 foreign key (address_id) references address_details(address_id)
    ) ;

Insert into farmer_details values('aamir18@gmail.com', 'Aamir', '9067856450', 'abc@123', 'PR69875', '458678950876', 'FXXP567801', 1001, 2001);
Insert into farmer_details values('archit96@gmail.com', 'Archit', '9850765430', 'abcd1996', 'SC89600', '567480987540', 'FAHP577815', 1002, 2002);


create table bidder_details(
  bidder_email varchar2(20) primary key,
  bidder_name varchar2(15),
  contact_num varchar2(10),
  password varchar2(10),
  trader_license varchar2(15),
  aadhar_number varchar2(15),
  pancard_number varchar2(15),
   account_id number,
  address_id number,
  constraint acc_fk2 foreign key (account_id) references bank_details(account_id),
  constraint add_fk2 foreign key (address_id) references address_details(address_id)
    )  ;

insert into bidder_details values('karan@gmail.com','Karan','7032589741','happy@123','KC74185202','196285201478','BZNP987521', 1003, 2003);

insert into bidder_details values('aditya@gmail.com','Aditya','9897416521','adit#123','AB74185203','196285201570','BZNP989622', 1004, 2004);



create table crop_details(
   crop_name varchar2(15) primary key,
   crop_type varchar2(15),
   msp float);



insert into crop_details values('Rice','Kharif',40);
insert into crop_details values('Barley','Rabi',50);



create table farmer_land_details(
farmer_email varchar2(20),
Land_area float ,
land_address varchar2(20) ,
land_pincode number,
Constraint Land_address_pk Primary Key(land_address),
Constraint farmer_email_fk Foreign Key(farmer_email) references farmer_details(farmer_email)
);

insert into farmer_land_details values('aamir18@gmail.com',50,'Bhagalpur', 812004);
insert into farmer_land_details values('archit96@gmail.com',60,'Kota', 324009);


create table sell_request(
  sell_id number primary key,
  crop_name varchar2(15),
  base_price number,
  fertilizer varchar2(20),
  quantity_kg float,
  sellreq_status varchar2(20),
  farmer_email varchar2(20),
  sellreq_date date ,
  sold_date date ,
  sold_price float ,
  total_price float,
 Constraint selldate check(sold_date>=sellreq_date),
  Constraint sellprice check (sold_price>=base_price),	
  Constraint sell_req_fk1 foreign key (farmer_email) references farmer_details (farmer_email),
  Constraint sell_req_fk2 foreign key (crop_name) references crop_details (crop_name) );

insert into sell_request values(101,'Rice',50,'Nitrogen',100,'Approved','aamir18@gmail.com','1-DEC-20','3-DEC-20',55,5500);
insert into sell_request values(102,'Barley',60,'Phosphorous',80,'Approved','archit96@gmail.com','5-DEC-20','8-DEC-20',65,5200);





create table live_bid
(
bid_id number,
sell_id number,
bidder_email varchar2(20),
bidder_amt float,
bid_req_date date,
Constraint livebid_bidid_pk Primary Key (bid_id),
Constraint bidder_email_fk Foreign key (bidder_email) references bidder_details (bidder_email)
);

Insert into live_bid values(201,101,'karan@gmail.com',52,'2-DEC-20');
Insert into live_bid values(202,101,'aditya@gmail.com',55,'3-DEC-20');
Insert into live_bid values(203,102,'karan@gmail.com',63,'7-DEC-20');
Insert into live_bid values(204,102,'aditya@gmail.com',65,'8-DEC-20');



create table insurance_form
(
farmer_email varchar2(20),
insurance_comp varchar2(15),
share_premium float,
premium_amt float,
crop_name varchar2(15),
tot_sum_insured float,
policy_num number ,
insurance_date date,
end_date date,
insuree_name varchar2(15),
loss_cause varchar2(20),
loss_date date,
Constraint insform_policynum_pk Primary Key (policy_num),
Constraint farmer_email_fk1 Foreign Key (farmer_email) references farmer_details (farmer_email)
);

insert into insurance_form
values ('archit96@gmail.com', 'LIC', 800, 2000, 'Barley', 50000, 1019876540, '1-JAN-20', '1-JAN-21', 'Archit', NULL, NULL);













