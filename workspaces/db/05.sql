-- ���� ��� ������ �̸��� ���̽ÿ�

SELECT * FROM BOOK ORDER BY PRICE DESC;

SELECT MAX(PRICE) FROM BOOK;
SELECT * FROM BOOK WHERE PRICE = 35000;

SELECT * FROM BOOK WHERE PRICE = ( SELECT MAX(PRICE) FROM BOOK );

-- ������ ������ ���� �ִ� ���� �̸��� �˻��Ͻÿ�
SELECT DISTINCT C.NAME
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID;

SELECT DISTINCT CUSTID
FROM ORDERS;

SELECT *
FROM CUSTOMER C
WHERE C.CUSTID IN ( 1, 2, 3, 4 );-- ������ ���� �ִ�

SELECT *
FROM CUSTOMER C
WHERE C.CUSTID IN ( SELECT DISTINCT CUSTID
                    FROM ORDERS );-- ������ ���� �ִ�
                    
-- ���ѹ̵��� ������ ������ ������ ���� �̸��� ���̽ÿ�.

SELECT * FROM BOOK WHERE PUBLISHER = '���ѹ̵��'; -- ( BOOKID : 3, 4 )

SELECT * FROM ORDERS WHERE BOOKID IN ( 3, 4 ); -- ( CUSTID : 1 )

SELECT * FROM CUSTOMER WHERE CUSTID IN ( 1 );

SELECT * 
FROM CUSTOMER 
WHERE CUSTID IN ( SELECT CUSTID 
                  FROM ORDERS 
                  WHERE BOOKID IN ( SELECT BOOKID
                                    FROM BOOK 
                                    WHERE PUBLISHER = '���ѹ̵��' ) );


                    