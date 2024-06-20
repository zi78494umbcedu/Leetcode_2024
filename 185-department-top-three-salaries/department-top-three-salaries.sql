# Write your MySQL query statement below


select  d.name as Department, e.name as Employee, e.salary as Salary
from employee e
join department d on e.departmentId=d.id
where (select count(distinct salary) 
    from employee 
    where departmentId=e.departmentId and salary>e.salary)<3
order by d.name, e.salary desc