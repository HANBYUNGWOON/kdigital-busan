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
                                    
SELECT C.*
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTID = O.CUSTID
      AND
      O.BOOKID = B.BOOKID
      AND 
      PUBLISHER = '���ѹ̵��';
      
SELECT C.*
FROM BOOK B
INNER JOIN ORDERS O
ON B.BOOKID = O.BOOKID
INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
WHERE B.PUBLISHER = '���ѹ̵��';

-- ���ǻ纰�� ���ǻ��� ��� ���� ���ݺ��� ��� ������ ���Ͻÿ�

SELECT PUBLISHER, AVG(PRICE)
FROM BOOK
GROUP BY PUBLISHER; -- �̻�̵�� 16500, ...

SELECT *
FROM BOOK
WHERE PRICE > 16500 AND PUBLISHER = '�̻�̵��'; -- �� ���ǻ��� ��հ��ݰ� ���ǻ� �̸��� �����ؼ� ����

SELECT B1.*
FROM BOOK B1
WHERE B1.PRICE >= ( SELECT AVG(B2.PRICE)
                    FROM BOOK B2
                    WHERE B2.PUBLISHER = B1.PUBLISHER );
                    
-- �ֹ��� �ִ� ���� �̸��� �ּҸ� ���̽ÿ�
SELECT DISTINCT C.NAME, C.ADDRESS
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID;

SELECT C.CUSTID, C.NAME, C.ADDRESS
FROM CUSTOMER C
WHERE EXISTS ( SELECT *
               FROM ORDERS O
               WHERE O.CUSTID = C.CUSTID );

SELECT C.CUSTID, C.NAME, C.ADDRESS
FROM CUSTOMER C
WHERE C.CUSTID IN ( SELECT O.CUSTID
                   FROM ORDERS O
                   WHERE O.CUSTID = C.CUSTID );














                    