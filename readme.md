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


# p141 day10-08.案例-员工管理-分页请求
    - 分2个mapper
        - 一个查询count
        - 一个查询分页
        - 合并到一个bean中

# p142 day10-09.案列-员工管理-分页请求-PageHelper 使用
    - 使用分页直接查

# p143 day10-09.案列-员工管理-分页请求-PageHelper + 条件查询
    - 分页部分继续使用插件
    - 剩下动态sql使用xml查询


---------------------- 20231021 学习 ------------------------
# p144 删除员工、批量删除
# p145 新增员工

# p146 文件上传的简介
# p147 day11-03.案例-文件上传-本地上传

# p153 配置文件

可以将一些配置写在配置文件中，这样可以防止配置信息硬编码


---------------------- 20231023 学习 ------------------------

- 会话技术介绍
- 会话跟踪的3种方案
- 客户端cookie
- 服务端session
- 令牌token


---------------------- 20231028 学习 ------------------------

- 全局异常处理
- spring事务管理
  - 自己实现事务
  - @Transactional  默认情况下只有RuntimeException才会回滚
  - 事务的传播行为
    - a开启事务，然后在a中调用b，b也有事务注解，这时候就会出现事务的传播行为
      - 比如日志记录，想要成功或者失败都要执行记录日志操作

- 什么是AOP 面向切面编程
  - 使用场景
    - 日志记录
    - 权限控制
    - 事务管理
- 通知类型
- 通知顺序
  - @Order (加载类上) 可以用这个，进行排序线执行，默认是按照字母数字顺序执行
- 切入点表达式
  - execution
  - within
  - this
  - target
  - args
  - @target
  - @args
  - @within
  - @annotation  需要自定义注解
  - bean
- 连接点


---------------------- 20231030 学习 ------------------------

- 通过注解完成日志记录
- 配置的优先级
- bean的获取
- bean的获取
- 第三方bean
  - 使用配置定定义第三方@bean
  