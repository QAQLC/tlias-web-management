# ============================== 分类表 ============================== #
create table category (
    id int unsigned primary key auto_increment comment '主键',
    name varchar(20) not null unique comment '菜品名称',
    type tinyint unsigned not null comment '菜品分类',
    sort tinyint unsigned not null comment '排序',
    status tinyint unsigned not null default 0 comment '0: 停用 1：启用',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '分类表';

# ============================== 菜品表 ============================== #
create table dish (
    id int unsigned primary key auto_increment comment '主键',
    ame varchar(20) not null unique comment '菜品名称',
    category_id int unsigned not null comment '菜品分类',
    price decimal(8,2) not null comment '价格',
    image varchar(300) not null comment '图片',
    description varchar(200) comment '描述信息',
    status tinyint unsigned default 0 comment '售卖状态 0: 停售 1 起售',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '菜品表';

# ============================== 套餐表 ============================== #
create table setmeal (
    id int unsigned primary key auto_increment comment '主键',
    name varchar(20) not null unique comment '套餐名称',
    category_id int unsigned not null comment '套餐分类',
    price decimal(8,2) not null comment '价格',
    image varchar(300) not null comment '图片',
    description varchar(200) comment '描述信息',
    status tinyint unsigned default 0 comment '售卖状态 0: 停售 1 起售',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '套餐表';

# ============================== 套餐菜品的关联表 ============================== #
create table setmeal_dish (
    id int unsigned primary key auto_increment comment '主键',
    setmeal_id int unsigned not null comment '套餐id',
    dish_id int unsigned not null comment '菜品id',
    copies tinyint unsigned not null comment '分数'
) comment '菜品套餐关系表';