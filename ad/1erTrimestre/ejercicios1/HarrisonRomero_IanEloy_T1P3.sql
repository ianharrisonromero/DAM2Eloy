-- Ejercicio a
CREATE OR REPLACE TYPE cube AS OBJECT (
    length INTEGER,
    width INTEGER,
    height INTEGER,
    
    MEMBER FUNCTION surface RETURN INTEGER,
    MEMBER FUNCTION volume RETURN INTEGER,
    MEMBER PROCEDURE display
);
/

CREATE OR REPLACE TYPE BODY cube AS
    MEMBER FUNCTION surface RETURN INTEGER IS
    BEGIN
        RETURN 2 * (length * width + length * height + width * height);
    END surface;

    MEMBER FUNCTION volume RETURN INTEGER IS
    BEGIN
        RETURN length * width * height;
    END volume;

    MEMBER PROCEDURE display IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Length: ' || length);
        DBMS_OUTPUT.PUT_LINE('Width: ' || width);
        DBMS_OUTPUT.PUT_LINE('Height: ' || height);
        DBMS_OUTPUT.PUT_LINE('Surface: ' || surface());
        DBMS_OUTPUT.PUT_LINE('Volume: ' || volume());
    END display;
END;
/

-- Ejercicio b
CREATE TABLE cubes OF cube;

-- Ejercicio c
INSERT INTO cubes VALUES(cube(10, 10, 10));
INSERT INTO cubes VALUES(cube(3, 4, 5));

-- Ejercicio d
SELECT * FROM cubes;

-- Ejercicio e
SELECT c.volume AS Volume, c.surface AS Surface
FROM cubes c
WHERE c.length = 10;

-- Ejercicio f
DECLARE
    c cube;
BEGIN
    SELECT REF(c) INTO c
    FROM cubes
    WHERE c.length = 10;
    
    c.display();
END;
/
