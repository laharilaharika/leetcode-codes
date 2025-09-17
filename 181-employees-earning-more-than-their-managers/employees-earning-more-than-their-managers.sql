SELECT E1.name AS Employee 
FROM Employee E1
JOIN Employee E2 
ON E1.managerID = E2.id 
WHERE E1.salary > E2.salary;