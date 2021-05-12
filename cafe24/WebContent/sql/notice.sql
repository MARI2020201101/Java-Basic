--notice.sql 
   
create table tb_notice(
     noticeno   INT           not null  AUTO_INCREMENT PRIMARY KEY-- 일련번호
    ,subject    VARCHAR(255)    not null  -- 제목
    ,content    VARCHAR(4000)   not null  -- 내용
    ,regdt      DATETIME    DEFAULT CURRENT_TIMESTAMP -- 작성일             
   );