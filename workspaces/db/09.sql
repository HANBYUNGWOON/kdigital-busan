
-- 키 : 후보키, 기본키, 대체키, 대리키

-- 대리키를 만드는 방법 : ..., 자동증가번호

-- 자동증가번호 구현 : 컬럼의 속성, 번호생성기

-- 오라클은 번호 생성기 지원 : SEQUENCE

CREATE SEQUENCE OCH_SEQUENCE NOCACHE;

-- 번호생성기에서 새 번호 받기
SELECT OCH_SEQUENCE.NEXTVAL FROM DUAL;
-- 마지막으로 뽑힌 번호 다시 받기
SELECT OCH_SEQUENCE.CURRVAL FROM DUAL;

SELECT * FROM DUAL;