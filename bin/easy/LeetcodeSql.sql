#Combine Two Tables
select 
A.FirstName,A.LastName,B.City,B.State 
from Person A left join Address B
on A.PersonId = B.PersonId

#Second Highest Salary
select Max(Salary) as SecondHighestSalary from Employee where Salary != (select Max(Salary) from Employee);

#Employees Earning More Than Their Managers
select A.Name as Employee from Employee A, Employee B where A.ManagerId = B.Id and A.Salary > B.Salary;

#Duplicate Emails
select Email from Person Group by Email Having Count(Email) > 1;

#Customers Who Never Order
select Name as Customers from Customers
where Id not in (
select CustomerId from Orders
)