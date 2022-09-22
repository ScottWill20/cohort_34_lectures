use student_registrations;

select * 
from student 
where country = 'Argentina';

select * 
from student 
where last_name like 't%';

select * 
from student 
where country = 'Argentina'
order by gpa desc;

select * from student
order by gpa
limit 100;

select * from student
where country = 'Argentina'
order by gpa desc
limit 3,3;

select * from student where country = 'Maldives';

select * 
from student 
where email_address is null
	or email_address = "";

select count(r.course_id), concat(s.first_name, ' ', s.last_name)
    from student s
        inner join registration r on s.student_id = r.student_id
            group by s.student_id
                having count(r.course_id) = 5;


select * from student s
    inner join registration r on s.student_id = r.student_id
    inner join course c on r.course_id = c.course_id
        where c.title = 'Literary Genres';   








