# Write your MySQL query statement below


select  distinct c.title from content c
join tvprogram tv
on tv.content_id=c.content_id
where c.kids_content='Y'
and c.content_type='Movies'
and tv.program_date like '2020-06%'