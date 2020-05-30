DROP TABLE ORD_LNK_GOOD;
DROP TABLE ORD;
DROP TABLE GOOD;

CREATE TABLE ORD (
	ID INT NOT NULL auto_increment,
    ORDER_CODE INT NOT NULL,
    SEND_DATE date NOT NULL,
    PRIMARY KEY ( ID )
);

INSERT INTO ORD VALUES (1, 1551, '2020-5-8');
INSERT INTO ORD VALUES (2, 1552, '2020-5-8');
INSERT INTO ORD VALUES (3, 1553, '2020-5-9');
INSERT INTO ORD VALUES (4, 1554, '2020-5-9');

CREATE TABLE ORD_LNK_GOOD (
	ID INT NOT NULL auto_increment,
    ORDER_ID INT NOT NULL,
    GOOD_ID INT NOT NULL,
    GOOD_AMOUNT INT NOT NULL,
    PRIMARY KEY ( ID )
);

INSERT INTO ORD_LNK_GOOD VALUES (1, 1, 4, 10);
INSERT INTO ORD_LNK_GOOD VALUES (2, 2, 1, 3);
INSERT INTO ORD_LNK_GOOD VALUES (3, 2, 3, 5);
INSERT INTO ORD_LNK_GOOD VALUES (4, 2, 4, 11);
INSERT INTO ORD_LNK_GOOD VALUES (5, 3, 2, 2);
INSERT INTO ORD_LNK_GOOD VALUES (6, 4, 2, 1);
INSERT INTO ORD_LNK_GOOD VALUES (7, 4, 5, 1);

CREATE TABLE GOOD (
	ID INT NOT NULL auto_increment,
    CODE INT NOT NULL,
    NAME VARCHAR(20),
    DESCRIPTION VARCHAR(100),
    PRICE INT NOT NULL,
    PRIMARY KEY ( ID )
);

INSERT INTO GOOD VALUES (1, 52, 'Alenka', 'Sweets', 112);
INSERT INTO GOOD VALUES (2, 84, 'Flint', 'Snacks', 134);
INSERT INTO GOOD VALUES (3, 19, 'Kashtan', 'Ice cream', 192);
INSERT INTO GOOD VALUES (4, 33, 'Vit\'ba', 'Waffles', 308);
INSERT INTO GOOD VALUES (5, 47, 'CocaCola', 'Soda', 166);

ALTER TABLE ORD_LNK_GOOD ADD FOREIGN KEY (ORDER_ID) REFERENCES ORD(ID);

ALTER TABLE ORD_LNK_GOOD ADD FOREIGN KEY (GOOD_ID) REFERENCES GOOD(ID);