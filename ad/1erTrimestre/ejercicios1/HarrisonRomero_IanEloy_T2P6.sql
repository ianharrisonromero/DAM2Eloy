--Ejercicio 1
CREATE OR REPLACE TYPE empleado AS OBJECT (
    rut VARCHAR2(10),
    nombre VARCHAR2(10),
    cargo VARCHAR2(9),
    fechaIng DATE,
    sueldo NUMBER(9),
    comision NUMBER(9),
    anticipo NUMBER(9),
    
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER,
    
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER)
);
/

--Ejercicio 2
CREATE OR REPLACE TYPE BODY empleado AS

    MEMBER FUNCTION sueldo_liquido RETURN NUMBER IS
    BEGIN
        RETURN sueldo + comision - anticipo;
    END sueldo_liquido;

    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER) IS
    BEGIN
        sueldo := sueldo + aumento;
    END aumento_sueldo;
END;
/

--Ejercicio 3
ALTER TYPE empleado ADD MEMBER PROCEDURE setAnticipo(anticipo NUMBER);
/

--Ejercicio 4
CREATE OR REPLACE TYPE BODY empleado AS
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER IS
    BEGIN
        RETURN sueldo + comision - anticipo;
    END sueldo_liquido;

    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER) IS
    BEGIN
        sueldo := sueldo + aumento;
    END aumento_sueldo;

    MEMBER PROCEDURE setAnticipo(anticipo NUMBER) IS
    BEGIN
        self.anticipo := anticipo;
    END setAnticipo;
END;
/

--Ejercicio 5
CREATE TABLE empleados OF empleado;

--Ejercicio 6
INSERT INTO empleados VALUES('1', 'Pepe', 'Director', sysdate, 2000, 500, 0);
INSERT INTO empleados VALUES('2', 'Juan', 'Vendedor', sysdate, 1000, 300, 0);
INSERT INTO empleados VALUES('3', 'Elena', 'Vendedor', sysdate, 1000, 400, 0);

--Ejercicio 7
DECLARE
    dire empleado;
BEGIN
    SELECT VALUE(e) INTO dire FROM empleados e WHERE e.rut = '1';
    DBMS_OUTPUT.PUT_LINE(dire.nombre || '   ' || dire.cargo || '   '  || 'sueldo: ' ||dire.sueldo || '   ' || 'sueldo liquido: ' || dire.sueldo_liquido());
    UPDATE empleados e SET sueldo = sueldo + 400 WHERE e.rut = '1';
    SELECT VALUE(e) INTO dire FROM empleados e WHERE e.rut = '1';
    DBMS_OUTPUT.PUT_LINE(dire.nombre || '   ' || dire.cargo || '   '  || 'sueldo: ' ||dire.sueldo || '   ' || 'sueldo liquido: ' || dire.sueldo_liquido());
END;
/

--Ejercicio 8
SELECT sueldo, e.sueldo_liquido() FROM empleados e;
