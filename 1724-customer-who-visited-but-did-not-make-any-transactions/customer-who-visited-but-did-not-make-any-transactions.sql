# Write your MySQL query statement below


select customer_id, count(customer_id) as count_no_trans
from visits v
left join Transactions t
on t.visit_id = v.visit_id
where t.transaction_id is null
group by customer_id
