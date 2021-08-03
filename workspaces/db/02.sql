-- ������ȣ�� 1�� ������ �̸� (���� ����)

DESC BOOK;
-- SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
SELECT *
FROM BOOK
WHERE BOOKID = 1;

-- ������ 20,000�� �̻��� ������ �̸� (���� ����)

SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
FROM BOOK
WHERE PRICE >= 20000;

-- ������ ���� �� ���ž�, ���� ����
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER; -- �� ��ȸ�� ���� ������ ���� CUSTID�� 1�� ���� Ȯ��

SELECT 
    '������' AS "����" -- ���ͷ��� ��ȸ ����� ������ �� �ֽ��ϴ�.
    , SUM(SALEPRICE) AS "�ѱ��ž�"
    , COUNT(*) AS "����"
FROM ORDERS
WHERE CUSTID = 1; -- ������ ���� �ǹ�
-- GROUP BY CUSTID;

-- ���缭�� ������ �� ����
SELECT COUNT(*) "��������"
FROM BOOK;

-- ���缭���� ������ ����ϴ� ���ǻ��� �� ����
SELECT COUNT(PUBLISHER) PUBLISHER_COUNT -- �ߺ��� ������ ����
FROM BOOK;

SELECT PUBLISHER
FROM BOOK;

SELECT DISTINCT PUBLISHER
FROM BOOK;

SELECT COUNT (DISTINCT PUBLISHER) PUBLISHER_COUNT -- �ߺ��� ������ ����
FROM BOOK;

-- ��� ���� �̸�, �ּ�

SELECT NAME, ADDRESS 
FROM CUSTOMER;

-- 2020�� 7�� 4��~7�� 7�� ���̿� �ֹ� ���� ������ �ֹ���ȣ
SELECT *
FROM ORDERS
WHERE ORDERDATE >= '2020-07-04' AND ORDERDATE <= '2020-07-07';

SELECT *
FROM ORDERS
WHERE ORDERDATE BETWEEN '2020-07-04' AND '2020-07-07';

-- 2020�� 7�� 4��~7�� 7�� ���̿� �ֹ� ���� ������ ������ ������ �ֹ���ȣ
SELECT *
FROM ORDERS
WHERE ORDERDATE < '2020-07-04' OR ORDERDATE > '2020-07-07';

SELECT *
FROM ORDERS
WHERE ORDERDATE NOT BETWEEN '2020-07-04' AND '2020-07-07';

-- ���� ���衯 ���� ���� �̸��� �ּ�
SELECT NAME, ADDRESS
FROM CUSTOMER
WHERE NAME LIKE '��%';

--  ���� ���衯 ���̰� �̸��� ���ơ��� ������ ���� �̸��� �ּ�
SELECT NAME, ADDRESS
FROM CUSTOMER
WHERE NAME LIKE '��%��';