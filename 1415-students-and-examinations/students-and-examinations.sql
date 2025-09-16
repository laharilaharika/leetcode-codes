select st.student_id,st.student_name,
sb.subject_name,
count(ex.subject_name) as attended_exams
from Students as st
join Subjects as sb 
left join Examinations as ex 
on st.student_id=ex.student_id
and sb.subject_name=ex.subject_name
group by st.student_id,sb.subject_name
order by st.student_id,sb.subject_name;