-- 가장 비싼 도서의 이름을 보이시오

SELECT * FROM BOOK ORDER BY PRICE DESC;

SELECT MAX(PRICE) FROM BOOK;
SELECT * FROM BOOK WHERE PRICE = 35000;

SELECT * FROM BOOK WHERE PRICE = ( SELECT MAX(PRICE) FROM BOOK );

-- 도서를 구매한 적이 있는 고객의 이름을 검색하시오
SELECT DISTINCT C.NAME
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID;

SELECT DISTINCT CUSTID
FROM ORDERS;

SELECT *
FROM CUSTOMER C
WHERE C.CUSTID IN ( 1, 2, 3, 4 );-- 구매한 적이 있는

SELECT *
FROM CUSTOMER C
WHERE C.CUSTID IN ( SELECT DISTINCT CUSTID
                    FROM ORDERS );-- 구매한 적이 있는
                    
-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 보이시오.

SELECT * FROM BOOK WHERE PUBLISHER = '대한미디어'; -- ( BOOKID : 3, 4 )

SELECT * FROM ORDERS WHERE BOOKID IN ( 3, 4 ); -- ( CUSTID : 1 )

SELECT * FROM CUSTOMER WHERE CUSTID IN ( 1 );

SELECT * 
FROM CUSTOMER 
WHERE CUSTID IN ( SELECT CUSTID 
                  FROM ORDERS 
                  WHERE BOOKID IN ( SELECT BOOKID
                                    FROM BOOK 
                                    WHERE PUBLISHER = '대한미디어' ) );


                    