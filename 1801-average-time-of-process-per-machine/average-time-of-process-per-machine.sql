# Write your MySQL query statement below
select machine_id ,
round(avg(a.timestamp - (select timestamp from activity where a.machine_id=machine_id and a.process_id=process_id and activity_type='start')),3) as processing_time
from activity a
where activity_type='end'
group by  machine_id