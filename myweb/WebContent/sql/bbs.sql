--bbs.sql
--�亯 �� ����� �Խ���

--���̺� ����
drop table tb_bbs;

--���̺� ����
create table tb_bbs(
  bbsno    number(5)       not null -- �Ϸù�ȣ -99999~99999
 ,wname    varchar2(20)    not null -- �ۼ���
 ,subject  varchar2(100)   not null -- ������
 ,content  varchar2(2000)  not null -- �۳���
 ,passwd   varchar2(10)    not null -- �ۺ�й�ȣ
 ,readcnt  number(5)       default 0 not null -- ����ȸ��
 ,regdt    date            default  sysdate   -- ���ۼ���
 ,grpno    number(5)       not null  -- �� �׷��ȣ
 ,indent   number(5)       default 0 -- �鿩����
 ,ansnum   number(5)       default 0 -- �ۼ���
 ,ip       varchar2(15)    not null  -- �� IP
 ,primary key(bbsno)                 --bbsno �⺻Ű 
);

--������ ����
create sequence bbs_seq;

--������ ����
drop sequence bbs_seq;

--�� �۾���(insert)
bbsno: ������ �̿��� �Ϸù�ȣ
wname, subject, content, passwd: ����� �Է�
readcnt, regdt, indent, ansnum : default��
grpno : max(bbsno)+1 �亯/��ۿ� ����ϱ����� �÷�... ���� �� �ؿ��� ���� ��ȣ�� ����(?)
ip : request �̾ƿͼ� ����

insert into tb_bbs(bbsno, wname, subject, content, passwd,ip, grpno)
values(sequence bbs_seq.nextval,
?,?,?,?,?,(select nvl(max(bbsno),0)+1 from tb_bbs));
