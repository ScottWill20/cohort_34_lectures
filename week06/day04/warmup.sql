
use student_registrations;

-- Print students who are currently registered for 5 courses.
select count(r.course_id), concat(s.first_name, ' ', s.last_name)
    from student s
        inner join registration r on s.student_id = r.student_id
            group by s.student_id
                having count(r.course_id) = 5;
                
-- Print students who are registered for the course "Literary Genres".
select * from student s
    inner join registration r on s.student_id = r.student_id
    inner join course c on r.course_id = c.course_id
        where c.title = 'Literary Genres';  
        
-- Who has the latest birthday? Who is the youngest?
select * from student s
	order by birth_date desc
    limit 1;

-- Who has the highest GPA? There may be a tie.
select * from student s
	order by gpa desc
    limit 5;

-- Print every course students are registered for, including repeats.
select 
	concat(s.first_name, ' ', s.last_name),
	c.title
from student s
    inner join registration r on s.student_id = r.student_id
    inner join course c on r.course_id = c.course_id
    order by title asc;

-- Print a distinct list of courses students are registered for.
select distinct(c.title)
from registration r
join course c on c.course_id = r.course_id;

-- Print a distinct list of courses students are registered for, ordered by name.
select title from course c
		order by title asc;
    
-- Count students per country.
select count(student_id) 'number of students', country
	from student
		group by country;
        
-- Count students per country. Order by most to fewest students.
select count(student_id) 'number of students', country
	from student
		group by country;

-- Count registrations per course.
select count(student_id), c.title
	from registration r
		inner join course c on r.course_id = c.course_id
			group by r.course_id;

-- How many registrations are not graded (GradeType = "Audit")?
select count(student_id), g.name
	from registration r
		inner join grade_type g on r.grade_type_id = g.grade_type_id
			where g.name = "Audit";

-- Create a student summary by selecting each student's country, major, and IQ; sort and limit by IQ (your choice of low or high).
select s.country, m.name, s.iq 
	from student s
    join major m on s.major_id = m.major_id
    order by iq desc;
    
-- What is the average GPA per country (remember, it's random fictional data).
select country c, avg(gpa)
from student
group by c;

-- What is the maximum GPA per country?
select country, max(gpa)
	from student
    group by country
    order by max(gpa) desc;
    
-- Print average IQ per Major ordered by IQ ascending.
select m.name as Major, avg(s.iq) as Average_IQ
	from student s
		inner join major m on s.major_id = m.major_id
        group by m.major_id
        order by Average_IQ desc;
        
-- Who has the highest pointPercent in "Sacred Writing"?
select concat(s.first_name, ' ', s.last_name) Name, c.title Course, r.point_percent 'Point Percent'
	from student s
        inner join registration r on s.student_id = r.student_id
		inner join course c on r.course_id = c.course_id
			where c.title = 'Sacred Writing' and r.point_percent = 
            (select max(r.point_percent) from registration r 
				join course c on r.course_id = c.course_id 
					where c.title = 'Sacred Writing');


