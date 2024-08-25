# Write your MySQL query statement below

-- with date_rnk as
-- (select
--   customer_id,
--   transaction_date,
--   amount,
--   adddate(transaction_date, -dense_rank() over (partition by customer_id order by transaction_date)) rnk1
-- from transactions
-- ),
-- amt_rnk as
-- (
-- select
--   customer_id,
--   transaction_date,
--   adddate(transaction_date, -dense_rank() over (partition by customer_id, rnk1 order by amount)) rnk2
-- from date_rnk
-- ) 
-- select dr.customer_id, min(ak.transaction_date) consecutive_start,
--   max(ak.transaction_date) consecutive_end
-- from
-- date_rnk dr join amt_rnk ak on dr.customer_id = ak.customer_id 
-- and dr.transaction_date = ak.transaction_date
-- group by customer_id, rnk2 
-- having count(rnk2) >= 3
-- order by dr.customer_id
-- ;

WITH ConsecutiveIncreasingTransactions AS (
  SELECT 
    a.customer_id, 
    a.transaction_date 
  FROM 
    Transactions a 
    JOIN Transactions b ON a.customer_id = b.customer_id 
    AND b.amount > a.amount 
    AND DATEDIFF(
      b.transaction_date, a.transaction_date
    ) = 1
),
RankedTransactions AS (
  SELECT 
    customer_id, 
    transaction_date, 
    ROW_NUMBER() OVER (
      PARTITION BY customer_id 
      ORDER BY 
        transaction_date
    ) AS row_num 
  FROM 
    ConsecutiveIncreasingTransactions
),
GroupedTransactions AS (
  SELECT 
    customer_id, 
    transaction_date, 
    DATE_SUB(
      transaction_date, INTERVAL row_num DAY
    ) AS group_identifier 
  FROM 
    RankedTransactions
),
TransactionGroups AS (
  SELECT 
    customer_id, 
    MIN(transaction_date) AS consecutive_start, 
    COUNT(*) AS transaction_count 
  FROM 
    GroupedTransactions 
  GROUP BY 
    customer_id, 
    group_identifier
) 
SELECT 
  customer_id, 
  consecutive_start, 
  DATE_ADD(
    consecutive_start, INTERVAL transaction_count DAY
  ) AS consecutive_end 
FROM 
  TransactionGroups 
WHERE 
  transaction_count > 1 
ORDER BY 
  customer_id
;