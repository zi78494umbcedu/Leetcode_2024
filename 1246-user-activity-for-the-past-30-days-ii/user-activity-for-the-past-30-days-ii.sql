select ifnull(round(count(distinct(session_id))/count(distinct(user_id)), 2), 0)
as average_sessions_per_user
from activity
WHERE activity_date >= '2019-06-28' and activity_date <= '2019-07-27';  
