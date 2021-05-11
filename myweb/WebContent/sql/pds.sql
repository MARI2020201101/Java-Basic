CREATE TABLE tb_pds (
  pdsno       NUMBER         NOT NULL
  ,wname      VARCHAR2(100)  NOT NULL
  ,subject    VARCHAR2(250)  NOT NULL
  ,regdate    DATE           NOT NULL
  ,passwd     VARCHAR2(15)   NOT NULL
  ,readcnt    NUMBER         DEFAULT 0
  ,filename   VARCHAR2(250)  NOT NULL   --파일명
  ,filesize   NUMBER         DEFAULT 0  --파일크기
  ,PRIMARY KEY(pdsno)
);
create sequence pds_seq;

--행추가
insert into tb_pds(
	pdsno,wname,subject,passwd,filename,filesize,regdate)
values(pds_seq.nextval,?,?,?,?,?,sysdate);

--select list
select pdsno,wname,subject,filename,regdate,readcnt 
from tb_pds
order by regdate desc;

--삭제하기
글번호와 비밀번호가 일치하면 테이블 행 삭제 + 관련 첨부파일 삭제
