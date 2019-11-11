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
#Delete Duplicate Emails
delete q from Person p,Person q where p.Id<q.Id and p.Email=q.Email;

#Rising Temperature
select a.Id from Weather a inner join Weather b on to_days(a.RecordDate)=to_days(b.RecordDate)+1 
where a.Temperature>b.Temperature

select * from cinema where description != 'boring' and mod(id, 2)=1 order by rating desc;