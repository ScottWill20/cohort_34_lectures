use dwmh;

select * from state;

select * from user;
select * from location;
select * from all_reservations;

select *
from all_reservations r
join location l on location_id = r.location_id
join user gu on gu.user_id = r.user_id
join user lu on lu.user_id = l.user_id
join state ls on ls.state_id = l.state_id -- locations state
join state gs on gs.state_id = gu.state_id -- guest state
join state lus on lus.state_id = lu.state_id -- host state

where lu.last_name like 'Y%'
order by lu.first_name, lu.last_name;