
create table IF NOT EXISTS address(id int auto_increment primary key,street varchar(255),door varchar (255),locality varchar (255),state varchar (255));
create table IF NOT EXISTS patients(id int auto_increment primary key,name varchar(255),lastname varchar (255),dni varchar (255),DateInit TIMESTAMP WITHOUT TIME ZONE,address_id int);

