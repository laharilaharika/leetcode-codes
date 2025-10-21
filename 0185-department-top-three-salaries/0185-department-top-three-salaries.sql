select D.Name as Department, E.Name as Employee, E.salary
from Department D,Employee E, Employee E2
where D.id=E.DepartmentId and E.DepartmentId= E2.DepartmentId and
E.salary<=E2.salary
group by D.id,E.Name having count(distinct E2.salary)<=3
order by D.Name,E.salary desc;