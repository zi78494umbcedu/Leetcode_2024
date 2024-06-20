# Write your MySQL query statement below


select employee_id, 
coalesce(
    (select salary 
    from Employees
    where name not like 'M%'
    and employee_id%2!=0
    and e.employee_id=employee_id
    ), 0)  as bonus 
from employees e
order by employee_id
