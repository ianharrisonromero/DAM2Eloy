import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstudianteBean implements EstudianteInterface {
    private String numeroExpediente;
    private String nombreEstudiante;
    private String cicloEstudio;
    private String dniEstudiante;
    private java.sql.Connection conexionBD = null;

    public EstudianteBean() {

    }

    public String getNumeroExpediente() {
        return this.numeroExpediente;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante; // No es obligatorio poner this
    }

    public String getCicloEstudio() {
        return cicloEstudio;
    }

    public String getDniEstudiante() {
        return dniEstudiante;
    }

    // Establecer conexión
    private java.sql.Connection getConexionEstudiante() {
        // load driver
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver"); // Obtener el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase del Driver");
            return null;
        }

        Connection conexion = null;
        try {
            // conexionBD=DriverManager.getConnection("jdbc:oracle:thin:@192.168.33.228:1521:orcl","blanca","blanca");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/AD", "root", "shiav1");
        } catch (SQLException e) {
            System.out.println("No se puede obtener la conexión");
            return null;
        }
        return conexion;
    }

    // los set
    public void setNombreEstudiante(String nombreEstudiante) {
        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;

        try {
            sentencia = conexionBD.createStatement();
            sentencia.execute("UPDATE ESTUDIANTE SET NOMBRE='" + nombreEstudiante +
                    "'WHERE NUMEXPDTE='" + this.numeroExpediente + "'");
            sentencia.close();
            conexionBD.close();
        } catch (SQLException e) {
            System.out.println("Error en UPDATE de nombre sobre ESTUDIANTE");
            return;
        }
        this.nombreEstudiante = nombreEstudiante;
    }

    public void setCicloEstudio(String cicloEstudio) {

        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;
        try {
            sentencia = conexionBD.createStatement(); // Se crea la sentencia

            sentencia.execute("UPDATE ESTUDIANTE SET CICLO='" + cicloEstudio +
                    "'WHERE NUMEXPDTE='" + this.numeroExpediente + "'");
            // buscar coincidencia con objeto actual
            sentencia.close();
            conexionBD.close();
        } catch (SQLException e) {
            System.out.println("Error en UPDATE de ciclo sobre ESTUDIANTE");
            return;
        }

        this.cicloEstudio = cicloEstudio;
    }

    public void setDniEstudiante(String dniEstudiante) {
        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;
        try {
            sentencia = conexionBD.createStatement();

            sentencia.execute("UPDATE ESTUDIANTE SET DNI='" + dniEstudiante +
                    "'WHERE NUMEXPDTE='" + this.numeroExpediente + "'");
            sentencia.close();
            conexionBD.close();
        } catch (SQLException e) {
            System.out.println("Error en UPDATE de DNI sobre ESTUDIANTE");
            return;
        } catch (Exception e) {
            System.out.println(e.getClass());
            return;
        }

        this.dniEstudiante = dniEstudiante;
    }

    // find

    public EstudianteInterface getEstudiantePorNumeroExpediente(String NUMEXPDTE) {
        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;
        EstudianteBean estudiante = null;

        try {
            sentencia = conexionBD.createStatement(); // Se crea la sentencia

            estudiante = new EstudianteBean();
            // Se le da valor ejecutándola
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery(
                    "SELECT * FROM ESTUDIANTE" +
                            " WHERE NUMEXPDTE='" + NUMEXPDTE + "'");

            while (resultado.next()) {
                estudiante.numeroExpediente = resultado.getString("NUMEXPDTE");
                estudiante.cicloEstudio = resultado.getString("CICLO");
                estudiante.dniEstudiante = resultado.getString("DNI");
                estudiante.nombreEstudiante = resultado.getString("NOMBRE");

            }
            resultado.close();
            sentencia.close();
            conexionBD.close();
        } catch (SQLException e) {
            System.out.println("Error en SELECT de Estudiante por NUMEXPDTE sobre ESTUDIANTE");
            return null;
        }
        return estudiante;

    }

    public java.util.Collection getEstudiantesPorCiclo(String cicloEstudio) {
        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;

        EstudianteBean estudiante = null;
        java.util.Collection coleccion = null;

        try {
            sentencia = conexionBD.createStatement();
            coleccion = new java.util.Vector();
            java.sql.ResultSet resultado;

            resultado = sentencia.executeQuery(
                    "SELECT * FROM ESTUDIANTE" +
                            " WHERE CICLO='" + cicloEstudio + "'");

            while (resultado.next()) {
                estudiante = new EstudianteBean();
                estudiante.numeroExpediente = resultado.getString("NUMEXPDTE");
                estudiante.cicloEstudio = resultado.getString("CICLO");
                estudiante.dniEstudiante = resultado.getString("DNI");
                estudiante.nombreEstudiante = resultado.getString("NOMBRE");
                coleccion.add(estudiante);
            }
            resultado.close();
            sentencia.close();
            conexionBD.close();
        } catch (SQLException e) {
            System.out.println("Error en SELECT de Estudiante por ciclo sobre ESTUDIANTE");
            return null;
        }
        return coleccion; // Devuelve una colección de estudiantes.
    }

public java.util.Collection getEstudiantesPorNombre(String nombreEstudiante) {
        conexionBD = getConexionEstudiante();
        java.sql.Statement sentencia = null;
        EstudianteBean estudiante = null;
        java.util.Collection coleccion = null;

        try {
            sentencia = conexionBD.createStatement();
            coleccion = new java.util.Vector();

            java.sql.ResultSet resultado;

            resultado = sentencia.executeQuery(
                    "SELECT * FROM ESTUDIANTE" +
                            " WHERE NOMBRE='" + nombreEstudiante + "'");

            while (resultado.next()) {
                estudiante = new EstudianteBean();
                estudiante.numeroExpediente = resultado.getString("NUMEXPDTE");
                estudiante.cicloEstudio = resultado.getString("CICLO");
                estudiante.dniEstudiante = resultado.getString("DNI");
                estudiante.nombreEstudiante = resultado.getString("NOMBRE");
                coleccion.add
