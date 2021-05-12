--pds.sql

   CREATE TABLE tb_pds (
      pdsno       INT            NOT NULL AUTO_INCREMENT PRIMARY KEY
      ,wname      VARCHAR(100)   NOT NULL
      ,subject    VARCHAR(250)   NOT NULL
      ,regdate    DATETIME       NOT NULL
      ,passwd     VARCHAR(15)    NOT NULL
      ,readcnt    INT            DEFAULT 0
      ,filename   VARCHAR(250)   NOT NULL
      ,filesize   INT            DEFAULT 0
    );
