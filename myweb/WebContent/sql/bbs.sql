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

[검색]
--키워드 한개일때 검색 ex)솔데스크
select * from tb_bbs where wname like '%솔데스크%'
select * from tb_bbs where subject like '%솔데스크%'
select * from tb_bbs where content like '%솔데스크%'

--제목 또는 내용에서 검색
select * from tb_bbs 
where wname like '%솔데스크%' 
or subject like '%솔데스크%'
