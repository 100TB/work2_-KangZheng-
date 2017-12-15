
create table userTime(
id int not null auto_increment,
phone varchar(40),COMMIT '用户手机号'
codeTime datetime,COMMIT '验证码存活时间'
primary key(id));

#用户表
create table user(
id int not null auto_increment,
roleId int default 2 COMMENT '用户的角色id',
phone varchar(11) COMMENT '用户的手机号',
password varchar(32) COMENT '密码',
worryLogin int default 0 COMMENT '错误的次数',
loginTime datetime COMMENT '上次登录的时间',
jifen int default 500 COMMENT '注册成功默认赠送500积分',
primary key(id));

#文章表
create  table article(
articleId int not null auto_increment,
title varchar(20) COMMENT '标题',
created datetime COMMENT '发文时间',
userId int COMMENT '发文用户的id',
content varchar(2000) COMMENT '文章内容',
lastReply datetime COMMENT '最后一次回复的时间',
allReply int default 0 COMMENT '全部的回复',
primary key(articleId));

#评论表
create table comment(
commentId int not null auto_increment,
created datetime COMMENT '评论时间',
articleId int COMMENT '评论文章的id',
userId int COMMENT '发表评论的用户',
content varchar(2000) COMMENT '评论最多只存储2000个字符',
primary key(commentId));



#权限表
create table privileges(
   id int not null auto_increment,
   privilege varchar(20) COMMENT '权限名称',
   primary key(id));

#角色表
create table role(
   roleId int not null auto_increment,
   roleName varchar(20) COMMENT '角色名称',
  PRIMARY KEY (roleId));



#权限和角色中间表
create table role_privilege(
roleId int COMMENT '角色主键'
privilegeId int COMMENT '权限主键');






