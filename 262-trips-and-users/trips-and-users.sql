# Write your MySQL query statement below
with cancelled_trips as
(
select count(t.id) cancelled_requests, t.request_at day
from trips t
where 
  (status = 'cancelled_by_driver' or status = 'cancelled_by_client')
  and client_id not in (select users_id from users where banned = 'Yes')
  and driver_id not in (select users_id from users where banned = 'Yes')
group by t.request_at
),
all_trips as
(select count(*) all_requests, t2.request_at day2
from trips t2
where 
  client_id not in (select users_id from users where banned = 'Yes')
  and driver_id not in (select users_id from users where banned = 'Yes')
group by t2.request_at
)
select
  day2 as Day,
  ifnull(round(cancelled_requests / all_requests, 2), 0) as 'Cancellation Rate'
from all_trips left join cancelled_trips
on cancelled_trips.day = all_trips.day2
where day2 between '2013-10-01' and '2013-10-03'
;
