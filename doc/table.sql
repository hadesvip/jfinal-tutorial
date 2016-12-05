use mydb;
create table if not exists sys_config(
  id int not null primary key auto_increment comment '主键',
  param varchar(32) not null comment '参数',
  value varchar(64) not null comment '参数值',
  param_desc varchar(200) default '' comment '参数描述',
  update_time datetime not null default now() comment '更新时间',
  available int default 1 not null comment '是否可用:1可用2不可用',
  unique key uq_sys_config_param(param)
)engine =innodb default charset=utf8mb4;
