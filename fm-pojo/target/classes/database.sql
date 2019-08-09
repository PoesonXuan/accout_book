
create table DB_DICTIONARY (
	id bigint primary key auto_increment comment '主键',
	tablename varchar(255) not null comment '表名（大写）',
	attribute varchar(255) not null comment '字段名（大写）',
	value varchar(255) not null comment '枚举值',
	explanation  varchar(255) not null comment '字段表示含义',
	description varchar(255) comment '描述',
	version varchar(255) comment '版本',
	status varchar(255) not null comment '状态'
);

insert DB_DICTIONARY(tablename,attribute,value,explanation,description,version,status)  values 
('DB_DICTIONARY','STATUS','0','新建','枚举值含义','0','1' ),
('DB_DICTIONARY','STATUS','1','在用','枚举值含义','0','1' ),
('DB_DICTIONARY','STATUS','99','废弃','枚举值含义','0','1' ),
('DB_USER','SEX','0','女','性别','0','1'),
('DB_USER','SEX','1','男','性别','0','1'),
('DB_USER','LEV','0','超级管理员','用户级别','0','1'),
('DB_USER','LEV','1','管理员','用户级别','0','1'),
('DB_USER','LEV','99','用户','用户级别','0','1'),
('DB_IOBill','TYPES','0','出账','操作类型','0','1' ),
('DB_IOBill','TYPES','1','进账','操作类型','0','1' ),
('DB_IOBill','STATUS','0','待审核','审批意见','0','1' ),
('DB_IOBill','STATUS','1','审核通过','审批意见','0','1' ),
('DB_IOBill','STATUS','2','审核失败','审批意见','0','1' ),
('DB_IOBill','STATUS','3','审核退回','审批意见','0','1' ),
('DB_USER','STATUS','1','可用','用户状态','0','1' ),
('DB_USER','STATUS','99','锁定','用户状态','0','1' ),

create table DB_USER(
	id bigint primary key auto_increment comment '主键',	
	nickname varchar(255) not null comment '昵称',	
	loginname varchar(255) not null comment '登录用户名',
	password varchar(255) not null comment '登录密码',
	lev varchar(255) not null comment '用户级别',
	header varchar(255)   comment '用户头像',
	sex varchar(255)   comment '用户性别',
	age int   comment '用户年龄',
	tele  varchar(255) comment '手机号码',
	mail  varchar(255) comment '邮箱'
);

create table DB_GOODS(
	id bigint primary key auto_increment comment '主键',
	name varchar(255) not null comment '商品名称',
	price Float(10,2) not null comment '参考单个金额'
);

create table DB_IOBill(
	id bigint primary key auto_increment comment '主键',
	types varchar(255) not null comment '操作类型',
	total Float(10,2) not null comment '总金额',
	price Float(10,2) not null comment '单个金额',
	counts int not null comment '数量',
	GOODS_ID bigint comment '商品',
	status varchar(255) not null comment '审批意见',
	foreign key (GOODS_ID) references DB_GOODS(ID)
);



alter table  db_user add status varchar(10) not Null   comment '用户状态';

