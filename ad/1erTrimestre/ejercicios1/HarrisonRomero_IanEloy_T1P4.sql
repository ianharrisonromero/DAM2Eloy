-- EJERCICIOS 1 & 2
CREATE OR REPLACE TYPE triangle AS OBJECT(
    base NUMBER,
    height NUMBER,
    MEMBER FUNCTION area RETURN NUMBER
) NOT FINAL;
/

CREATE OR REPLACE TYPE BODY triangle AS MEMBER FUNCTION area RETURN NUMBER IS
    BEGIN
        RETURN (base * height) / 2;
    END area;
END;
/

-- EJERCICIO 3
CREATE TABLE triangles(
    id_tri NUMBER,
    tri triangle
);

-- EJERCICIO 4
INSERT INTO triangles VALUES(1, triangle(5, 5));
INSERT INTO triangles VALUES(2, triangle(10, 10));

-- EJERCICIO 5
SELECT t.id_tri, t.tri.base, t.tri.height FROM triangles t;

-- EJERCICIO 6
BEGIN
    FOR i IN (SELECT * FROM triangles) LOOP
        DBMS_OUTPUT.PUT_LINE('The triangle with id = ' || i.id_tri);
        DBMS_OUTPUT.PUT_LINE('with base = ' || i.tri.base);
        DBMS_OUTPUT.PUT_LINE('and height = ' || i.tri.height);
        DBMS_OUTPUT.PUT_LINE('has an area of = ' || i.tri.area);
    END LOOP;
END;
/
