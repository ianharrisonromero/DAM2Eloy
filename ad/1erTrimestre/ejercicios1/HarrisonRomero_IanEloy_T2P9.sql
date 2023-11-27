--EJERCICIO 1
CREATE OR REPLACE TYPE child_table AS TABLE OF VARCHAR2(30);
/

--EJERCICIO 2
CREATE TABLE employee (
    Idemp NUMBER,
    Name VARCHAR2(30),
    Lastname VARCHAR2(30),
    Addresses child_table
) NESTED TABLE Addresses STORE AS t_addresses_table;
/

--EJERCICIO 3
SELECT object_name, object_type FROM user_objects;

--EJERCICIO 4
SELECT segment_name, segment_type FROM user_segments;

--EJERCICIO 5
INSERT INTO employee (Idemp, Name, Lastname, Addresses)
VALUES (1, 'Fernando', 'Moreno', child_table('Elena', 'Pablo'));

INSERT INTO employee (Idemp, Name, Lastname, Addresses)
VALUES (2, 'David', 'Sanchez', child_table('Carmen', 'Candela'));

--EJERCICIO 6
SELECT * FROM employee;

--EJERCICIO 7
SELECT * FROM TABLE(SELECT e.Addresses FROM employee e WHERE e.Idemp = 1);

--EJERCICIO 8
UPDATE employee e
SET e.Addresses = child_table('Carmen', 'Candela', 'Cayetana')
WHERE e.Idemp = 1;

--EJERCICIO 9
SELECT Idemp, Addresses FROM employee WHERE Idemp IN (1, 2);
