-- use solar_farm;
-- select * from solar_panel;

use solar_farm_test;
call set_known_good_state();
select * from solar_panel;