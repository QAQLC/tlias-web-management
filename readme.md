# p75 三层架构
    - 使用service 和 dao controller 解耦代码
# p76 分层结构IOC和DI概念的引入

# p77 IOC和DI入门

# p78 IOC详细说明
    - 引入4种注解
        - @Controller
        - @Service
        - @Reponsity
        - @Component
    - 如何在idea中查看端点数据，看到ico容器中管理的bean对象
    - beacn对象中的名称

# p79 DI详细说明
    - 介绍了@AutoWried注解
        - 这注解是spring提供的
        - 这个注解是按照类型注入
        - 如果多个相同类型的注解，怎么解决报错
        - 引入了3种方案
            - @Primary 作用与类上
            - @AutoWired + @Qualifier("bean的名称")
            - @Resource 注解，这个注解是jdk提供的，按照名称注入

# p80 mysql 介绍

# p83 mysql-说的是命令行操作DDL的一些操作
    - show databases;
    - select database();
    - use 使用数据库
    - 删除数据库
    - 创建数据库

# p84 mysql-说的是图形化的一些软件操作数据库
    - 主要使用idea自带的数据库工具

# p85 mysql-DDL表数据的创建
    - 使用datgroup 的控制台创建一张表
        - 5个约束条件
        - 使用单引号

# p89-91
    - DML
        - 新增数据
        - 修改数据
        - 删除数据

# p92 mysql-DQL基本查询
    - 就是单表的基本查询
        - 前面6分钟啰里八嗦说一大堆，后面就说了下单表查询的基本语法

# p93 mysql-DQL条件查询
    - 条件查询有2种运算符
        - 比较运算符
            - 4个特殊的
                -范围
                - 模糊
                - 最大值 最小值
                - 不等于null
        - 逻辑运算符

# p94
    - 聚合函数的学习
        - 5个聚合函数
        - 聚合函数3种使用方法
        - 聚合函数不能查询null的注意事项

# p95
    - 分组查询和聚合函数的应用
        - 分组后条件的应用

# p98 案例
    - 涉及到2个MySQL流程处理函数
        - if
        - case 
# p99 多表设计一对多

# p100 多表设计一对多--外键

# p101 多表设计一对一&&多对多

# p102 多表设计-案例-关系分析

# p103 多表设计-案例-表结构

# p104 多表查询
    - 基本查询-引出了数学概念 笛卡尔积， 也就是需要查询条件

# p105
    - 连接查询
    - 子查询

# p106
    - 连接查询
        - 内连接
            - 隐式内连接
            - 显式内连接
        - 外连接
            - 左外连接
            - 右外连接  ，也可以转成左外连接

# p107 多表查询-子查询-标量-列

# p108 多表查询-子查询-行-表

# p109 多表查询-案列


# p116 mybatis 学习
    - 入门
    - crud
    - 动态sql

# p117 mybatis-入门


# p118 mybatis-入门-配置
    - 配置sql等语法提示

---------------------- 20230929 学习 ------------------------
# P119 mybatis-入门-jdbc
    - 介绍jdbc只是一套接口规范
    - 缺点，以及对比Mybatis的一些优点
    - 数据库连接池

# p120 mybatis-入门-数据库连接池相关概念

# p121 mybatis-入门-lombok

# p122 mybatis-基础操作-环境准备

# p123 mybatis-基础操作-删除

# p124 mybatis-基础操作-删除--预编译sql
    - 配置文件打开mybatis 日志，将日志输出到控制台
        - 预编译sql性能更好
            - delete from emp where id = 1
            - delete from emp where id = 2
            - 上面这样sql每次都需要分析sql 然后优化然后做编译最后缓存
        - 防止sql注入
            - #{}
            - ${} 拼接sql 存在sql注入风险

---------------------- 20230930 学习 ------------------------
# p125 mybatis-基础操作-新增


# p126 mybatis-基础操作-新增-主键返回
    - 返回的主键一般使用，会存到rides里面

# p127 mybatis-基础操作-更新
    - 常规sql更新

# p128 mybatis-基础操作-查询--根据id查询
    - 存在字段和属性名，导致不一致无法封装到实体类对象中
    - 还有一个很重要，就是查询是有返回值的，如果返回类型void是会报错的

# p129 mybatis-基础查询-查询-条件查询
    - 解释了在springboot1.x 和单独使用mybatis时候的注解@Param('name')
    - like 模糊匹配会引发#{}不能在引号里面的问题，使用mysql concat函数代替

# p130 mybatis-基础查询-xml配置文件
    - xml文件名需要和mapper接口名一致，并且需要保持同包同名
    - xml文件的namespace需要是包的全限定名
    - xml预计中的id要和mapper接口中的方法名保持一致

---------------------- 20231001 学习 ------------------------

# p131 mybatis-动态sql-if
    - if标签 + test 属性判断
    - where 标签

---------------------- 20231002 学习 ------------------------

# 解决右键上下文中没有语言注入的选项，并且将mybatis sqo注入改为通用sql注入内

# p132 day09-10.mybatis-动态sql-if-案例
    - 内容就是更新员工信息，利用set标签删除条件列表后面的逗号

# p133 day09-11.mybatis-动态sql-forEach
    - 这节课主要说了mybatis如何批量处理一些东西，比如批量删除员工

# p134 day09-12.mybatis-动态sql-include