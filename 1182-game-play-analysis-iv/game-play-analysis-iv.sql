# Write your MySQL query statement below

with temp as (select player_id logged_player
from activity
where (player_id, adddate(event_date, -1)) in 
(select player_id, min(event_date) as min_date
from activity
group by player_id
) 
)
select round(count(distinct t.logged_player) / count(distinct a.player_id), 2) as fraction
from activity a left join temp t on a.player_id = t.logged_player
;
-- select logged_player from temp;