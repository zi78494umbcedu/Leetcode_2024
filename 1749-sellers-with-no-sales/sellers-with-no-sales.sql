# Write your MySQL query statement below


select seller_name 
from seller 
where seller_id not in (select seller_id
from orders o
where o.sale_date like '2020%')
order by 1 asc;