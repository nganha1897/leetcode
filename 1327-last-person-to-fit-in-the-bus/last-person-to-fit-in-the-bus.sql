# Write your MySQL query statement below
with max_w as (
select person_id, person_name, turn, sum(weight) over (order by turn) as sum_w
from Queue
)
select person_name from max_w
where sum_w = 
(select max(sum_w) from max_w
where sum_w <= 1000
)
;
