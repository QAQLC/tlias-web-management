# p75 三层架构
    - 使用service 和 dao controller 解耦代码
# P76 分层结构IOC和DI概念的引入

# P77 IOC和DI入门

# P78 IOC详细说明
    - 引入4种注解
        - @Controller
        - @Service
        - @Reponsity
        - @Component
    - 如何在idea中查看端点数据，看到ico容器中管理的bean对象
    - beacn对象中的名称

# P79 DI详细说明
    - 介绍了@AutoWried注解
        - 这注解是spring提供的
        - 这个注解是按照类型注入
        - 如果多个相同类型的注解，怎么解决报错
        - 引入了3种方案
            - @Primary 作用与类上
            - @AutoWired + @Qualifier("bean的名称")
            - @Resource 注解，这个注解是jdk提供的，按照名称注入

# P80 mysql 介绍

# p83说的是命令行操作DDL的一些操作
    - show databases;
    - select database();
    - use 使用数据库
    - 删除数据库
    - 创建数据库

# p84说的是图形化的一些软件操作数据库
