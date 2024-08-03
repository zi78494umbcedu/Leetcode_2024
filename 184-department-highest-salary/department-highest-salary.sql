# Write your MySQL query statement below

select d.name as Department, e.name as Employee, e.salary 
from employee e
join department d on d.id = e.departmentId
join ( 
select max(salary) as maxiS,departmentId from employee
group by departmentId) as maxi on maxi.departmentId = e.departmentId
where maxi.maxiS=e.salary;