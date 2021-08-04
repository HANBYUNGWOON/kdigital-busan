-- 박지성 고객이 구매한 도서의 출판사 수

SELECT COUNT(DISTINCT PUBLISHER) "출판사수"
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE B.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '박지성';
      
-- 표준 SQL 구문을 작성하세요.
      
-- 박지성 고객이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이

SELECT B.BOOKNAME "도서명", B.PRICE "정가", B.PRICE - O.SALEPRICE "할인액"
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE B.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '박지성';
      
-- 표준 SQL 구문을 작성하세요

-- 박지성 고객이 구매하지 않은 도서의 이름
SELECT B.BOOKNAME
FROM BOOK B
WHERE NOT EXISTS ( SELECT * 
                   FROM CUSTOMER C, ORDERS O
                   WHERE C.CUSTID = O.CUSTID AND
                         O.BOOKID = B.BOOKID AND
                         C.NAME = '박지성' );
                         
SELECT DISTINCT B.BOOKNAME
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+)
      AND
      ( O.CUSTID <> ( SELECT C.CUSTID
                      FROM CUSTOMER C
                      WHERE C.NAME = '박지성' )
        OR
        O.CUSTID IS NULL );

SELECT B.BOOKNAME
FROM BOOK B
MINUS
SELECT B2.BOOKNAME
FROM BOOK B2, ORDERS O, CUSTOMER C
WHERE B2.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '박지성';
      
-- 주문하지 않은 고객의 이름(부속질의 사용)
SELECT *
FROM CUSTOMER C
WHERE C.CUSTID NOT IN ( SELECT DISTINCT CUSTID
                        FROM ORDERS );
                        
--  주문 금액의 총액과 주문의 평균 금액
SELECT SUM(O.SALEPRICE) "주문총액", AVG(O.SALEPRICE) "평균금액"
FROM ORDERS O;

-- (주문이 있는) 고객의 이름과 고객별 구매액 합계
SELECT C.NAME, SUM(O.SALEPRICE) "주문총액"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME;

-- (모든) 고객의 이름과 고객별 구매액 합계
SELECT C.NAME, NVL(SUM(O.SALEPRICE), 0) "주문총액"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID(+)
GROUP BY C.NAME
ORDER BY C.NAME;

SELECT C.NAME, NVL(SUM(O.SALEPRICE), 0) "주문총액"
FROM CUSTOMER C
LEFT OUTER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME;

-- 고객의 이름과 고객이 구매한 도서 목록
SELECT C.NAME, B.*
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTID = O.CUSTID AND
      O.BOOKID = B.BOOKID
ORDER BY C.NAME, B.BOOKNAME;

-- 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
SELECT B.BOOKNAME, ( B.PRICE - O.SALEPRICE ) "할인액"
FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID
      AND
      ( B.PRICE - O.SALEPRICE ) = ( SELECT MAX(B2.PRICE - O2.SALEPRICE)
                                    FROM ORDERS O2, BOOK B2
                                    WHERE O2.BOOKID = B2.BOOKID ); -- 최대 할인 주문
                                          -- AND B.BOOKID = B2.BOOKID); -- 도서별 최대 할인 주문

-- 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
SELECT C.NAME, AVG(SALEPRICE) "구매액평균"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING AVG(SALEPRICE) > ( SELECT AVG(SALEPRICE)
                          FROM ORDERS );









