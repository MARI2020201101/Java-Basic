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

--�� list ��ü��Ϻ���
select bbsno, wname, subject, readcnt, regdt
from tb_bbs
order by grpno desc, ansnum asc

--�󼼺���
select * from tb_bbs where bbsno=?

--�� ��ȸ�� �ø���
update tb_bbs set readcnt=(readcnt+1) where bbsno=?

--�� �����ϱ�
delete tb_bbs where passwd=? and bbsno=?

--�� �����ϱ�(update)
update tb_bbs 
set wname=? , subject=?, content=?
where bbsno=? and passwd=?

--�亯���� �˰���
1) ���۾��� : ������ �θ��
2) �亯���� : �ڽı�
3) �׷��ȣ(grpno) : ����۰� ���� ������.
4) �鿩����(indent) : �ڽ�-����-������.. ���� ����. 
					�������� indent��ȣ view�� ���.
5) �ۼ���(ansno) : ���� ����׷쳻�� �� ���� ����. �θ��+1 �� �ϰ�, 
					�ڱ⺸�ٹؿ����� �༮���� ��ȣ �����ʿ�.

--�ۼ��� ������
update tb_bbs set ansnum=ansnum+1 
where ansnum>=ansnum+1 and grpno=����׷�ѹ�;

--�� ���
select * from tb_bbs
order by grpno desc, ansnum asc

--reply�� indent,ansno�ֱ�
select grpno,indent,ansno from tb_bbs where bbsno=?

--��ü �Խñ� ���� ���
select count(bbsno) from tb_bbs

///////////[�˻�]////////////
--Ű���� �Ѱ��϶� �˻� ex)�ֵ���ũ
select * from tb_bbs where wname like '%�ֵ���ũ%'
select * from tb_bbs where subject like '%�ֵ���ũ%'
select * from tb_bbs where content like '%�ֵ���ũ%'

--���� �Ǵ� ���뿡�� �˻�
select * from tb_bbs 
where wname like '%�ֵ���ũ%' 
or subject like '%�ֵ���ũ%'


//////////[���������̼�]///////////
1) 
select wname, grpno, ansnum 
from tb_bbs
order by grpno desc, ansnum asc;
2) 
select rownum, wname, grpno, ansnum
from tb_bbs 
order by grpno desc, ansnum asc;
3)
select rownum, sub.* from (select wname, grpno, ansnum
from tb_bbs 
order by grpno desc, ansnum asc) sub;
4)
select * from (select rownum as rn , sub.* from (select wname, grpno, ansnum
from tb_bbs 
order by grpno desc, ansnum asc) sub) 
where rn>=6 and rn<=10;

--���������̼�+�˻�
select * from (select rownum as rn , sub.* from (select subject, wname, grpno, ansnum
from tb_bbs 
where wname like '%user%' 
or subject like '%user%'
order by grpno desc, ansnum asc) sub
) 
where rn>=6 and rn<=10


--���� : ����� ���(�ڽı�)�� ������ ��ȸ�Ͻÿ�
	��) ���ѹα� 2
		���ʽ��ڸ��� 5
		������ ����� 7
		����ȭ
		select grpno from tb_bbs where grpno=bbsno group by grpno;
select count(grpno) cnt, grpno from tb_bbs group by grpno;
select subject from tb_bbs where grpno=bbsno;

select cnt 
from(select count(grpno) cnt, grpno from tb_bbs group by grpno) 
where cnt>1;

select bb.subject, aa.reply
from (select grpno, (count(*)-1) as reply
from tb_bbs
group by grpno) aa join tb_bbs bb
on aa.grpno=bb.grpno
where bb.indent=0
order by bb.grpno desc;

----------------------�������� 
1)���̺� ����
   create table tb_notice(
     noticeno   number           not null  -- �Ϸù�ȣ
    ,subject    varchar2(255)    not null  -- ����
    ,content    varchar2(4000)   not null  -- ����
    ,regdt      date    default  sysdate   -- �ۼ���
    ,primary key(noticeno)                 -- noticeno �⺻Ű 
   );
2) �Ϸù�ȣ ������ ����

   create sequence noticeno_seq;
   
3) �׽�Ʈ ������ insert
	insert into tb_notice(noticeno,subject,content) 
	values(noticeno_seq.nextval,'�׽�Ʈ1','�׽�Ʈ1');
----------------------------------------------
3) JSP �۾����� : notice ����


4) Package��    : net.notice
5) �ڹٺ��� ���ϸ�
   net.notice.NoticeDTO
   net.notice.NoticeDAO
   
2. JSP ����

1) �������� �Է���   : noticeForm.jsp   
   - ����, ���뿡 �� ���ڿ��� �Էµ��� �ʵ��� �ڹٽ�ũ��Ʈ ��ȿ�� �˻� �߰�

2) �������� �߰�     : noticeIns.jsp

3) �������� ����Ʈ   : noticeList.jsp 
   -����, �ۼ��� ���

4) �������� �󼼺��� : noticeRead.jsp

5) �������� ����     : noticeDel.jsp

6) �������� ����     : noticeUpdate.jsp
------------------------
SELECT noticeno, subject, content, regdt FROM tb_notice ORDER BY noticeno desc