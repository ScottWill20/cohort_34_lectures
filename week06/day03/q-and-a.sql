-- use student_registrations; 

-- select *
-- from major;

-- select * 
-- from student s
-- inner join major m on m.major_id = s.major_id;

-- show all students regardless of if they registered for a course

use student_registrations;

select *
from student s
left outer join registration r on r.student_id = s.student_id;

-- we are going to get every column on the left, regardless of if it has a match
-- on the right, only columns that have a match will be displayed


