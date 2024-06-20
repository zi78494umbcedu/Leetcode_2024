# Write your MySQL query statement below


-- entries with not M and odd employee_id
select employee_id, 
case 
when employee_id%2<>0 and name not like 'M%' then salary 
else 0
end 
as bonus 
from employees
order by employee_id

-- select employee_id, 
-- coalesce(
--     (select salary 
--     from Employees
--     where name not like 'M%'
--     and employee_id%2!=0
--     and e.employee_id=employee_id
--     ), 0)  as bonus 
-- from employees e
-- order by employee_id
