drop database if exists solar_farm;
create database solar_farm;
use solar_farm;

--  this.id = id;
--  this.section = section;
--  this.row = row;
--  this.column = column;
--  this.yearInstalled = yearInstalled;
-- 	this.material = material;
--  this.isTracking = isTracking;

create table solar_panel(
id int primary key auto_increment, 
section varchar(100) not null, 
`row` int not null, 
`column` int not null, 
year_installed int not null, 
material varchar(10),
is_tracking bit not null
);

