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

# p83 说的是命令行操作DDL的一些操作
    - show databases;
    - select database();
    - use 使用数据库
    - 删除数据库
    - 创建数据库

# p84 说的是图形化的一些软件操作数据库
    - 主要使用idea自带的数据库工具

# p85 DDL表数据的创建
    - 使用datgroup 的控制台创建一张表
        - 5个约束条件
        - 使用单引号

# p89-91
    - DML
        - 新增数据
        - 修改数据
        - 删除数据

# p92 DQL基本查询
    - 就是单表的基本查询
        - 前面6分钟啰里八嗦说一大堆，后面就说了下单表查询的基本语法

# p93 DQL条件查询
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

# p103 多表设计-案例-表结构

# p104 多表查询
    - 基本查询-引出了数学概念 笛卡尔积， 也就是需要查询条件

# p105
    - 连接查询
    - 子查询

# p106
    - 连接查询
        - 内连接
        - 外连接
            - 左外连接
            - 右外连接  ，也可以转成左外连接