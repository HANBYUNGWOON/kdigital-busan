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




