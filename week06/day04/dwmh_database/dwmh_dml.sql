-- insert into state
use dwmh;

insert into state (state_name)
	select distinct host_state state
    from all_reservations
    union -- combines result of 2 or more select statements
	select distinct guest_state state
    from all_reservations
    order by state; -- alphabetical order
    
-- insert into user

insert into user (first_name, last_name, email, phone, state_id)  
	select distinct guest_first_name, guest_last_name, guest_email, guest_phone, s.state_id
    from all_reservations ar
    inner join state s on s.state_name = ar.guest_state;
    
insert into user (first_name, last_name, email, phone, state_id)  
	select distinct host_first_name, host_last_name, host_email, host_phone, s.state_id
    from all_reservations ar
    inner join state s on s.state_name = ar.host_state;
    

-- insert into location

insert into location(user_id, address, city, postal_code, state_id, standard_rate, weekend_rate)   
select distinct u.user_id, host_address, host_city, host_postal_code, s.state_id, standard_rate, weekend_rate
from all_reservations ar
inner join user u on u.email = ar.host_email -- using a natural key to get a distinct host
inner join state s on s.state_name = ar.host_state;

select * from location;

-- insert into reservation

insert into reservation(location_id, user_id, start_date, end_date, total)
select l.location_id, u.user_id, ar.start_date, ar.end_date, ar.total
from all_reservations ar
inner join location l on l.address = ar.host_address -- unique in our data
inner join user u on u.email = ar.guest_email;

select * from reservation;
    