-- 계정 생성
CREATE USER phonedb IDENTIFIED BY phonedb;

-- 권한 주기
GRANT resource, connect TO phonedb;

-- 테이블 삭제
DROP TABLE person;

-- 시퀀스 삭제
DROP SEQUENCE seq_person_id;

-- 테이블 생성
CREATE TABLE person (
    person_id  NUMBER(5),
    PRIMARY KEY ( person_id ),
    name       VARCHAR2(30) NOT NULL,
    hp         VARCHAR2(20),
    company    VARCHAR2(20)
);

-- 시퀀스 생성
CREATE SEQUENCE seq_person_id INCREMENT BY 1 START WITH 1 NOCACHE;

-- INSERT문 (이효리)
INSERT INTO person VALUES (
    seq_person_id.NEXTVAL,
    '이효리',
    '010-1111-1111',
    '02-1111-1111'
);

-- INSERT문 (정우성)
INSERT INTO person VALUES (
    seq_person_id.NEXTVAL,
    '정우성',
    '010-2222-2222',
    '02-2222-2222'
);

-- INSERT문 (유재석)
INSERT INTO person VALUES (
    seq_person_id.NEXTVAL,
    '유재석',
    '010-3333-3333',
    '02-3333-3333'
);

-- INSERT문 (이정재)
INSERT INTO person VALUES (
    seq_person_id.NEXTVAL,
    '이정재',
    '010-4444-4444',
    '02-4444-4444'
);

-- INSERT문 (서장훈)
INSERT INTO person VALUES (
    seq_person_id.NEXTVAL,
    '서장훈',
    '010-5555-5555',
    '02-5555-5555'
);

-- SELECT문
SELECT
    person_id,
    name,
    hp,
    company
FROM
    person;
    
-- UPDATE문 (이정재)
UPDATE person
SET
    name = '유병재',
    hp = '010-9999-9999',
    company = '02-9999-9999'
WHERE
    person_id = 4;
    
-- DELETE문 (서장훈)
DELETE FROM person
WHERE
    person_id = 5;
    
-- 검색
SELECT
    person_id,
    name,
    hp,
    company
FROM
    person
WHERE
    person_id LIKE '%2%'
    OR name LIKE '%2%'
    OR hp LIKE '%2%'
    OR company LIKE '%2%';