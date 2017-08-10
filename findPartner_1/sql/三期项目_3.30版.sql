create sequence seq_logining_lid start with 10000;--注册
create sequence seq_users_aid start with 10000;--个人信息表
create sequence seq_speaks_sid start with 10000;--说说表
create sequence seq_album_abid start with 10000;--相册表
create sequence seq_words_wid start with 10000;--留言表
create sequence seq_comments_cid start with 10000;--评论表
create sequence seq_replys_rid start with 10000;--回复表


	insert into speaks(sid,content,speakman,files,senddate)
		values('s'||seq_speaks_sid.nextval,'aaaaaaa','a28'
		,'',to_char(sysdate,'yyyy-MM-dd'))
		select * from SPEAKS
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
select * from LOGINING

alter table logining add uname varchar2(20);
insert into LOGINING(lid,phone,email,password,gender,regdate) values(seq_logining_lid.nextval,'17873235243','245336543@qq.com','c99e178d83cdfea3c167bc1d15f9b47ff8f80145','男',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
update LOGINING set password='c99e178d83cdfea3c167bc1d15f9b47ff8f80145' where lid='1';
select * from logining where email= '290966751@qq.com'
insert into LOGINING(lid,phone,email,password,gender,regdate) values(seq_logining_lid.nextval,'17382489362','142535325@qq.com','c99e178d83cdfea3c167bc1d15f9b47ff8f80145','女',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));--81 
--select * from logining where email= '1234567382@qq.com'
--select * from users where alid= 'a33'
select * from logining;--
--alid:a33 aid:a10001
--create sequence seq_logining_lid start with 1;   注册290966751@qq.com   123
-- 10008 15214336294 2908683211@163.com 6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2 NXI   女      2017-03-28 NULL        NULL

--ALTER TABLE admins RENAME TO users;
--ALTER SEQUENCE seq_admins_aid RENAME TO seq_users_aid;
--select * from users;
select seq_users_aid.nextval from dual connect by level < 50;
select * from users where alid =  (select lid from logining where email= '275966751@qq.com') 
select * from users u ,logining l where u.aid='10000' and u.alid = l.lid

--select * from logining where email= '19216815@qq.com' --a10032
select * from users where alid ='a10032' --a10056
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
--create sequence seq_admins_aid start with 10000;
insert into USERS(aid,alid) values(seq_users_aid.nextval,'61');
insert into USERS(aid,alid) values(seq_users_aid.nextval,'30');
insert into USERS(aid,alid,hobby,address) values(seq_users_aid.nextval,'82','唱歌','湖南长沙');
select * from users;
update users set hobby='唱歌',address='湖南长沙' where aid='10000';
--好友关注表（某用户下的所有好友）
CREATE TABLE friends(
       aid varchar2(40),--用户编号
       fid varchar2(40),--好友编号
	   sure varchar2(40) default '-0' check(sure in('-0','-1')), 	--是否屏蔽，默认0为不屏蔽，1为屏蔽
	   otherfriendsone VARCHAR2(40),
	   otherfriendstwo varchar2(40)
);
select * from friends where fid='10000';
select * from users u where u.aid in (select f.fid from friends f where f.aid='10000')
insert into friends(aid,fid) values('10020','a10081');
insert into friends(aid,fid) values('10000','a10000');

select count(aid) from FRIENDS f where f.fid='a10081' and aid not in (select fid from FRIENDS f where f.aid='a10081')

select u.hobby from users u where u.aid='10000'
select * from users u where u.aid not in (select f.fid from friends f where f.aid='10000') and u.aid!='10000'  --查找用户除好友列表以外的用户信息
select * from users u where u.aid not in (select f.fid from friends f where f.aid='10000') and u.aid!='10000' and u.address like '%'||(select u.address from users u where u.aid='10000')||'%'

select fid from friends where aid='10000'
--
select * from FRIENDS 
select aid from FRIENDS f where f.fid='10020' and aid not in (select fid from FRIENDS f where f.aid='10020')  --10000  10040  10041  他人的好友列表有我
select fid from FRIENDS where aid='10000' and fid in(select aid from FRIENDS where fid='10000');--显示与10000用户互加的好友
select f.fid from FRIENDS f where f.aid='10000' and f.fid in(select f.aid from FRIENDS where f.fid='10000')
select aid from FRIENDS where fid='10000';

--select fid from FRIENDS f where f.aid='10020'  --我的好友列表  10041  10000
--select fid from FRIENDS f where f.aid not in (select aid from FRIENDS f where f.fid='a10000')--10000 10041
--select * from FRIENDS where fid='10020' and aid in (select aid from FRIENDS f where f.fid='10020')

--其他好友表（某用户和没关注的好友）--在两个好友没关注的时候，联系在一起
CREATE TABLE friendothers(
       aid varchar2(40),--用户编号
       fid varchar2(40),--好友编号
	   othersure varchar2(40) default '-0' check(othersure in('-0','-1')), 	--是否屏蔽，默认0为不屏蔽，1为屏蔽（屏蔽既加为黑名）
	   otherfriend varchar2(40) default '-0' check(otherfriend in('-0','-1')),--是否为陌生人，默认0为不是，1为陌生人
	   otherfriendsone VARCHAR2(40),
	   otherfriendstwo varchar2(40)
);
select * from speaks;
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
--create sequence seq_speaks_sid start with 10000;
insert into SPEAKS(sid,content,speakman,senddate) values('s'||seq_speaks_sid.nextval,'我是第三条说说','10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into SPEAKS(sid,content,speakman,senddate) values('s'||seq_speaks_sid.nextval,'我是第四条说说','10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into SPEAKS(sid,content,speakman,senddate) values('s'||seq_speaks_sid.nextval,'我是第无条说说','10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into SPEAKS(sid,content,speakman,senddate) values('s'||seq_speaks_sid.nextval,'我是第六条说说','10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into SPEAKS(sid,content,speakman,senddate) values('s'||seq_speaks_sid.nextval,'我是第七条说说','10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
select * from SPEAKS
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
--select * from album where aaid = 'a10057'; --ab10040


--create sequence seq_album_alid start with 10000;
select * from albumpic where abid = 'ab10040'
--相册-图片（某相册下的所有图片）
create table albumpic(
	   abid VARCHAR2(40),--相册编号
	   apic VARCHAR2(500),--图片   （多图片）
	   apiccontent VARCHAR2(500),--图片描述
	   otheralbumpicone VARCHAR2(40),
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
       wdate varchar2(20), --留言时间
	   otheralbumone VARCHAR2(40),
	   otheralbumtwo varchar2(40)
);
create sequence seq_words_wid start with 10000;
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第一条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第二条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第三条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第四条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第五条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into WORDS(wid,waid,wfrendid,wcontent,wdate) values('w'||seq_words_wid.nextval,'10000','10020','我是第六条留言',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
select * from WORDS;
--评论表（只包括 说说/相册/相片/留言 的单一评论）
CREATE table comments(
       cid VARCHAR2(40) PRIMARY KEY,--评论编号
       callid VARCHAR2(40),--说说/相册/相片/留言 的编号
       detail VARCHAR2(200),--评论内容
       comuserid  VARCHAR2(200),--评论用户编号
       comTime varchar2(20),--评论时间
	   othercommentsone VARCHAR2(40),
	   othercommentstwo varchar2(40)	   
       );
create sequence seq_comments_cid start with 10000;
insert into COMMENTS(cid,callid,detail,comuserid,comTime) values(seq_comments_cid.nextval,'10020','我是说说的评论','a10000',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
insert into COMMENTS(cid,callid,detail,comuserid,comTime) values(seq_comments_cid.nextval,'10020','我是说说的第二条评论','10020',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'));
select * from COMMENTS;
--回复表（包括对评论的回复，以及对回复的回复）
create table replys(
       rid varchar2(40) primary key,--回复编号
       rcid varchar2(40) CONSTRAINTS fk_replys_cid REFERENCES comments(cid),--(评论编号)
       ruserid varchar2(40),--当前回复用户的编号  
       rtargetid varchar2(40),--目标用户编号
       rcontent varchar2(500),--回复内容
       rtime varchar2(20),--回复时间
	   otherreplysone VARCHAR2(40),
	   otherreplystwo varchar2(40)
);
create sequence seq_replys_rid start with 10000;
insert into REPLYS(rid,rcid,ruserid,rtargetid,rcontent,rtime) values(seq_replys_rid.nextval,'10000','10000','a10000','我是评论的回复',to_char(sysdate,'yyyy-MM-dd HH:mi:ss'))
select * from REPLYS;
select * from COMMENTS,REPLYS where COMMENTS.CID=REPLYS.RCID and COMMENTS.CALLID='10020'
--create sequence seq_replys_rid start with 10000;
select w.*,c.* from replys  where rcid in(
	select c.cid from words w,comments c where w.wid=c.callid
);

select w.*,c.*,r.* 
from  words w
inner join comments c
on w.wid=c.callid
inner join replys r
on c.cid=r.rcid

>>>>>>> branch 'master' of ssh://git@github.com/9620yao/findPartner.git
---------------------------------------------------------------------
--说说/相册/相片/留言等表，共用评论表和回复表。
--说说/相册/相片/留言的主键，既编码用字符串和序列拼接，用来避免冲突。
select count(1) total,ceil(count(1) / pageSize) totalPage, currPage, pageSize,speakman from speaks
	where speakman= 'a10056' order by speakman  
