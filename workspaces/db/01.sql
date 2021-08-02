-- 모든 도서의 모든 컬럼 정보를 검색하시오
SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
FROM BOOK;

SELECT *
FROM Book;

-- 모든 도서의 이름과 가격을 검색하시오
SELECT BOOKNAME, PRICE
FROM BOOK;

SELECT PRICE, BOOKNAME
FROM BOOK;

-- 도서 테이블에 있는 모든 출판사를 검색하시오
SELECT PUBLISHER
FROM BOOK;

-- 도서 테이블에 있는 모든 출판사를 ( 중복을 제거하고 ) 검색하시오
SELECT DISTINCT PUBLISHER
FROM BOOK;

-- 가격이 20,000원 미만인 도서를 검색하시오.
SELECT *
FROM BOOK
WHERE PRICE < 20000;

-- 가격이 10,000원 이상 20,000 이하인 도서를 검색하시오.
SELECT * 
FROM BOOK
WHERE PRICE >= 10000 AND PRICE <= 20000;

SELECT *
FROM BOOK
WHERE PRICE BETWEEN 10000 AND 20000;

-- 출판사가 ‘굿스포츠’ 혹은 ‘대한미디어’인 도서를 검색하시오
-- 고려사항 1 : 문자열과 날짜 표시 방법 -> 작은따옴표 (')
-- 고려사항 2 : 동일성 비교 연산자 -> =
SELECT *
FROM BOOK
WHERE PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어';

SELECT *
FROM BOOK
WHERE PUBLISHER IN ('굿스포츠', '대한미디어');

-- 출판사가 ‘굿스포츠’와 ‘대한미디어’가 아닌 도서를 검색하시오
SELECT *
FROM BOOK
WHERE PUBLISHER != '굿스포츠' AND PUBLISHER != '대한미디어';

SELECT *
FROM BOOK
WHERE PUBLISHER <> '굿스포츠' AND PUBLISHER <> '대한미디어';

SELECT *
FROM BOOK
WHERE PUBLISHER NOT IN ('굿스포츠', '대한미디어');

-- ‘축구의 역사’를 출간한 도서를 검색하시오
SELECT *
FROM BOOK
WHERE BOOKNAME = '축구의 역사';

-- 도서이름에 ‘축구’가 포함된 도서를 검색하시오
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%축구%'; -- % : 0 OR MORE

-- 도서이름의 왼쪽 두 번째 위치에 ‘구’라는 문자열을 갖는 도서를 검색하시오
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '_구%'; -- _ : ONLY ONE

-- 축구에 관한 도서 중 가격이 20,000원 이상인 도서를 검색하시오
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%축구%' AND PRICE >= 20000;

-- 출판사가 ‘굿스포츠’ 혹은 ‘대한미디어’인 도서를 검색하시오.
SELECT *
FROM BOOK
WHERE PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어';

-- 도서를 이름순으로 검색하시오
SELECT *
FROM BOOK;

SELECT *
FROM BOOK
ORDER BY BOOKNAME;

SELECT *
FROM BOOK
ORDER BY BOOKNAME ASC; -- ASC : 오름차순 정렬 (DEFAULT)

SELECT *
FROM BOOK
ORDER BY BOOKNAME DESC; -- DESC : 내림차순 정렬

-- 도서를 가격순으로 검색하고, 가격이 같으면 이름순으로 검색하시오.
SELECT *
FROM BOOK
ORDER BY PRICE, BOOKNAME;

-- 도서를 가격의 내림차순으로 검색하시오. 만약 가격이 같다면 출판사의 오름차순으로 검색하시오
SELECT *
FROM BOOK
ORDER BY PRICE DESC, PUBLISHER ASC;

-- 고객이 주문한 도서의 총 판매액을 구하시오

SELECT SUM(SALEPRICE)
FROM ORDERS;

SELECT SUM(SALEPRICE) AS SALES_TOTAL -- AS ALIAS_NAME : ALIAS_NAME을 컬럼명으로 사용 ( AS는 생략 가능 )
FROM ORDERS;

SELECT SUM(SALEPRICE) SALES_TOTAL
FROM ORDERS;

-- 김연아 고객이 주문한 도서의 총 판매액을 구하시오

SELECT * FROM BOOK;     -- '김연아' 고객 정보를 찾기 위해 BOOK TABLE 조회 --> 데이터 없음
SELECT * FROM CUSTOMER; -- '김연아' 고객 정보를 찾기 위해 CUSTOMER TABLE 조회 --> 데이터 있음 --> 2번 확인
SELECT * FROM ORDERS;

SELECT SUM(SALEPRICE) SALES_TOTAL
FROM ORDERS
WHERE CUSTID = 2;

