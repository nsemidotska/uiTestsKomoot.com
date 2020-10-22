### Return Employee record with highest salary

```sql
SELECT * 
FROM Employee
WHERE salary = (SELECT MAX(salary) FROM Employee);
```

### Return the highest salary in employee table

```sql
SELECT MAX(salary) AS "Highest Salary"
FROM Employee;
```

### Return 2nd highest salary from employee table

```sql
SELECT max(salary) 
FROM Employee 
WHERE salary NOT IN
 (SELECT max(salary) 
  FROM Employee);
```

### Select range of employees based on id

```sql
SELECT first_name, last_name, department_id
FROM Employee
WHERE department_id IN (1, 2)
ORDER BY  department_id  ASC;
```

### Return an employee with highest salary and the employee’s department name

```sql
SELECT e.*, d.department_name 
FROM Employee e, Department d
WHERE e.salary = (SELECT MAX(salary) 
FROM Employee) 
AND e.department_id=d.department_id;
```

### Return highest salary, employee_name, department_name for EACH department

```sql
SELECT e.salary, e.department_id, e.first_name, e.last_name, d.department_name
FROM Employee e,
     Department d
WHERE e.salary IN (
    SELECT MAX(salary)
    FROM Employee
    group by department_id
)
AND e.department_id = d.department_id;
```

