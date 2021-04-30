--bbs.sql
--답변 및 댓글형 게시판

--테이블 삭제
drop table tb_bbs;

--테이블 생성
create table tb_bbs(
  bbsno    number(5)       not null -- 일련번호 -99999~99999
 ,wname    varchar2(20)    not null -- 작성자
 ,subject  varchar2(100)   not null -- 글제목
 ,content  varchar2(2000)  not null -- 글내용
 ,passwd   varchar2(10)    not null -- 글비밀번호
 ,readcnt  number(5)       default 0 not null -- 글조회수
 ,regdt    date            default  sysdate   -- 글작성일
 ,grpno    number(5)       not null  -- 글 그룹번호
 ,indent   number(5)       default 0 -- 들여쓰기
 ,ansnum   number(5)       default 0 -- 글순서
 ,ip       varchar2(15)    not null  -- 글 IP
 ,primary key(bbsno)                 --bbsno 기본키 
);

--시퀀스 생성
create sequence bbs_seq;

--시퀀스 삭제
drop sequence bbs_seq;

--새 글쓰기(insert)
bbsno: 시퀀스 이용한 일련번호
wname, subject, content, passwd: 사용자 입력
readcnt, regdt, indent, ansnum : default값
grpno : max(bbsno)+1 답변/댓글에 사용하기위한 컬럼... 같은 글 밑에는 같은 번호가 들어간다(?)
ip : request 뽑아와서 저장

insert into tb_bbs(bbsno, wname, subject, content, passwd,ip, grpno)
values(sequence bbs_seq.nextval,
?,?,?,?,?,(select nvl(max(bbsno),0)+1 from tb_bbs));

--글 list 전체목록보기
select bbsno, wname, subject, readcnt, regdt
from tb_bbs
order by grpno desc, ansnum asc

--상세보기
select * from tb_bbs where bbsno=?

--글 조회수 올리기
update tb_bbs set readcnt=(readcnt+1) where bbsno=?

--글 삭제하기
delete tb_bbs where passwd=? and bbsno=?

--글 수정하기(update)
update tb_bbs 
set wname=? , subject=?, content=?
where bbsno=? and passwd=?

--답변쓰기 알고리즘
1) 새글쓰기 : 최초의 부모글
2) 답변쓰기 : 자식글
3) 그룹번호(grpno) : 조상글과 같은 값공유.
4) 들여쓰기(indent) : 자식-손자-증손자.. 등의 구분. 
					갯수별로 indent기호 view에 출력.
5) 글순서(ansno) : 같은 조상그룹내의 글 순서 조정. 부모글+1 을 하고, 
					자기보다밑에오는 녀석들의 번호 조정필요.

--글순서 재조정
update tb_bbs set ansnum=ansnum+1 
where ansnum>=ansnum+1 and grpno=조상그룹넘버;

--글 목록
select * from tb_bbs
order by grpno desc, ansnum asc

--reply의 indent,ansno넣기
select grpno,indent,ansno from tb_bbs where bbsno=?

--전체 게시글 갯수 출력
select count(bbsno) from tb_bbs

///////////[검색]////////////
--키워드 한개일때 검색 ex)솔데스크
select * from tb_bbs where wname like '%솔데스크%'
select * from tb_bbs where subject like '%솔데스크%'
select * from tb_bbs where content like '%솔데스크%'

--제목 또는 내용에서 검색
select * from tb_bbs 
where wname like '%솔데스크%' 
or subject like '%솔데스크%'


//////////[페이지네이션]///////////
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

--페이지네이션+검색
select * from (select rownum as rn , sub.* from (select subject, wname, grpno, ansnum
from tb_bbs 
where wname like '%user%' 
or subject like '%user%'
order by grpno desc, ansnum asc) sub
) 
where rn>=6 and rn<=10


--과제 : 제목과 댓글(자식글)의 갯수를 조회하시오
	예) 대한민국 2
		오필승코리아 5
		오늘은 목요일 7
		무궁화
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

----------------------공지사항 
1)테이블 생성
   create table tb_notice(
     noticeno   number           not null  -- 일련번호
    ,subject    varchar2(255)    not null  -- 제목
    ,content    varchar2(4000)   not null  -- 내용
    ,regdt      date    default  sysdate   -- 작성일
    ,primary key(noticeno)                 -- noticeno 기본키 
   );
2) 일련번호 시퀀스 생성

   create sequence noticeno_seq;
   
3) 테스트 데이터 insert
	insert into tb_notice(noticeno,subject,content) 
	values(noticeno_seq.nextval,'테스트1','테스트1');
----------------------------------------------
3) JSP 작업폴더 : notice 생성


4) Package명    : net.notice
5) 자바빈즈 파일명
   net.notice.NoticeDTO
   net.notice.NoticeDAO
   
2. JSP 파일

1) 공지사항 입력폼   : noticeForm.jsp   
   - 제목, 내용에 빈 문자열이 입력되지 않도록 자바스크립트 유효성 검사 추가

2) 공지사항 추가     : noticeIns.jsp

3) 공지사항 리스트   : noticeList.jsp 
   -제목, 작성일 출력

4) 공지사항 상세보기 : noticeRead.jsp

5) 공지사항 삭제     : noticeDel.jsp

6) 공지사항 수정     : noticeUpdate.jsp
------------------------
SELECT noticeno, subject, content, regdt FROM tb_notice ORDER BY noticeno desc