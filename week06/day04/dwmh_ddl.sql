
drop database if exists dwmh;
create database dwmh;
use dwmh;

create table state (
state_id int primary key auto_increment,
state_name varchar(2) not null
);

create table user (
user_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(250) not null,
phone varchar(50) not null,
state_id int not null,
	constraint fk_user_state
		foreign key (state_id)
        references state(state_id)  
);

create table location (
location_id int primary key auto_increment,
user_id int not null,
address varchar(100) not null,
city varchar(200) not null,
state_id int not null,
postal_code varchar(20) not null,
standard_rate decimal(8,2) not null,
weekend_rate decimal(8,2) not null,
	constraint fk_location_user
		foreign key (user_id)
        references user(user_id),
	constraint fk_location_state
		foreign key (state_id)
        references user(state_id)    
);

create table reservation (
reservation_id int primary key auto_increment,
location_id int not null,
user_id int not null,
start_date date not null,
end_date date not null,
total decimal(8,2) not null,
	constraint fk_reservation_location
		foreign key (location_id)
        references location(location_id),
	constraint fk_reservation_user
		foreign key (user_id)
        references user(user_id)
);


    

