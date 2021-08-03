-- ��� ������ ��� �÷� ������ �˻��Ͻÿ�
SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
FROM BOOK;

SELECT *
FROM Book;

-- ��� ������ �̸��� ������ �˻��Ͻÿ�
SELECT BOOKNAME, PRICE
FROM BOOK;

SELECT PRICE, BOOKNAME
FROM BOOK;

-- ���� ���̺� �ִ� ��� ���ǻ縦 �˻��Ͻÿ�
SELECT PUBLISHER
FROM BOOK;

-- ���� ���̺� �ִ� ��� ���ǻ縦 ( �ߺ��� �����ϰ� ) �˻��Ͻÿ�
SELECT DISTINCT PUBLISHER
FROM BOOK;

-- ������ 20,000�� �̸��� ������ �˻��Ͻÿ�.
SELECT *
FROM BOOK
WHERE PRICE < 20000;

-- ������ 10,000�� �̻� 20,000 ������ ������ �˻��Ͻÿ�.
SELECT * 
FROM BOOK
WHERE PRICE >= 10000 AND PRICE <= 20000;

SELECT *
FROM BOOK
WHERE PRICE BETWEEN 10000 AND 20000;

-- ���ǻ簡 ���½������� Ȥ�� �����ѹ̵��� ������ �˻��Ͻÿ�
-- ������� 1 : ���ڿ��� ��¥ ǥ�� ��� -> ��������ǥ (')
-- ������� 2 : ���ϼ� �� ������ -> =
SELECT *
FROM BOOK
WHERE PUBLISHER = '�½�����' OR PUBLISHER = '���ѹ̵��';

SELECT *
FROM BOOK
WHERE PUBLISHER IN ('�½�����', '���ѹ̵��');

-- ���ǻ簡 ���½��������� �����ѹ̵��� �ƴ� ������ �˻��Ͻÿ�
SELECT *
FROM BOOK
WHERE PUBLISHER != '�½�����' AND PUBLISHER != '���ѹ̵��';

SELECT *
FROM BOOK
WHERE PUBLISHER <> '�½�����' AND PUBLISHER <> '���ѹ̵��';

SELECT *
FROM BOOK
WHERE PUBLISHER NOT IN ('�½�����', '���ѹ̵��');

-- ���౸�� ���硯�� �Ⱓ�� ������ �˻��Ͻÿ�
SELECT *
FROM BOOK
WHERE BOOKNAME = '�౸�� ����';

-- �����̸��� ���౸���� ���Ե� ������ �˻��Ͻÿ�
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%�౸%'; -- % : 0 OR MORE

-- �����̸��� ���� �� ��° ��ġ�� ��������� ���ڿ��� ���� ������ �˻��Ͻÿ�
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '_��%'; -- _ : ONLY ONE

-- �౸�� ���� ���� �� ������ 20,000�� �̻��� ������ �˻��Ͻÿ�
SELECT *
FROM BOOK
WHERE BOOKNAME LIKE '%�౸%' AND PRICE >= 20000;

-- ���ǻ簡 ���½������� Ȥ�� �����ѹ̵��� ������ �˻��Ͻÿ�.
SELECT *
FROM BOOK
WHERE PUBLISHER = '�½�����' OR PUBLISHER = '���ѹ̵��';

-- �ֹ����ڰ� 2020/07/04 �� �ֹ� ��ȸ
DESC ORDERS;
SELECT * FROM ORDERS;
SELECT *
FROM ORDERS
WHERE ORDERDATE = '2020-07-04'; -- ��¥ ���ͷ��� ���ڿ��� ���� ǥ�� ( ���� ����ǥ ��� )


-- ������ �̸������� �˻��Ͻÿ�
SELECT *
FROM BOOK;

SELECT *
FROM BOOK
ORDER BY BOOKNAME;

SELECT *
FROM BOOK
ORDER BY BOOKNAME ASC; -- ASC : �������� ���� (DEFAULT)

SELECT *
FROM BOOK
ORDER BY BOOKNAME DESC; -- DESC : �������� ����

-- ������ ���ݼ����� �˻��ϰ�, ������ ������ �̸������� �˻��Ͻÿ�.
SELECT *
FROM BOOK
ORDER BY PRICE, BOOKNAME;

-- ������ ������ ������������ �˻��Ͻÿ�. ���� ������ ���ٸ� ���ǻ��� ������������ �˻��Ͻÿ�
SELECT *
FROM BOOK
ORDER BY PRICE DESC, PUBLISHER ASC;

-- ���� �ֹ��� ������ �� �Ǹž��� ���Ͻÿ�

SELECT SUM(SALEPRICE)
FROM ORDERS;

SELECT SUM(SALEPRICE) AS SALES_TOTAL -- AS ALIAS_NAME : ALIAS_NAME�� �÷������� ��� ( AS�� ���� ���� )
FROM ORDERS;

SELECT SUM(SALEPRICE) SALES_TOTAL
FROM ORDERS;

-- �迬�� ���� �ֹ��� ������ �� �Ǹž��� ���Ͻÿ�

SELECT * FROM BOOK;     -- '�迬��' �� ������ ã�� ���� BOOK TABLE ��ȸ --> ������ ����
SELECT * FROM CUSTOMER; -- '�迬��' �� ������ ã�� ���� CUSTOMER TABLE ��ȸ --> ������ ���� --> 2�� Ȯ��
SELECT * FROM ORDERS;

SELECT SUM(SALEPRICE) SALES_TOTAL
FROM ORDERS
WHERE CUSTID = 2;

-- ���� �ֹ��� ������ �� �Ǹž�, ��հ�, ������, �ְ��� ���Ͻÿ�.
SELECT 
    SUM(SALEPRICE) SALES_TOTAL
    , COUNT(SALEPRICE) SALES_COUNT
    , AVG(SALEPRICE) SALES_AVG
    , MIN(SALEPRICE) SALES_MIN
    , MAX(SALEPRICE) SALES_MAX
FROM
    ORDERS;
    
-- ���缭���� ���� �Ǹ� �Ǽ��� ���Ͻÿ�
SELECT COUNT(*) SALES_COUNT
FROM ORDERS;

-- ������ �ֹ��� ������ �� ������ �� �Ǹž��� ���Ͻÿ�
SELECT
    CUSTID 
    -- , ORDERID
    , COUNT(SALEPRICE) SALES_COUNT
    , SUM(SALEPRICE) SALES_TOTAL
FROM
    ORDERS
GROUP BY CUSTID;

-- ������ 8,000�� �̻��� ������ ������ ���� ���Ͽ� ���� �ֹ� ������ �� ������ ���Ͻÿ�. 
-- ��, �� �� �̻� ������ ���� ���Ѵ�

SELECT -- 5
    CUSTID
    , COUNT(*) SALES_COUNT 
    , AVG(SALEPRICE) SALES_AVG
FROM ORDERS -- 1
WHERE SALEPRICE >= 8000 -- 2
GROUP BY CUSTID -- 3
HAVING COUNT(*) >= 2; -- 4

