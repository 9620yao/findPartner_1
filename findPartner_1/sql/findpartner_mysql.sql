
-- select * from logining;
-- delete from logining
-- 登录注册表
CREATE TABLE logining(
	lid int PRIMARY KEY auto_increment,-- 主键id
	phone VARCHAR(20),-- 电话（注册）
	email VARCHAR(20),-- 邮箱（注册）
	password varchar(50) not null,-- 密码
	uname varchar(20) not null,-- 用户真实姓名
	gender varchar(4) default '男' check(gender in('男','女')), -- 性别
	regdate varchar(20),-- 注册时间
	otherlogone varchar(40),
	otherlogtwo varchar(40)
);
alter table logining AUTO_INCREMENT=1000;
-- select * from users
-- drop table users
--delete from users

--个人信息表
CREATE TABLE users(
	uid int PRIMARY KEY auto_increment,-- 用户编号
	ulid int,--  注册id，把所有信息联系起来 （外键约束）
	nickname VARCHAR(40),--  用户昵称（默认为用户编号或者注册的邮箱号或者注册的手机号）
	age int check(age between 6 and 100),-- 年龄 （检查约束）
	birthday varchar(20),-- 生日 ------------------------date
	photo varchar(200),-- 个人照片
	star VARCHAR(50),-- 星座
	hobby VARCHAR(50),-- 爱好
	job VARCHAR(50),-- 工作
	company VARCHAR(50),-- 公司
	school VARCHAR(50),-- 学校
	address VARCHAR(100),-- 现居地址
	hometown VARCHAR(100),-- 家乡
	picture VARCHAR(100),-- 头像
	astate VARCHAR(200),-- 国籍(state)
	otheradminsone VARCHAR(40),
	otheradminstwo VARCHAR(40),
	FOREIGN KEY (ulid) REFERENCES logining(lid)
);
alter table users AUTO_INCREMENT=1000;
-- select * from friends;
-- 好友关注表（某用户下的所有好友）
CREATE TABLE friends(
	uid int,-- 用户编号
	fid int,-- 好友编号
	sure VARCHAR(40) default '-0' check(sure in('-0','-1')),   -- 是否屏蔽，默认0为不屏蔽，1为屏蔽
	otherfriendsone VARCHAR(40),
	otherfriendstwo VARCHAR(40)
);
-- drop table friends;

-- select * from speaks;
-- 说说表
CREATE TABLE speaks(
	sid  int PRIMARY KEY auto_increment,-- 说说编号
	content VARCHAR(500),-- 说说内容
	speakman int,-- 说说发表人  (关联到用户)
	files VARCHAR(500),-- 上传文件，视频，音乐等
	senddate VARCHAR(20),-- 发说说日期
	otherspeaksone VARCHAR(40),
	otherspeakstwo VARCHAR(40)
);
alter table speaks AUTO_INCREMENT=1000;
-- select * from speaks where speakman like '%a2%' or senddate like '%8%';
-- select * from album
-- 相册集表(相册列表)
CREATE TABLE album(
	abid int PRIMARY KEY auto_increment,-- 相册编号
	abname VARCHAR(50),-- 相册名称
	auid int, -- 相册发表人
	alcontent VARCHAR(500),-- 相册内容（相册描述）
	allocation VARCHAR(100),-- 相册上传位置
	aldate VARCHAR(100), -- 相册上传时间
	aheader VARCHAR(500),-- 相册最外面显示的图片（可以是该相册下的图片，也可以使用户自定义的图片）
	otheralbumone VARCHAR(40),
	otheralbumtwo VARCHAR(40)
);
alter table album AUTO_INCREMENT=1000;

-- select * from albumpic;
-- drop table album
-- 相册-图片（某相册下的所有图片）
create table albumpic(
	apid int PRIMARY KEY auto_increment,
	abid int,-- 相册编号
	apic VARCHAR(500),-- 图片   （多图片）
	apiccontent VARCHAR(500),-- 图片描述
	apicdate VARCHAR(100),-- 修改为 图片上传时间
	otheralbumpictwo VARCHAR(40)
);
alter table albumpic AUTO_INCREMENT=1000;
-- select * from words;
-- 留言表
CREATE TABLE words(
	wid int PRIMARY KEY AUTO_INCREMENT,-- 留言编号
	waid int, -- 用户编号
	wfrendid int, -- 留言人(谁在留言)
	wcontent VARCHAR(500),-- 留言内容
	waddress VARCHAR(50),-- 留言人所在位置
	wdate VARCHAR(100), -- 留言时间
	otheralbumone VARCHAR(40),
	otheralbumtwo VARCHAR(40)
);
-- drop table words
alter table words AUTO_INCREMENT=1000;
-- select * from comments
-- 评论表（只包括 说说/相册/相片/留言 的单一评论）
CREATE table comments(
	cid int PRIMARY KEY auto_increment,-- 评论编号
	callid int,-- 说说/相册/相片/留言 的编号
	detail VARCHAR(200),-- 评论内容
	comuserid  int,-- 评论用户编号
	comTime VARCHAR(100),-- 评论时间
	othercommentsone VARCHAR(40),
	othercommentstwo VARCHAR(40)     
);
alter table comments AUTO_INCREMENT=1000;
-- drop table comments


-- select * from replys;
-- 回复表（包括对评论的回复，以及对回复的回复）
create table replys(
	rid int primary key auto_increment,-- 回复编号
	rcid int,-- (评论编号和回复编号)
	ruserid int ,-- 当前回复用户的编号  
	rtargetid int,-- 目标用户编号
	rcontent VARCHAR(500),-- 回复内容
	rtime VARCHAR(100),-- 回复时间
	otherreplysone VARCHAR(40),
	otherreplystwo VARCHAR(40)
);
alter table replys AUTO_INCREMENT=1000;

-- drop table replys;


-- select * from homepage;
--主页显示
create table homepage(
	hid int primary key auto_increment,-- 编号
	hpid int,-- 用来存放说说/图片的编号
	hpuseid int,-- 用来存放说说/图片发表人的编号
	hpdate VARCHAR(100),-- 用来存放说说/图片 的发表时间
	otherreplysone VARCHAR(40),
	otherreplystwo VARCHAR(40)
);
alter table homepage AUTO_INCREMENT=1000;

-- select * from userpower;
-- 用户权限表
create table userpower(
	upid int primary key AUTO_INCREMENT,-- 权限表的编号
	upuid varchar(20),-- 用户编号
	upower varchar(100) default '-0' check(upower in('-0','-1')),-- 用户权限
	updata varchar(40),-- 权限修改时间
	otherbackadminone VARCHAR(40),
	otherbackadmintwo varchar(40)
);
alter table userpower AUTO_INCREMENT=1000;
--------------------------------------------------------------------
-- select * from homepage
-- select * from speaks
-- select * from album


--auid 用户编号 a10056 a10057 a10055

create table backadmin(
	buid int primary key AUTO_INCREMENT,-- 管理员编号
	baemail VARCHAR(20),-- 管理员邮箱
	baname VARCHAR(40),-- 管理员姓名
	bapwd VARCHAR(40),-- 管理员密码
	badate VARCHAR(100), -- 注册时间
	otherbackadminone VARCHAR(40),
	otherbackadmintwo VARCHAR(40)
);
alter table backadmin AUTO_INCREMENT=1000;		
-- select * from logining limit 1,20;
-- select * from homepage;
