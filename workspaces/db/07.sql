-- ������ ���� �Ӽ��� ���� NewBook ���̺��� �����Ͻÿ�,
-- �������� NUMBER��, �������� ������ ����Ÿ���� VARCHAR2�� ���
-- bookid(������ȣ) ? NUMBER
-- bookname(�����̸�) ? VARCHAR2(20)
-- publisher(���ǻ�) ? VARCHAR2(20)
-- price(����) ? NUMBER

CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
);

DROP TABLE NEWBOOK_OCH;

-- �ֽĺ��� ����
CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER -- PRIMARY KEY
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
    -- , PRIMARY KEY (BOOKID)
    -- , CONSTRAINT PK_NEWBOOK_OCH PRIMARY KEY (BOOKID)
    , PRIMARY KEY (BOOKID, BOOKNAME)
);
DESC NEWBOOK_OCH;
DROP TABLE NEWBOOK_OCH;

-- ��Ÿ ���� ���� : �⺻�� ����, CHECK ���� ����
CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER DEFAULT (0) CHECK(PRICE >= 0)
    , PRIMARY KEY (BOOKID)
);
DESC NEWBOOK_OCH;
DROP TABLE NEWBOOK_OCH;

-- ������ ���� �Ӽ��� ���� NewCustomer ���̺��� �����Ͻÿ�
--custid(����ȣ) - NUMBER, �⺻Ű
--name(�̸�) ? VARCHAR2(40)
--address(�ּ�) ? VARCHAR2(40)
--phone(��ȭ��ȣ) ? VARCHAR2(30)
CREATE TABLE NEWCUSTOMER_OCH
(
    CUSTID NUMBER
    , NAME VARCHAR2 (40)
    , ADDRESS VARCHAR2 (40)
    , PHONE VARCHAR2 (30)
    , PRIMARY KEY (CUSTID)
);
DESC NEWCUSTOMER_OCH;