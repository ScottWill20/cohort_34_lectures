set sql_safe_updates=0;
delete from hero_power;
delete from hero;
delete from power;
set sql_safe_updates=1;

alter table hero auto_increment=1;
alter table power auto_increment=1;

insert into power (power_id, name) values
	(1, 'Flight'),
    (2, 'Weapon Master'),
    (3, 'Healing'),
    (4, 'Illusion Casting'),
    (5, 'Strength'),
    (6, 'Phasing/Ghost'),
    (7, 'Claws'),
    (8, 'Lie Detection'),
    (9, 'Red Magic'),
    (10, 'Telekinesis');
    
insert into hero (hero_id, super_name, real_name, image_url) values
	(1, 'Alana', 'Alana', 'https://comicvine.gamespot.com/a/uploads/scale_small/6/66303/2242737-screen_shot_2012_03_14_at_11.48.47_am.png'),
    (2, 'Marko', 'Marko', 'https://comicvine.gamespot.com/a/uploads/scale_small/6/66303/2242736-screen_shot_2012_03_14_at_11.50.26_am.png'),
    (3, 'Lying Cat', 'Lying Cat', 'https://comicvine.gamespot.com/a/uploads/scale_small/4/48605/3394430-5213637296-tumbl.png'),
    (4, 'Izabel', 'Izabel', 'https://comicvine.gamespot.com/a/uploads/scale_small/6/66303/2347599-screen_shot_2012_05_16_at_11.01.38_am.png');
    
insert into hero_power (hero_id, power_id) values
	(1, 1),
    (1, 2),
    (2, 3),
    (3, 7),
    (3, 8),
    (4, 6);