# Write your MySQL query statement below


select c.customer_id, c.name
from orders o
join product p
on o.product_id=p.product_id
join customers c
on o.customer_id=c.customer_id
group by customer_id
having sum(case when year(order_date)=2020 and month(order_date)=06 then quantity*price end)>=100
and
sum(case when year(order_date)=2020 and month(order_date)=07 then quantity*price end)>=100