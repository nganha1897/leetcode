/* Write your PL/SQL query statement below */
SELECT a1.machine_id, ROUND((SUM(a2.timestamp) - SUM(a1.timestamp)) / COUNT(a1.machine_id), 3) processing_time
FROM Activity a1, Activity a2
WHERE a1.machine_id = a2.machine_id
AND a1.process_id = a2.process_id
AND a1.activity_type = 'start'
AND a2.activity_type = 'end'
GROUP BY a1.machine_id;