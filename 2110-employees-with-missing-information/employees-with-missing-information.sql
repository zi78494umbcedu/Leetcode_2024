# Write your MySQL query statement below


select e.employee_id 
from employees e
left join salaries s 
on s.employee_id=e.employee_id
where s.employee_id is null
union 
select s.employee_id 
from salaries s
left join employees e
on s.employee_id=e.employee_id
where e.name is null
order by employee_id