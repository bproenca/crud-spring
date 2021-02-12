CREATE TABLE ABC_USER 
(
  ID NUMBER NOT NULL 
, NAME VARCHAR2(50) NOT NULL 
, EMAIL VARCHAR2(50) 
, DH_DATE DATE 
, DH_TIMESTAMP TIMESTAMP 
, CONSTRAINT ABC_USER_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

ALTER TABLE ABC_USER 
ADD (DT_NOTIME_DATE DATE );

ALTER TABLE ABC_USER 
ADD (DT_NOTIME_TIMESTAMP TIMESTAMP );