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
1) 패스워드 확인
select wname, subject, content, passwd 
where bbsno=? and passwd=?
2) 글 수정
update tb_bbs set wname=? , subject=?, content=?, passwd=?
where bbsno=? 