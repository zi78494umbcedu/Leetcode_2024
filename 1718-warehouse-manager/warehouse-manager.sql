# Write your MySQL query statement below



select w.name as warehouse_name,
sum(p.width*p.length*p.height*w.units) as volume
from warehouse w
join products p 
on w.product_id=p.product_id
group by w.name

