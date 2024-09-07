# Write your MySQL query statement below
with user_activity as 
(
select activity, count(distinct id) cnt from friends
group by activity
)
select activity 
from 
user_activity
where cnt != (select max(cnt) from user_activity)
and cnt != (select min(cnt) from user_activity)
;
