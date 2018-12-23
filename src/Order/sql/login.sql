-- 创建数据库
create database login;
-- 选择数据库
use login;
-- 创建用户表
create table user(
	id int primary key auto_increment, -- 用户编号 - 主键（自动递增）
	username varchar(30),	-- 用户名
	password varchar(30), 	-- 用户密码
	email varchar(50),		-- 用户邮箱
	sex varchar(50)	-- 用户性别 [注：最后一个字段，不要再最后加入“,”]
);