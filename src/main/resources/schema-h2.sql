CREATE TABLE COMPANY
(
    id NUMBER(10) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE DEVELOPER
(
    id NUMBER(10) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    language VARCHAR2(50) NOT NULL,
    company_id NUMBER(10) NOT NULL,
    PRIMARY KEY(id),
    foreign key (company_id) references COMPANY(id) on delete cascade
);