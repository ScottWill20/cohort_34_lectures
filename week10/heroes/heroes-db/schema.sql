drop database if exists heroes;
create database heroes;
use heroes;

create table power (
	power_id int primary key auto_increment,
    name varchar(50) not null
);

create table hero (
	hero_id int primary key auto_increment,
    super_name varchar(50) not null,
    real_name varchar(50) not null,
    image_url varchar(512) null
);

create table hero_power (
	hero_id int not null,
    power_id int not null,
    constraint pk_hero_power
		primary key(hero_id, power_id),
	constraint fk_hero_power_hero_id
		foreign key(hero_id)
        references hero(hero_id),
	constraint fk_hero_power_power_id
		foreign key (power_id)
        references power(power_id)
);