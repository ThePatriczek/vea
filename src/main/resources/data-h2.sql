INSERT INTO COMPANY (id, name)
VALUES (1, 'Company 1');
INSERT INTO PROJECT (id, name, company_id)
VALUES (1, 'Project 1', 1);
INSERT INTO PROJECT (id, name, company_id)
VALUES (2, 'Project 2', 1);
INSERT INTO EMPLOYEE (id, name, language, company_id, project_id, position)
VALUES (1, 'Developer Patrik', 'JavaScript', 1, 1, 'DEVELOPER');
INSERT INTO EMPLOYEE (id, name, language, company_id, project_id, position)
VALUES (2, 'Developer David', 'Java', 1, 2, 'DEVELOPER');
INSERT INTO EMPLOYEE (id, name, language, company_id, project_id, position)
VALUES (3, 'Developer Dominik', 'PHP', 1, 2, 'DEVELOPER');
INSERT INTO EMPLOYEE (id, name, company_id, project_id, position)
VALUES (4, 'Manager Vojta', 1, 1, 'MANAGER');