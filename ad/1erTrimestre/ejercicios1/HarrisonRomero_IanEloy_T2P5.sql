-- Exercise 1
CREATE OR REPLACE TYPE cube AS OBJECT (
    length INTEGER,
    width INTEGER,
    height INTEGER,
    MEMBER FUNCTION surfaceArea() RETURN NUMBER,
    MEMBER FUNCTION volume() RETURN NUMBER,
    MEMBER PROCEDURE display(),
    STATIC PROCEDURE newCube(V_length INTEGER, V_width INTEGER, V_height INTEGER)
) NOT FINAL;

CREATE TABLE cubes OF cube;
DROP TABLE cubes;

-- Exercise 2
CREATE OR REPLACE TYPE BODY cube AS
BEGIN
    MEMBER FUNCTION surfaceArea() RETURN NUMBER IS
    BEGIN
        RETURN 2 * (length * width + length * height + width * height);
    END surfaceArea;

    MEMBER FUNCTION volume() RETURN NUMBER IS
    BEGIN
        RETURN length * width * height;
    END volume;

    MEMBER PROCEDURE display() IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Length: ' || length);
        DBMS_OUTPUT.PUT_LINE('Width: ' || width);
        DBMS_OUTPUT.PUT_LINE('Height: ' || height);
        DBMS_OUTPUT.PUT_LINE('Surface Area: ' || surfaceArea);
        DBMS_OUTPUT.PUT_LINE('Volume: ' || volume);
    END display;

    STATIC PROCEDURE newCube(V_length INTEGER, V_width INTEGER, V_height INTEGER) IS
        myCube cube;
    BEGIN
        myCube := cube(V_length, V_width, V_height);
        INSERT INTO cubes VALUES(myCube);
        DBMS_OUTPUT.PUT_LINE('Creating a new cube with dimensions: Length=' || V_length || ', Width=' || V_width || ', Height=' || V_height);
    END newCube;
END;
/

-- Exercise 3
BEGIN
    cube.newCube(1, 8, 1);
END;
/
