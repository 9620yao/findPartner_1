CREATE TABLE logining(
	lid int PRIMARY KEY auto_increment,	
	phone VARCHAR(20),	
	email VARCHAR(20),	
	password varchar(50) not null,	
	uname varchar(20) not null,	
	gender varchar(4) default '男' check(gender in('男','女')),	
	regdate varchar(20),	
	otherlogone varchar(40),
	otherlogtwo varchar(40)
);
alter table logining AUTO_INCREMENT=1000;


CREATE TABLE users(
	uid int PRIMARY KEY auto_increment,	
	ulid int,	
	nickname VARCHAR(40),	
	age int check(age between 6 and 100),
	birthday varchar(20),	
	photo varchar(200),	
	star VARCHAR(50),	
	hobby VARCHAR(50),	
	job VARCHAR(50),	
	company VARCHAR(50),	
	school VARCHAR(50),	
	address VARCHAR(100),	
	hometown VARCHAR(100),	
	picture VARCHAR(100), 
	astate VARCHAR(200), 
	otheradminsone VARCHAR(40),
	otheradminstwo VARCHAR(40),
	FOREIGN KEY (ulid) REFERENCES logining(lid)
);
alter table users AUTO_INCREMENT=1000;

CREATE TABLE friends(
	uid int, 
	fid int, 
	sure VARCHAR(40) default '-0' check(sure in('-0','-1')),  
	otherfriendsone VARCHAR(40),
	otherfriendstwo VARCHAR(40)
);
 

CREATE TABLE speaks(
	sid  int PRIMARY KEY auto_increment, 
	content VARCHAR(500), 
	speakman int, 
	files VARCHAR(500), 
	senddate VARCHAR(40), 
	otherspeaksone VARCHAR(40),
	otherspeakstwo VARCHAR(40)
);
alter table speaks AUTO_INCREMENT=1000;

-- 日志
CREATE TABLE journal(
	jid  int PRIMARY KEY auto_increment, 
	content VARCHAR(500), 
	uid int, 
	jdate VARCHAR(40), 
	otherspeaksone VARCHAR(40),
	otherspeakstwo VARCHAR(40)
);
alter table journal AUTO_INCREMENT=1000;

CREATE TABLE album(
	abid int PRIMARY KEY auto_increment, 
	abname VARCHAR(50), 
	auid int,  
	alcontent VARCHAR(500), 
	allocation VARCHAR(100), 
	aldate VARCHAR(100),  
	aheader VARCHAR(500), 
	otheralbumone VARCHAR(40),
	otheralbumtwo VARCHAR(40)
);
alter table album AUTO_INCREMENT=1000;

 
create table albumpic(
	apid int PRIMARY KEY auto_increment,
	abid int, 
	apic VARCHAR(500), 
	apiccontent VARCHAR(500), 
	apicdate VARCHAR(100), 
	otheralbumpictwo VARCHAR(40)
);
alter table albumpic AUTO_INCREMENT=1000;


CREATE TABLE words(
	wid int PRIMARY KEY AUTO_INCREMENT, 
	waid int,  
	wfrendid int,  
	wcontent VARCHAR(500), 
	waddress VARCHAR(50), 
	wdate VARCHAR(100),  
	otheralbumone VARCHAR(40),
	otheralbumtwo VARCHAR(40)
);
alter table words AUTO_INCREMENT=1000;


CREATE table comments(
	cid int PRIMARY KEY auto_increment, 
	callid int, 
	detail VARCHAR(200), 
	comuserid  int, 
	comTime VARCHAR(100), 
	othercommentsone VARCHAR(40),
	othercommentstwo VARCHAR(40)     
);
alter table comments AUTO_INCREMENT=1000;

create table replys(
	rid int primary key auto_increment, 
	rcid int, 
	ruserid int ,   
	rtargetid int, 
	rcontent VARCHAR(500), 
	rtime VARCHAR(100), 
	otherreplysone VARCHAR(40),
	otherreplystwo VARCHAR(40)
);
alter table replys AUTO_INCREMENT=1000;
 

create table homepage(
	hid int primary key auto_increment,  
	hpid int, 
	hpuseid int, 
	hpdate VARCHAR(100), 
	otherreplysone VARCHAR(40),
	otherreplystwo VARCHAR(40)
);
alter table homepage AUTO_INCREMENT=1000;
 
 
create table userpower(
	upid int primary key AUTO_INCREMENT, 
	upuid varchar(20), 
	upower varchar(100) default '-0' check(upower in('-0','-1')), 
	updata varchar(40), 
	otherbackadminone VARCHAR(40),
	otherbackadmintwo varchar(40)
);
alter table userpower AUTO_INCREMENT=1000;
 

create table backadmin(
	buid int primary key AUTO_INCREMENT, 
	baemail VARCHAR(20), 
	baname VARCHAR(40), 
	bapwd VARCHAR(40), 
	badate VARCHAR(100),  
	otherbackadminone VARCHAR(40),
	otherbackadmintwo VARCHAR(40)
);
alter table backadmin AUTO_INCREMENT=1000;		