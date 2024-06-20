# Write your MySQL query statement below


select requester_id as id,
(select count(*) from requestaccepted where id=requester_id or id=accepter_id) as num 
from requestaccepted
group by requester_id
union
select accepter_id as id,
(select count(*) from requestaccepted where id=requester_id or id=accepter_id) as num 
from requestaccepted
group by accepter_id
order by num desc
limit 1


