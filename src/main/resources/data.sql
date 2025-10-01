INSERT INTO USER_DETAILS (ID, NAME, BIRTH_DATE) 
VALUES (100,'Adam', '1990-01-01'),
       (101,'Eve', '1992-02-02'),
       (102, 'John', '1985-03-03')   ;


INSERT INTO POST (ID, DESCRIPTION, USER_ID)
VALUES (1, 'Manager', 100),
       (2, 'Solution Architect', 100),
       (3, 'Team Lead', 101),
       (4, 'Senior SOftware Engineer', 102);