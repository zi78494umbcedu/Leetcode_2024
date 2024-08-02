# Write your MySQL query statement below

select id, name from students where id not in (
select s.id from students s
join departments d
on d.id=s.department_id)