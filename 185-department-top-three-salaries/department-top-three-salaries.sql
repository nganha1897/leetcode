/* Write your PL/SQL query statement below */
SELECT 
  DEPARTMENT, 
  EMPLOYEE,
  SALARY 
FROM 
  (SELECT 
    D.NAME AS DEPARTMENT, 
    E.NAME AS EMPLOYEE,
    SALARY, 
    DENSE_RANK() OVER (PARTITION BY DEPARTMENTID ORDER BY SALARY DESC) AS RNK 
  FROM 
    Employee E,
    Department D    
  WHERE E.DEPARTMENTID = D.id 
  ) 
WHERE RNK < 4
; 

-- SELECT 
--   Department.NAME AS DEPARTMENT, 
--   Employee.NAME AS EMPLOYEE,
--   SALARY 
-- FROM 
--   Employee,
--   Department

-- SELECT SALARY FROM Employee 

