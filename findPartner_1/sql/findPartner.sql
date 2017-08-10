create sequence seq_logining_lid start with 10000;--ע��
create sequence seq_users_aid start with 10000;--������Ϣ��
create sequence seq_speaks_sid start with 10000;--˵˵��
create sequence seq_album_abid start with 10000;--����
create sequence seq_words_wid start with 10000;--���Ա�
create sequence seq_comments_cid start with 10000;--���۱�
create sequence seq_replys_rid start with 10000;--�ظ���
create sequence seq_backadmin_baid start with 10000;--����Ա��
create sequence seq_userpower_upid start with 10000;--Ȩ�ޱ�

--------select * from logining;-----
--��¼ע���
CREATE TABLE logining(
       lid VARCHAR2(40) PRIMARY KEY,
       phone VARCHAR2(20),--�绰��ע�ᣩ
       email VARCHAR2(20),--���䣨ע�ᣩ
       password varchar2(50) not null,--����
       uname varchar2(20) not null,--�û���ʵ����
       gender varchar2(4) default '��' check(gender in('��','Ů')),    --�Ա�
       regdate varchar2(20),--ע��ʱ��
     otherlogone varchar2(40),
     otherlogtwo varchar2(40)
);

---select * from users
--������Ϣ��
CREATE TABLE users(
       aid VARCHAR2(40) PRIMARY KEY,--�û����
     alid VARCHAR2(40) constraint fk_alid references logining(lid),--ע��id����������Ϣ��ϵ���� �����Լ����
       nickname VARCHAR2(40),--�û��ǳƣ�Ĭ��Ϊ�û���Ż���ע�������Ż���ע����ֻ��ţ�
       age int check(age between 6 and 100),--���� �����Լ����
       birthday varchar2(20),--���� ------------------------date
     photo varchar2(200),--������Ƭ
       star VARCHAR2(50),--����
       hobby VARCHAR2(50),--����
       job VARCHAR2(50),--����
       company VARCHAR2(50),--��˾
       school VARCHAR2(50),--ѧУ
       address VARCHAR2(100),--�־ӵ�ַ
       hometown VARCHAR2(100),--����
       picture varchar2(100),--ͷ��
       astate VARCHAR2(200),--����(state)
     otheradminsone VARCHAR2(40),
     otheradminstwo varchar2(40)
);

--select * from friends;
--���ѹ�ע��ĳ�û��µ����к��ѣ�
CREATE TABLE friends(
       aid varchar2(40),--�û����
       fid varchar2(40),--���ѱ��
     sure varchar2(40) default '-0' check(sure in('-0','-1')),   --�Ƿ����Σ�Ĭ��0Ϊ�����Σ�1Ϊ����
     otherfriendsone VARCHAR2(40),
     otherfriendstwo varchar2(40)
);

--�������ѱ�ĳ�û���û��ע�ĺ��ѣ�--����������û��ע��ʱ����ϵ��һ��
CREATE TABLE friendothers(
       aid varchar2(40),--�û����
       fid varchar2(40),--���ѱ��
     othersure varchar2(40) default '-0' check(othersure in('-0','-1')),   --�Ƿ����Σ�Ĭ��0Ϊ�����Σ�1Ϊ���Σ����μȼ�Ϊ������
     otherfriend varchar2(40) default '-0' check(otherfriend in('-0','-1')),--�Ƿ�Ϊİ���ˣ�Ĭ��0Ϊ���ǣ�1Ϊİ����
     otherfriendsone VARCHAR2(40),
     otherfriendstwo varchar2(40)
);

--select * from speaks;
--˵˵��
CREATE TABLE speaks(
       sid  VARCHAR2(40) PRIMARY KEY,--˵˵���
       content VARCHAR2(500),--˵˵����
       speakman VARCHAR2(40),--˵˵������  (�������û�)
       files VARCHAR2(500),--�ϴ��ļ�����Ƶ�����ֵ�
       senddate varchar2(20),--��˵˵����
     otherspeaksone VARCHAR2(40),
     otherspeakstwo varchar2(40)
);

--select * from album
--��Ἧ��(����б�)
CREATE TABLE album(
       abid VARCHAR2(40) PRIMARY KEY,--�����
       abname VARCHAR2(50),--�������
       aaid VARCHAR2(40), --��ᷢ����
       alcontent VARCHAR2(500),--������ݣ����������
       allocation VARCHAR2(100),--����ϴ�λ��
       aldate varchar2(20), --����ϴ�ʱ��
     aheader VARCHAR2(500),--�����������ʾ��ͼƬ�������Ǹ�����µ�ͼƬ��Ҳ����ʹ�û��Զ����ͼƬ��
     otheralbumone VARCHAR2(40),
     otheralbumtwo varchar2(40)
);


--select * from albumpic;
--���-ͼƬ��ĳ����µ�����ͼƬ��
create table albumpic(
     abid VARCHAR2(40),--�����
     apic VARCHAR2(500),--ͼƬ   ����ͼƬ��
     apiccontent VARCHAR2(500),--ͼƬ����
     apicdate VARCHAR2(40),--�޸�Ϊ ͼƬ�ϴ�ʱ��
     otheralbumpictwo varchar2(40)
);

--select * from words;
--���Ա�
CREATE TABLE words(
       wid VARCHAR2(40) PRIMARY KEY,--�����
       waid VARCHAR2(40) CONSTRAINTS fk_words_waid REFERENCES users(aid), --�û����
     wfrendid VARCHAR2(20), --������(˭������)
       wcontent VARCHAR2(500),--��������
       waddress VARCHAR2(50),--����������λ��
       wdate varchar2(100), --����ʱ��
     otheralbumone VARCHAR2(40),
     otheralbumtwo varchar2(40)
);

--select * from comments
--���۱�ֻ���� ˵˵/���/��Ƭ/���� �ĵ�һ���ۣ�
CREATE table comments(
       cid VARCHAR2(40) PRIMARY KEY,--���۱��
       callid VARCHAR2(40),--˵˵/���/��Ƭ/���� �ı��
       detail VARCHAR2(200),--��������
       comuserid  VARCHAR2(200),--�����û����
       comTime varchar2(100),--����ʱ��
     othercommentsone VARCHAR2(40),
     othercommentstwo varchar2(40)     
);


--select * from replys;
--�ظ������������۵Ļظ����Լ��Իظ��Ļظ���
create table replys(
       rid varchar2(40) primary key,--�ظ����
       rcid varchar2(40),--(���۱�źͻظ����)
       ruserid varchar2(40),--��ǰ�ظ��û��ı��  
       rtargetid varchar2(40),--Ŀ���û����
       rcontent varchar2(500),--�ظ�����
       rtime varchar2(100),--�ظ�ʱ��
     otherreplysone VARCHAR2(40),
     otherreplystwo varchar2(40)
);
--select * from homepage
--��ҳ��ʾ
create table homepage(
       hpid varchar2(40),--�������˵˵/ͼƬ�ı��
       hpuseid varchar2(40),--�������˵˵/ͼƬ�����˵ı��
       hpdate varchar2(40),--�������˵˵/ͼƬ �ķ���ʱ��
       otherreplysone VARCHAR2(40),
       otherreplystwo varchar2(40)
);

select * from backadmin;
--����Ա��
create table backadmin(
       baid varchar2(20),--����Ա���
       baemail varchar2(20),--����Ա����
       baname varchar2(40),--����Ա����
       bapwd varchar2(40),--����Ա����
       badate varchar2(100), --ע��ʱ��
       otherbackadminone VARCHAR2(40),
       otherbackadmintwo varchar2(40)
);
--select * from userpower;
--�û�Ȩ�ޱ�
create table userpower(
       upid varchar2(20),--Ȩ�ޱ�ı��
       upuid varchar2(20),--�û����
       upower varchar2(100) default '-0' check(upower in('-0','-1')),--�û�Ȩ��
       updata varchar2(40),--Ȩ���޸�ʱ��
       otherbackadminone VARCHAR2(40),
       otherbackadmintwo varchar2(40)
);
