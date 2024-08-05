# Write your MySQL query statement below
select u.unique_id, e.name
from employees e
left join EmployeeUNI u 
on u.id=e.id