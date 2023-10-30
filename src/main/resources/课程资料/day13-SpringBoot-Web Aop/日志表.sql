create table operate_log(
    id int unsigned primary key auto_increment comment '主键',
    operate_user int unsigned comment '操作人ID',
    operate_time datetime comment '操作时间',
    class_name varchar(100) comment '操作的类名',
    method_name varchar(100) comment '操作的方法名',
    return_value varchar(2000) comment '返回值',
    cost_time bigint comment '方法耗时,单位ms'
) comment '操作日志表';