# Write your MySQL query statement below
select x, y, z, (
    case 
    when y+z>x and z+x>y and x+y>z then 'Yes'
    else 'No'
    end
) as triangle
from Triangle