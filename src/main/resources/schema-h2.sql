CREATE TABLE COMPANY
(
    id   NUMBER(10)   NOT NULL,
    name VARCHAR2(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PROJECT
(
    id         NUMBER(10)   NOT NULL,
    name       VARCHAR2(50) NOT NULL,
    company_id NUMBER(10)   NOT NULL,
    PRIMARY KEY (id),
    foreign key (company_id) references COMPANY (id) on delete cascade
);

CREATE TABLE EMPLOYEE
(
    id         NUMBER(10)   NOT NULL,
    name       VARCHAR2(50) NOT NULL,
    company_id NUMBER(10)   NOT NULL,
    position   VARCHAR2(50) NOT NULL,
    language   VARCHAR2(50),
    project_id NUMBER(10),
    PRIMARY KEY (id),
    foreign key (company_id) references COMPANY (id) on delete cascade,
    foreign key (project_id) references PROJECT (id) on delete cascade
);

