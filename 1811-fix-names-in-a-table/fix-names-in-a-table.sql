# Write your MySQL query statement below
select user_id, Concat(Upper(Substr(name, 1,1)), lower(substr(name, 2, length(name)))) as name 
from users
order by user_id