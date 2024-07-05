#1. Display all employee names in ascending order-- 
select emp_name from employee
order by emp_name;

#2. Display all employee names, salary, commision of employees in dept 10-- 
select emp_name, salary, comm from employee
where department_no = 10;

#3. Display all employees(all columns) in department 20 and 30-- 
select * from employee
where department_no in (20,30);

#4. Display all the employees who are managers-- 
select * from employee
where job = 'MANAGER';

#5. Display all the employees whose salary is between 2000 and 5000-- 
select * from employee
where salary >= 2000 and salary <= 5000;

#6. Display all the employees whose commission is null--
select * from employee
where comm is null; 

#7. Display employee name, salary, commission in descending order based on salary-- 
select emp_name, salary, comm from employee
order by salary desc;

#8. Display average, max, min and sum of salaries of employees--
select avg(salary) as average_salary, max(salary) as max_salary, min(salary) as min_salary, sum(salary) as total from employee;

#9. Display hire_date, current_date, tenure(calculated col) of the empl--
select hire_date, current_date(), concat(timestampdiff(month, hire_date, current_date())%12, ' months') as tenure from employee;

#10. Display all the employees whose name starts with s-- 
select * from employee
where emp_name like 'S%';

#11. Display unique department numbers from the employee table-- 
select distinct department_no from employee;

#12. Display job in lower case-- 
select lower(job) from employee;

#13. Select top 3 salary earning employee-- 
select * from employee
order by salary desc
limit 3;

#14. Select clerks and Managers in department 10-- 
select * from employee 
where department_no = 10 and job in ('CLERK','MANAGER');

#15. Display all clerks in asscending order of the department number -- 
select * from employee
where job = 'CLERK'
order by department_no;

#16. Display all employees department wise-- 
select * from employee
order by department_no, emp_name;

#17. Display how many employees are there for each job-- 
select job, count(*) as count from employee
group by job;

#18. Display what jobs are there for each department and number of employees for each job-- 
select job, department_no, count(*) as count from employee
group by job, department_no
order by department_no;

#19. Display how many employees are there for each department-- 
select department_no, count(*) as total_emp from employee
group by department_no;
 
#20. Display the rank of each employee with respect to their salary (highest salary will be rank 1)-- 
select emp_name, salary, department_no, rank() over (order by salary desc) as salary_rank from employee
order by salary_rank;

#6. Display emp_name,salary,comission,ctc(calculated column)--
select emp_name, salary, comm,  (salary + coalesce(comm, 0)) as ctc from employee;

#16. Display All employees in the same dept of 'SCOTT' -- 
select * from employee
where department_no = (select department_no from employee where emp_name = 'SCOTT');

select e1.emp_name from employee e1, employee e2 where e1.department_no = e2.department_no and e2.emp_name = 'SCOTT' and e1.emp_name != 'SCOTT';

#17. Employees having same designation of SMITH--
select * from employee
where job = (select job from employee where emp_name = 'SMITH');
 
#18. Employee who are reproting under KING--
select * from employee e1
join employee e2
on e1.mgr = e2.emp_no
where e2.emp_name = 'KING'; 

#19. Employees who have same salary of BLAKE-- 
select * from employee e1
join employee e2
on e1.salary = e2.salary
where e2.emp_name = 'BLAKE';

#20. Display departmentwise number of employees-- 
select count(department_no) as total_emp, department_no from employee
group by department_no;

