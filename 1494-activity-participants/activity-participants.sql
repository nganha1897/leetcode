# Write your MySQL query statement below
-- with user_activity as 
-- (
-- select activity, count(distinct id) cnt from friends
-- group by activity
-- )
-- select activity 
-- from 
-- user_activity
-- where cnt != (select max(cnt) from user_activity)
-- and cnt != (select min(cnt) from user_activity)
-- ;

-- select activity 
-- from
-- (
-- select activity,
-- dense_rank() over (order by count(id)) as rnk_asc,
-- dense_rank() over (order by count(id) desc) as rnk_dec
-- from friends
-- group by activity
-- ) user_activity
-- where rnk_asc != 1 and rnk_dec != 1
-- ;

with user_activity as 
(
select activity, count(distinct id) cnt from friends
group by activity
)
select activity
from 
user_activity ua left join 
  (
    select max(cnt) cnt from user_activity union select min(cnt) cnt from user_activity
  ) max_min
on ua.cnt = max_min.cnt
where max_min.cnt is null;