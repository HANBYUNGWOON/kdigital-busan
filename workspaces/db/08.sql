-- Book ���̺� ���ο� ���� �������� ���С��� �����Ͻÿ�. 
-- ������ ������ �Ѽ����м������� �Ⱓ������ ������ 90,000���̴�.

ALTER TABLE BOOK MODIFY BOOKID NUMBER;
DESC BOOK;

INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (98, '����������-OCH', '�Ѽ����м���', 90000);
COMMIT; -- �ӽ� ����� �۾��� Ȯ�� ( ROLLBACK�� �ӽ� ����� �۾� ��� )

SELECT * FROM BOOK;

-- ������ ����
DELETE FROM BOOK 
WHERE BOOKID = 98;
COMMIT;
SELECT * FROM BOOK;

--Book ���̺� ���ο� ���� �������� ���С��� �����Ͻÿ�. ������ ������
--�Ѽ����м������� �Ⱓ������ ������ �����̴�.

DESC BOOK;

INSERT INTO BOOK (BOOKID, BOOKNAME, PUBLISHER)
VALUES (98, '������ ����-OCH', '�Ѽ����м���');
COMMIT;
SELECT * FROM BOOK;

DELETE FROM BOOK WHERE BOOKID = 98;
COMMIT;
SELECT * FROM BOOK;

-- ���Ե��� ���(Imported_book)�� Book ���̺� ��� �����Ͻÿ� 
CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
);
SELECT * FROM NEWBOOK_OCH;

INSERT INTO NEWBOOK_OCH (BOOKID, BOOKNAME, PUBLISHER, PRICE)
SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
FROM IMPORTED_BOOK;

COMMIT;

SELECT * FROM NEWBOOK_OCH;

-- Customer ���̺��� ����ȣ�� 5�� ���� �ּҸ� �����ѹα� �λꡯ���� �����Ͻÿ�
DESC CUSTOMER;

INSERT INTO CUSTOMER (CUSTID, NAME, ADDRESS, PHONE)
VALUES (98, '�嵿��', '���ѹα� ����', '010-9807-4599');
COMMIT;

SELECT * FROM CUSTOMER;

UPDATE CUSTOMER
SET ADDRESS = '���ѹα� ���', PHONE = '010-7680-3498'
WHERE CUSTID = 98;
COMMIT;

SELECT * FROM CUSTOMER;

-- Customer ���̺��� �ڼ��� ���� �ּҸ� �迬�� ���� �ּҷ� �����Ͻÿ�
UPDATE CUSTOMER
SET ADDRESS = ( SELECT ADDRESS 
                FROM CUSTOMER
                WHERE NAME = '�迬��' )
WHERE CUSTID = 98;
COMMIT;

SELECT * FROM CUSTOMER;

--

SELECT * FROM NEWBOOK_OCH;
DELETE FROM NEWBOOK_OCH;
SELECT * FROM NEWBOOK_OCH;
ROLLBACK; -- ������ COMMIT OR ROLLBACK ���Ŀ� ����� �ӽ� �۾� ���
SELECT * FROM NEWBOOK_OCH;

-- Customer ���̺��� ����ȣ�� 4�� ���� �����Ͻÿ�
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

DELETE FROM CUSTOMER 
WHERE CUSTID = 5;


