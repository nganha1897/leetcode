# Write your MySQL query statement below
select id, visit_date, people
from 
(
select id, visit_date, people, count(rnk) over (partition by rnk) cnt_rnk
from
(
select 
  id, 
  id - dense_rank() over (order by id) rnk,
  visit_date, people
from
(
select id, visit_date, people 
from stadium
where people >= 100
order by id
) s1
) s2
) s3
where cnt_rnk >= 3
order by visit_date
;