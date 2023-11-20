--ejercicio 1
CREATE OR REPLACE TYPE veterinario AS OBJECT (
    id        NUMBER,
    nombre    VARCHAR2(50),
    direccion VARCHAR2(100)
);
/

CREATE OR REPLACE TYPE mascota AS OBJECT (
    id     NUMBER,
    raza   VARCHAR2(50),
    nombre VARCHAR2(50),
    vet    REF veterinario
);
/
-- Crear la tabla para veterinarios
CREATE TABLE tabla_veterinarios OF veterinario (
    PRIMARY KEY ( id )
);
/

-- Crear la tabla para mascotas
CREATE TABLE tabla_mascotas OF mascota (
    PRIMARY KEY ( id )
);
/

--ejercicio 2
    INSERT INTO tabla_veterinarios VALUES ( veterinario(1, 'Jesus Perez', 'C/El mareo,29') );
/

--ejercicio 3
INSERT INTO tabla_mascotas VALUES (mascota(1, 'perro', 'Sproket', (SELECT REF(v) FROM tabla_veterinarios v WHERE v.id = 1));
/

--ejercicio 4
SELECT
    ROWID,
    m.ref(),
    m.*
FROM
    tabla_mascotas m;
/

--ejercicio 5
SELECT
    ROWID,
    m.id,
    m.raza,
    m.nombre,
    deref(m.vet).nombre AS nombre_veterinario
FROM
    tabla_mascotas m;
/

--ejercicio 6
SELECT
    m.nombre            AS nombre_mascota,
    m.raza,
    deref(m.vet).nombre AS nombre_veterinario
FROM
    tabla_mascotas m;
/

--ejercicio 7
DROP TABLE tabla_mascotas;

DROP TABLE tabla_veterinarios;

DROP TYPE mascota;

DROP TYPE veterinario;
/