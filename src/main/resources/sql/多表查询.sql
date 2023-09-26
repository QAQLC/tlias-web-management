# ============================== 多表查询基本查询 ============================== #

-- 1.基本查询-笛卡尔积
select * from tb_emp, tb_dept;

-- 1.1基本查询使用指定的组合列
select * from tb_dept, tb_emp where tb_emp.dept_id = tb_dept.id;
-- 1.2基本查询使用别名
select * from tb_emp e, tb_dept d where e.dept_id = d.id;

# ============================== 多表查询连接查询 ============================== #

-- 1.显示内连接查询 查询的并集
select tb_emp.name, tb_dept.name from tb_emp inner join tb_dept on tb_emp.dept_id = tb_dept.id;

-- 2.查询员工表所有员工的姓名，和对应的部门名称（左外连接）
select tb_emp.name 姓名, tb_dept.name 部门 from tb_emp left outer join tb_dept on tb_emp.dept_id= tb_dept.id;

-- 3.查询部门表，所有部门的名称，和相对应的员工名称（右外连接）
# 错误 select tb_dept.name 部门名称, tb_emp.name 姓名 from tb_dept right outer join tb_emp on tb_dept.id = tb_emp.dept_id;
select d.name 部门名称, e.name 姓名 from tb_emp e right outer join tb_dept d on e.dept_id = d.id;