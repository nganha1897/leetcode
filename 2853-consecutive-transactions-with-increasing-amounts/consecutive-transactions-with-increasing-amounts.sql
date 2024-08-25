# Write your MySQL query statement below

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
    dense_rank() OVER (
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