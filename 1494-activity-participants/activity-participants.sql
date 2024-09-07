# Write your MySQL query statement below
with max_cnt as 
(select max(cnt) max_count
from (
select count(*) cnt from friends
group by activity
) t2),
min_cnt as
(select min(cnt) min_count
from (
select count(*) cnt from friends
group by activity
) t3)
select activity 
from 
(
select activity, count(*) as act_cnt from friends 
group by activity 
having act_cnt != (select max_count from max_cnt)
and act_cnt != (select min_count from min_cnt)
) t1;
