-- ������ ���� ������ ������ ���ǻ� ��

SELECT COUNT(DISTINCT PUBLISHER) "���ǻ��"
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE B.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '������';
      
-- ǥ�� SQL ������ �ۼ��ϼ���.
      
-- ������ ���� ������ ������ �̸�, ����, ������ �ǸŰ����� ����

SELECT B.BOOKNAME "������", B.PRICE "����", B.PRICE - O.SALEPRICE "���ξ�"
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE B.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '������';
      
-- ǥ�� SQL ������ �ۼ��ϼ���

-- ������ ���� �������� ���� ������ �̸�
SELECT B.BOOKNAME
FROM BOOK B
WHERE NOT EXISTS ( SELECT * 
                   FROM CUSTOMER C, ORDERS O
                   WHERE C.CUSTID = O.CUSTID AND
                         O.BOOKID = B.BOOKID AND
                         C.NAME = '������' );
                         
SELECT DISTINCT B.BOOKNAME
FROM BOOK B, ORDERS O
WHERE B.BOOKID = O.BOOKID(+)
      AND
      ( O.CUSTID <> ( SELECT C.CUSTID
                      FROM CUSTOMER C
                      WHERE C.NAME = '������' )
        OR
        O.CUSTID IS NULL );

SELECT B.BOOKNAME
FROM BOOK B
MINUS
SELECT B2.BOOKNAME
FROM BOOK B2, ORDERS O, CUSTOMER C
WHERE B2.BOOKID = O.BOOKID AND
      O.CUSTID = C.CUSTID AND
      C.NAME = '������';
      
-- �ֹ����� ���� ���� �̸�(�μ����� ���)
SELECT *
FROM CUSTOMER C
WHERE C.CUSTID NOT IN ( SELECT DISTINCT CUSTID
                        FROM ORDERS );
                        
--  �ֹ� �ݾ��� �Ѿװ� �ֹ��� ��� �ݾ�
SELECT SUM(O.SALEPRICE) "�ֹ��Ѿ�", AVG(O.SALEPRICE) "��ձݾ�"
FROM ORDERS O;

-- (�ֹ��� �ִ�) ���� �̸��� ���� ���ž� �հ�
SELECT C.NAME, SUM(O.SALEPRICE) "�ֹ��Ѿ�"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME;

-- (���) ���� �̸��� ���� ���ž� �հ�
SELECT C.NAME, NVL(SUM(O.SALEPRICE), 0) "�ֹ��Ѿ�"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID(+)
GROUP BY C.NAME
ORDER BY C.NAME;

SELECT C.NAME, NVL(SUM(O.SALEPRICE), 0) "�ֹ��Ѿ�"
FROM CUSTOMER C
LEFT OUTER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY C.NAME;

-- ���� �̸��� ���� ������ ���� ���
SELECT C.NAME, B.*
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTID = O.CUSTID AND
      O.BOOKID = B.BOOKID
ORDER BY C.NAME, B.BOOKNAME;

-- ������ ����(Book ���̺�)�� �ǸŰ���(Orders ���̺�)�� ���̰� ���� ���� �ֹ�
SELECT B.BOOKNAME, ( B.PRICE - O.SALEPRICE ) "���ξ�"
FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID
      AND
      ( B.PRICE - O.SALEPRICE ) = ( SELECT MAX(B2.PRICE - O2.SALEPRICE)
                                    FROM ORDERS O2, BOOK B2
                                    WHERE O2.BOOKID = B2.BOOKID ); -- �ִ� ���� �ֹ�
                                          -- AND B.BOOKID = B2.BOOKID); -- ������ �ִ� ���� �ֹ�

-- ������ �Ǹž� ��պ��� �ڽ��� ���ž� ����� �� ���� ���� �̸�
SELECT C.NAME, AVG(SALEPRICE) "���ž����"
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING AVG(SALEPRICE) > ( SELECT AVG(SALEPRICE)
                          FROM ORDERS );









