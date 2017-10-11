select * from department;

INSERT INTO department VALUES(4, '개발2', 10);
delete from department where deptno = 4;

select * from title;

insert into title values (6,"팀장");
delete from title where titleno = 6;


update title set titlename = "test" where titleno = 6;

select * from employee;
delete from employee where empno = 4444;

update employee set  title = 2 , manager = 1003, salary = 2500000, dno = 1 where empno = 4444