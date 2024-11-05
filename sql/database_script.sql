create database bms;
use bms;
show databases;
show tables;
create table signup (form_no varchar(20), name varchar(20), age varchar(20), dob varchar(20), gender varchar(20), email varchar(100));
create table additionaldetails (form_no varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(200), pan varchar(20), occupation varchar(20));
-- drop table signup
-- drop table additionaldetails
-- select * from signup; 
-- delete from signup where form_no = 9795;

-- select income from signup join additionalDetails where signup.form_no = additionaldetails.form_no;