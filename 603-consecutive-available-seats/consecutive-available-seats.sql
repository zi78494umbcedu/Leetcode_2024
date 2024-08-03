select distinct b.seat_id 
from cinema a, cinema b
where abs(a.seat_id-b.seat_id)=1
and a.free=1 and b.free=1