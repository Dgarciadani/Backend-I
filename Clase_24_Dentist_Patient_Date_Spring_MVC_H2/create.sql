create table IF NOT EXISTS Patients(id int primary key auto_increment, name varchar(255), lastname varchar(255), address_id int, dni int, date_init TIMESTAMP WITHOUT TIME ZONE);
create table IF NOT EXISTS Address(id int primary key auto_increment, street varchar(255), door int, city varchar(255), state varchar(255));
create table IF NOT EXISTS Dentists(id int primary key auto_increment, name varchar(255), lastname varchar(255), register int);
create table IF NOT EXISTS Appointments(id int primary key auto_increment, patient_id int, dentist_id int, date_init TIMESTAMP WITHOUT TIME ZONE);
