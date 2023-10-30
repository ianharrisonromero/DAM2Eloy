/*1*/

DROP TABLE temp;

CREATE TABLE temp (
    employee_id NUMBER(4, 0),
    salary      NUMBER(7, 2),
    last_name   VARCHAR2(50),
    message     VARCHAR2(50)
);

DECLARE
    v_employee_id employee.employee_id%TYPE;
    v_salary      employee.salary%TYPE;
    v_last_name   employee.last_name%TYPE;
BEGIN
    FOR emp_record IN (
        SELECT
            employee_id,
            salary,
            last_name
        FROM
            employee
        WHERE
            salary >= 1000
    ) LOOP
        v_employee_id := emp_record.employee_id;
        v_salary := emp_record.salary;
        v_last_name := emp_record.last_name;
        INSERT INTO temp (
            employee_id,
            salary,
            last_name,
            message
        ) VALUES (
            v_employee_id,
            v_salary,
            v_last_name,
            'Cambios de salario realizados.'
        );

    END LOOP;
END;
/

/*2*/
DROP TABLE temp;

CREATE TABLE temp (
    id_cliente NUMBER,
    nombre     VARCHAR2(50),
    pedidos    NUMBER,
    total      NUMBER
);

DECLARE
    codigo  customer.customer_id%TYPE := '&codigo';
    nombre  customer.name%TYPE;
    pedidos NUMBER;
    total   sales_order.total%TYPE;
    existe  NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO existe
    FROM
        customer
    WHERE
        customer_id = codigo;

    IF existe != 1 THEN
        dbms_output.put_line('no hay cliente con ese ID en la base de datos.');
    ELSE
        SELECT
            customer_id,
            name
        INTO
            codigo,
            nombre
        FROM
            customer
        WHERE
            customer_id = codigo;

        SELECT
            COUNT(*)
        INTO pedidos
        FROM
            sales_order
        WHERE
            customer_id = codigo;

        SELECT
            SUM(total)
        INTO total
        FROM
            sales_order
        WHERE
            customer_id = codigo;

        INSERT INTO temp VALUES (
            codigo,
            nombre,
            pedidos,
            total
        );

    END IF;

END;
/

/*3*/
DROP TABLE temp;

CREATE TABLE temp (
    codigo_empleado NUMBER,
    nombre_empleado VARCHAR2(50),
    job             NUMBER
);

DECLARE
    TYPE t_reg_emple IS RECORD (
        codigo_empleado NUMBER,
        nombre_empleado VARCHAR2(50),
        job             NUMBER
    );
    v_empleado        t_reg_emple;
    v_codigo_empleado NUMBER := 7782;
BEGIN
    SELECT
        e.employee_id,
        e.last_name,
        e.job_id
    INTO v_empleado
    FROM
        employee e
    WHERE
        e.employee_id = v_codigo_empleado;

    INSERT INTO temp (
        codigo_empleado,
        nombre_empleado,
        job
    ) VALUES (
        v_empleado.codigo_empleado,
        v_empleado.nombre_empleado,
        v_empleado.job
    );

END;
/

/*4*/
DROP TABLE temp;

CREATE TABLE temp (
    campo1 NUMBER,
    campo2 DATE,
    campo3 DATE,
    campo4 NUMBER,
    campo5 NUMBER
);

DECLARE
    contador NUMBER := 0;
BEGIN
    FOR i IN 1..50 LOOP
        INSERT INTO temp (
            campo1,
            campo2,
            campo3,
            campo4,
            campo5
        ) VALUES (
            i,
            sysdate,
            sysdate,
            i * 2,
            i * 3
        );

        contador := contador + 1;
    END LOOP;
END;
/

DROP TABLE students;

CREATE TABLE students (
    nombre   VARCHAR2(50),
    centro   VARCHAR2(50),
    fin_beca DATE
);

INSERT INTO students VALUES (
    'JUANJO',
    'IES JUAN DE LA CIERVA',
    sysdate + 90
);

INSERT INTO students VALUES (
    'ROSSO',
    'IES SAN ISIDRO',
    sysdate + 180
);

/*5*/
CREATE OR REPLACE TYPE cliente_type AS OBJECT (
    nombre VARCHAR2(50)
);

CREATE OR REPLACE TYPE cliente_table AS
    TABLE OF cliente_type;

CREATE TABLE temp_cliente (
    indice         NUMBER,
    nombre_cliente VARCHAR2(50)
);

DECLARE
    clientes cliente_table := cliente_table(cliente_type('Cliente 1'), cliente_type('Cliente 2'), cliente_type('Cliente 3'), cliente_type(
    'Cliente 4'), cliente_type('Cliente 5'));
BEGIN
    FOR i IN 1..clientes.count LOOP
        INSERT INTO temp_cliente (
            indice,
            nombre_cliente
        ) VALUES (
            i,
            clientes(i).nombre
        );

    END LOOP;

    SELECT
        *
    FROM
        temp_cliente;

END;
/

/*6*/
DROP TABLE temp;

CREATE TABLE temp (
    customer_id    NUMBER,
    customer_name  VARCHAR2(50),
    salesperson_id NUMBER
);

DECLARE
    v_customer_id    customer.customer_id%TYPE;
    v_customer_name  customer.name%TYPE;
    v_salesperson_id customer.salesperson_id%TYPE;
BEGIN
    FOR c IN (
        SELECT
            customer_id,
            name,
            salesperson_id
        FROM
            customer
    ) LOOP
        v_customer_id := c.customer_id;
        v_customer_name := c.name;
        v_salesperson_id := c.salesperson_id;
        INSERT INTO temp (
            customer_id,
            customer_name,
            salesperson_id
        ) VALUES (
            v_customer_id,
            v_customer_name,
            v_salesperson_id
        );

    END LOOP;
END;
/

DECLARE
    v_customer_id    customer.customer_id%TYPE;
    v_customer_name  customer.name%TYPE;
    v_salesperson_id customer.salesperson_id%TYPE;
    v_rowcount       NUMBER := 0;
BEGIN
    WHILE v_rowcount < 3 LOOP
        SELECT
            customer_id,
            name,
            salesperson_id
        INTO
            v_customer_id,
            v_customer_name,
            v_salesperson_id
        FROM
            customer
        WHERE
            ROWNUM = v_rowcount + 1;

        INSERT INTO temp (
            customer_id,
            customer_name,
            salesperson_id
        ) VALUES (
            v_customer_id,
            v_customer_name,
            v_salesperson_id
        );

        v_rowcount := v_rowcount + 1;
    END LOOP;
END;
/

DECLARE
    v_customer_id    customer.customer_id%TYPE;
    v_customer_name  customer.name%TYPE;
    v_salesperson_id customer.salesperson_id%TYPE;
BEGIN
    LOOP
        SELECT
            customer_id,
            name,
            salesperson_id
        INTO
            v_customer_id,
            v_customer_name,
            v_salesperson_id
        FROM
            customer
        WHERE
            ROWNUM = 1;

        INSERT INTO temp (
            customer_id,
            customer_name,
            salesperson_id
        ) VALUES (
            v_customer_id,
            v_customer_name,
            v_salesperson_id
        );

        EXIT WHEN no_data_found;
    END LOOP;
END;
/

/*8*/
CREATE OR REPLACE PROCEDURE insert_order (
    p_order_id    NUMBER,
    p_order_date  DATE,
    p_customer_id NUMBER,
    p_ship_date   DATE,
    p_total       NUMBER
) IS
BEGIN
    INSERT INTO sales_order (
        order_id,
        order_date,
        customer_id,
        ship_date,
        total
    ) VALUES (
        p_order_id,
        p_order_date,
        p_customer_id,
        p_ship_date,
        p_total
    );

    dbms_output.put_line('Pedido realizado correctamente    .');
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Hubo un error con el pedido: ' || sqlerrm);
END;
/

/*10*/
DROP TABLE temp;

CREATE TABLE temp (
    employee_id NUMBER,
    old_job_id  NUMBER,
    new_job_id  NUMBER
);

CREATE PROCEDURE cambiaroficio (
    in_employee_id NUMBER,
    in_new_job_id  NUMBER
) IS
    old_job_id NUMBER;
BEGIN
    SELECT
        job_id
    INTO old_job_id
    FROM
        employee
    WHERE
        employee_id = in_employee_id;

    INSERT INTO temp (
        employee_id,
        old_job_id,
        new_job_id
    ) VALUES (
        in_employee_id,
        old_job_id,
        in_new_job_id
    );

    UPDATE employee
    SET
        job_id = in_new_job_id
    WHERE
        employee_id = in_employee_id;

END;
/

BEGIN
    cambiaroficio(7369, 670);
END;
/

/*11*/
CREATE OR REPLACE FUNCTION calcsalarioanual (
    salariomensual NUMBER,
    comision       NUMBER
) RETURN NUMBER IS
    salarioanual NUMBER;
BEGIN
    salarioanual := ( nvl(salariomensual, 0) * 12 ) + ( nvl(comision, 0) * 12 );

    RETURN salarioanual;
END;
/

/*13*/
CREATE TABLE funciones (
    funcion VARCHAR2(50)
);

INSERT INTO funciones VALUES ( 'Enfermeras' );

INSERT INTO funciones VALUES ( 'M�dicos' );

INSERT INTO funciones VALUES ( 'Conserjes' );

INSERT INTO funciones VALUES ( 'Limpiadores' );

SELECT
    *
FROM
    funciones;

CREATE OR REPLACE TRIGGER funciones_trigger AFTER
    UPDATE ON funciones
BEGIN
    dbms_output.put_line('Se realizó el cambio en "Funciones"');
END;
/

/*14*/
CREATE TABLE cambios_detalles (
    usuario            VARCHAR2(50),
    fecha_modificacion DATE,
    codigo_pedido      NUMBER,
    mensaje            VARCHAR2(100)
);

CREATE OR REPLACE TRIGGER detalles_trigger AFTER
    INSERT OR UPDATE OR DELETE ON detalles
    FOR EACH ROW
DECLARE
    v_mensaje VARCHAR2(100);
BEGIN
    IF inserting THEN
        v_mensaje := 'Detalle guardado';
    ELSIF updating THEN
        v_mensaje := 'Detalle cambiado';
    ELSIF deleting THEN
        v_mensaje := 'Detalle eliminado';
    END IF;

    INSERT INTO cambios_detalles (
        usuario,
        fecha_modificacion,
        codigo_pedido,
        mensaje
    ) VALUES (
        user,
        sysdate,
        :old.codigo_pedido,
        v_mensaje
    );

END;
/

/*15*/
DROP TABLE temp;

CREATE TABLE temp (
    emp_id   NUMBER,
    emp_name VARCHAR2(50),
    descrip  VARCHAR2(50)
);

CREATE OR REPLACE TRIGGER subida_salario AFTER
    UPDATE ON employee
    FOR EACH ROW
BEGIN
    IF :old.salary < :new.salary THEN
        INSERT INTO temp VALUES (
            :new.employee_id,
            :new.last_name,
            'Subida de salario'
        );

    END IF;
END;
/

/*16*/
CREATE OR REPLACE TRIGGER borrado_empleado AFTER
    DELETE ON employee
    FOR EACH ROW
BEGIN
    INSERT INTO temp VALUES (
        :old.employee_id,
        :old.last_name,
        :old.department_id
    );

END;
/

/*18*/
DROP TABLE temp;

CREATE TABLE temp (
    cod NUMBER,
    msg VARCHAR2(50)
);

DECLARE
    cod_cliente customer.customer_id%TYPE;
    existe      NUMBER;
BEGIN
    cod_cliente := '&cod_cliente';
    SELECT
        COUNT(*)
    INTO existe
    FROM
        customer
    WHERE
        customer_id = to_number(cod_cliente);

    IF existe = 1 THEN
        INSERT INTO temp VALUES (
            to_number(cod_cliente),
            'El cliente existe :)'
        );

    ELSE
        INSERT INTO temp VALUES (
            to_number(cod_cliente),
            'El cliente no existe :('
        );

    END IF;

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Se ha producido un error: ' || sqlerrm);
END;
/

/*20*/
DROP TABLE temp;

CREATE TABLE temp (
    id_cliente NUMBER,
    nombre     VARCHAR2(50),
    pedidos    NUMBER,
    total      NUMBER
);

DECLARE
    codigo         customer.customer_id%TYPE := '&codigo';
    nombre         customer.name%TYPE;
    pedidos        NUMBER;
    total          sales_order.total%TYPE;
    existe_cliente NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO existe_cliente
    FROM
        customer
    WHERE
        customer_id = codigo;

    SELECT
        COUNT(*)
    INTO existe_pedido
    FROM
        sales_order
    WHERE
        customer_id = codigo;

    IF existe_cliente != 1 THEN
        raise_application_error(-200001, 'No existe el cliente');
    ELSIF existe_pedido < 1 THEN
        raise_application_error(-200002, 'No existen pedidos del cliente');
    ELSE
        SELECT
            customer_id,
            name
        INTO
            codigo,
            nombre
        FROM
            customer
        WHERE
            customer_id = codigo;

        SELECT
            COUNT(*)
        INTO pedidos
        FROM
            sales_order
        WHERE
            customer_id = codigo;

        SELECT
            SUM(total)
        INTO total
        FROM
            sales_order
        WHERE
            customer_id = codigo;

        INSERT INTO temp VALUES (
            codigo,
            nombre,
            pedidos,
            total
        );

    END IF;

END;
/

/*21*/
CREATE OR REPLACE TRIGGER borrado_empleado AFTER
    DELETE ON employee
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Empleado '
                         || :old.last_name
                         || ' con numero '
                         || :old.employee_id
                         || ' eliminado');
END;
/

/*22*/
CREATE OR REPLACE PROCEDURE modificar_salario (
    p_employee_id IN employee.employee_id%TYPE
) IS
    v_employee_count  NUMBER;
    v_job_id          employee.job_id%TYPE;
    v_function        job.function%TYPE;
    v_salary_increase NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO v_employee_count
    FROM
        employee
    WHERE
        manager_id = p_employee_id;

    SELECT
        function
    INTO v_function
    FROM
        job
    WHERE
        job_id = (
            SELECT
                job_id
            FROM
                employee
            WHERE
                employee_id = p_employee_id
        );

    IF v_function = 'PRESIDENT' THEN
        v_salary_increase := 30;
    ELSIF v_employee_count = 0 THEN
        v_salary_increase := 50;
    ELSIF v_employee_count = 1 THEN
        v_salary_increase := 80;
    ELSIF v_employee_count = 2 THEN
        v_salary_increase := 100;
    ELSE
        v_salary_increase := 110;
    END IF;

    UPDATE employee
    SET
        salary = salary + v_salary_increase
    WHERE
        employee_id = p_employee_id;

END;
/

/*23*/
BEGIN
    dbms_output.put_line('Hola mundo');
END;
/

DECLARE
    texto          VARCHAR2(20) := 'Hola mundo';
    texto_al_reves VARCHAR2(20);
BEGIN
    FOR i IN REVERSE 1..length(texto) LOOP
        texto_al_reves := texto_al_reves
                          || substr(texto, i, 1);
    END LOOP;

    dbms_output.put_line(texto_al_reves);
END;
/

/*24*/
DECLARE
    emp_name     VARCHAR2(50);
    manager_name VARCHAR2(50);
    CURSOR emp_cursor IS
    SELECT
        e.last_name AS emp,
        m.last_name AS mng
    FROM
             employee e
        JOIN employee m ON m.employee_id = e.manager_id;

BEGIN
    OPEN emp_cursor;
    FETCH emp_cursor INTO
        emp_name,
        manager_name;
    WHILE emp_cursor%found LOOP
        dbms_output.put_line(emp_name
                             || ' | '
                             || manager_name);
        FETCH emp_cursor INTO
            emp_name,
            manager_name;
    END LOOP;

    CLOSE emp_cursor;
END;
/

/*25*/
DECLARE
    dpt_id  NUMBER;
    counter NUMBER := 1;
BEGIN
    dpt_id := &department_id;
    FOR i IN (
        SELECT
            *
        FROM
            employee
        WHERE
            department_id = dpt_id
    ) LOOP
        dbms_output.put_line(counter
                             || ': '
                             || i.last_name);
        counter := counter + 1;
    END LOOP;

END;
/

/*27*/
CREATE OR REPLACE PROCEDURE subir_sueldo (
    oficio NUMBER
) AS
    num_emp NUMBER;
    total   NUMBER;
    media   NUMBER;
BEGIN
    SELECT
        COUNT(*)
    INTO num_emp
    FROM
        employee
    WHERE
        job_id = oficio;

    SELECT
        SUM(salary)
    INTO total
    FROM
        employee
    WHERE
        job_id = oficio;

    media := total / num_emp;
    FOR i IN (
        SELECT
            *
        FROM
            employee
        WHERE
            job_id = oficio
    ) LOOP
        IF i.salary < media THEN
            UPDATE employee
            SET
                salary = ( i.salary + ( media - i.salary ) * 0.5 )
            WHERE
                employee_id = i.employee_id;

        END IF;
    END LOOP;

EXCEPTION
    WHEN OTHERS THEN
        bms_output.put_line('Se ha producido un error');
END;
/

/*28*/
CREATE OR REPLACE PROCEDURE incrementar_salario (
    p_department_id NUMBER,
    p_incremento    NUMBER
) AS
    filas_afectadas NUMBER := 0;
BEGIN
    FOR rec IN (
        SELECT
            employee_id,
            salary
        FROM
            employee
        WHERE
            department_id = p_department_id
    ) LOOP
        rec.salary := rec.salary + p_incremento;
        UPDATE employee
        SET
            salary = rec.salary
        WHERE
            employee_id = rec.employee_id;

        filas_afectadas := filas_afectadas + 1;
    END LOOP;

    dbms_output.put_line('Numero de filas afectadas: ' || filas_afectadas);
END;
/

/*29*/
DECLARE
    numero   NUMBER;
    cantidad NUMBER;
BEGIN
    numero := &numero_empleado;
    cantidad := &subida_sueldo;
    IF cantidad IS NULL THEN
        raise_application_error(-20001, 'El salario no puede ser nulo');
    END IF;
    UPDATE employee
    SET
        salary = salary + cantidad
    WHERE
        employee_id = numero;

EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('Empleado no encontrado');
    WHEN OTHERS THEN
        dbms_output.put_line('Error: ' || sqlerrm);
END;
/