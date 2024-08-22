# Write your MySQL query statement below
select user_id, ifnull(confirmation_rate, 0) confirmation_rate
from
(with t1 as (select user_id, count(action) cnt_act
from Confirmations
where action = 'confirmed'
group by user_id
), t2 as (
select user_id, count(*) cnt_all
from Confirmations
group by user_id
) select s.user_id user_id, 
round(cnt_act / cnt_all, 2) as confirmation_rate
from Signups s left join t1
on s.user_id = t1.user_id
left join t2 
on t1.user_id = t2.user_id
) cr;