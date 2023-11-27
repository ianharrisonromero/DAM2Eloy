--EJERCICIO 1
CREATE OR REPLACE TYPE phone AS OBJECT (
    Type VARCHAR2(30),
    Number NUMBER
);
/

--EJERCICIO 2
CREATE OR REPLACE TYPE directory AS TABLE OF phone;
/

--EJERCICIO 3
CREATE TABLE clients (
    Id_cli NUMBER,
    Name VARCHAR2(30),
    Lastname VARCHAR2(30),
    Address VARCHAR2(30),
    City VARCHAR2(30),
    Province VARCHAR2(30),
    Phones directory
) NESTED TABLE Phones STORE AS t_phones_table;

--EJERCICIO 4
INSERT INTO clients (Id_cli, Name, Lastname, Address, City, Province, Phones)
VALUES (
    1, 'Francisco', 'Pérez', 'Sol', 'Madrid', 'Madrid',
    directory(
        phone('Work', 91345655),
        phone('Personal', 6564433),
        phone('Other company', 654555555)
    )
);

--EJERCICIO 6
SELECT * FROM clients;

--EJERCICIO 7
SELECT segment_name, segment_type FROM user_segments;

--EJERCICIO 8
SELECT object_name, object_type FROM user_objects;

--EJERCICIO 9
SELECT * FROM user_nested_tables;

--EJERCICIO 10
SELECT * FROM TABLE(SELECT c.Phones FROM clients c WHERE c.Id_cli = 1);

--EJERCICIO 11
UPDATE clients c
SET c.Phones = directory(
    phone('Landline', 934444444),
    phone('Personal Mobile', 65555555),
    phone('Business Mobile', 644444444)
)
WHERE c.Id_cli = 1;

--EJERCICIO 12
SELECT Id_cli, COLUMN_VALUE.Type, COLUMN_VALUE.Number
FROM clients, TABLE(clients.Phones) COLUMN_VALUE;

--EJERCICIO 13
SELECT c.Name, c.Id_cli, t.Type, t.Number
FROM clients c, TABLE(c.Phones) t;
