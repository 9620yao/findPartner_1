create sequence seq_logining_lid start with 10000;--注册
create sequence seq_users_aid start with 10000;--个人信息表
create sequence seq_speaks_sid start with 10000;--说说表
create sequence seq_album_abid start with 10000;--相册表
create sequence seq_words_wid start with 10000;--留言表
create sequence seq_comments_cid start with 10000;--评论表
create sequence seq_replys_rid start with 10000;--回复表
create sequence seq_backadmin_baid start with 10000;--管理员表
create sequence seq_userpower_upid start with 10000;--权限表

--------select * from logining;-----
--登录注册表
CREATE TABLE logining(
       lid VARCHAR2(40) PRIMARY KEY,
       phone VARCHAR2(20),--电话（注册）
       email VARCHAR2(20),--邮箱（注册）
       password varchar2(50) not null,--密码
       uname varchar2(20) not null,--用户真实姓名
       gender varchar2(4) default '男' check(gender in('男','女')),    --性别
       regdate varchar2(20),--注册时间
     otherlogone varchar2(40),
     otherlogtwo varchar2(40)
);

---select * from users
--个人信息表
CREATE TABLE users(
       aid VARCHAR2(40) PRIMARY KEY,--用户编号
     alid VARCHAR2(40) constraint fk_alid references logining(lid),--注册id，把所有信息联系起来 （外键约束）
       nickname VARCHAR2(40),--用户昵称（默认为用户编号或者注册的邮箱号或者注册的手机号）
       age int check(age between 6 and 100),--年龄 （检查约束）
       birthday varchar2(20),--生日 ------------------------date
     photo varchar2(200),--个人照片
       star VARCHAR2(50),--星座
       hobby VARCHAR2(50),--爱好
       job VARCHAR2(50),--工作
       company VARCHAR2(50),--公司
       school VARCHAR2(50),--学校
       address VARCHAR2(100),--现居地址
       hometown VARCHAR2(100),--家乡
       picture varchar2(100),--头像
       astate VARCHAR2(200),--国籍(state)
     otheradminsone VARCHAR2(40),
     otheradminstwo varchar2(40)
);

--select * from friends;
--好友关注表（某用户下的所有好友）
CREATE TABLE friends(
       aid varchar2(40),--用户编号
       fid varchar2(40),--好友编号
     sure varchar2(40) default '-0' check(sure in('-0','-1')),   --是否屏蔽，默认0为不屏蔽，1为屏蔽
     otherfriendsone VARCHAR2(40),
     otherfriendstwo varchar2(40)
);

--其他好友表（某用户和没关注的好友）--在两个好友没关注的时候，联系在一起
CREATE TABLE friendothers(
       aid varchar2(40),--用户编号
       fid varchar2(40),--好友编号
     othersure varchar2(40) default '-0' check(othersure in('-0','-1')),   --是否屏蔽，默认0为不屏蔽，1为屏蔽（屏蔽既加为黑名）
     otherfriend varchar2(40) default '-0' check(otherfriend in('-0','-1')),--是否为陌生人，默认0为不是，1为陌生人
     otherfriendsone VARCHAR2(40),
     otherfriendstwo varchar2(40)
);

--select * from speaks;
--说说表
CREATE TABLE speaks(
       sid  VARCHAR2(40) PRIMARY KEY,--说说编号
       content VARCHAR2(500),--说说内容
       speakman VARCHAR2(40),--说说发表人  (关联到用户)
       files VARCHAR2(500),--上传文件，视频，音乐等
       senddate varchar2(20),--发说说日期
     otherspeaksone VARCHAR2(40),
     otherspeakstwo varchar2(40)
);

--select * from album
--相册集表(相册列表)
CREATE TABLE album(
       abid VARCHAR2(40) PRIMARY KEY,--相册编号
       abname VARCHAR2(50),--相册名称
       aaid VARCHAR2(40), --相册发表人
       alcontent VARCHAR2(500),--相册内容（相册描述）
       allocation VARCHAR2(100),--相册上传位置
       aldate varchar2(20), --相册上传时间
     aheader VARCHAR2(500),--相册最外面显示的图片（可以是该相册下的图片，也可以使用户自定义的图片）
     otheralbumone VARCHAR2(40),
     otheralbumtwo varchar2(40)
);


--select * from albumpic;
--相册-图片（某相册下的所有图片）
create table albumpic(
     abid VARCHAR2(40),--相册编号
     apic VARCHAR2(500),--图片   （多图片）
     apiccontent VARCHAR2(500),--图片描述
     apicdate VARCHAR2(40),--修改为 图片上传时间
     otheralbumpictwo varchar2(40)
);

--select * from words;
--留言表
CREATE TABLE words(
       wid VARCHAR2(40) PRIMARY KEY,--相册编号
       waid VARCHAR2(40) CONSTRAINTS fk_words_waid REFERENCES users(aid), --用户编号
     wfrendid VARCHAR2(20), --留言人(谁在留言)
       wcontent VARCHAR2(500),--留言内容
       waddress VARCHAR2(50),--留言人所在位置
       wdate varchar2(100), --留言时间
     otheralbumone VARCHAR2(40),
     otheralbumtwo varchar2(40)
);

--select * from comments
--评论表（只包括 说说/相册/相片/留言 的单一评论）
CREATE table comments(
       cid VARCHAR2(40) PRIMARY KEY,--评论编号
       callid VARCHAR2(40),--说说/相册/相片/留言 的编号
       detail VARCHAR2(200),--评论内容
       comuserid  VARCHAR2(200),--评论用户编号
       comTime varchar2(100),--评论时间
     othercommentsone VARCHAR2(40),
     othercommentstwo varchar2(40)     
);


--select * from replys;
--回复表（包括对评论的回复，以及对回复的回复）
create table replys(
       rid varchar2(40) primary key,--回复编号
       rcid varchar2(40),--(评论编号和回复编号)
       ruserid varchar2(40),--当前回复用户的编号  
       rtargetid varchar2(40),--目标用户编号
       rcontent varchar2(500),--回复内容
       rtime varchar2(100),--回复时间
     otherreplysone VARCHAR2(40),
     otherreplystwo varchar2(40)
);
--select * from homepage
--主页显示
create table homepage(
       hpid varchar2(40),--用来存放说说/图片的编号
       hpuseid varchar2(40),--用来存放说说/图片发表人的编号
       hpdate varchar2(40),--用来存放说说/图片 的发表时间
       otherreplysone VARCHAR2(40),
       otherreplystwo varchar2(40)
);

select * from backadmin;
--管理员表
create table backadmin(
       baid varchar2(20),--管理员编号
       baemail varchar2(20),--管理员邮箱
       baname varchar2(40),--管理员姓名
       bapwd varchar2(40),--管理员密码
       badate varchar2(100), --注册时间
       otherbackadminone VARCHAR2(40),
       otherbackadmintwo varchar2(40)
);
--select * from userpower;
--用户权限表
create table userpower(
       upid varchar2(20),--权限表的编号
       upuid varchar2(20),--用户编号
       upower varchar2(100) default '-0' check(upower in('-0','-1')),--用户权限
       updata varchar2(40),--权限修改时间
       otherbackadminone VARCHAR2(40),
       otherbackadmintwo varchar2(40)
);
