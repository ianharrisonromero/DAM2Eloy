import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practica1GestorEstudiantes {

    public static void main(String[] args) {
        String urlBaseDatos = "jdbc:mysql://localhost:3306/estudiante";
        String nombreUsuario = "root";
        String contraseña = "";

        try {
            Connection conexion = DriverManager.getConnection(urlBaseDatos, nombreUsuario, contraseña);

            // Nuevo estudiante
            agregarNuevoEstudiante(conexion, "105", "ENRIQUETA", "ASI", "3434343");

            // MOD estudiant
            modificarEstudiante(conexion, "105", "BLANCA", "55555555", "DAM");

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void agregarNuevoEstudiante(Connection conexion, String numExpediente, String nombre, String ciclo,
            String dni) throws SQLException {
        String sqlInsercion = "INSERT INTO estudiante VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sqlInsercion)) {
            pstmt.setString(1, numExpediente);
            pstmt.setString(2, nombre);
            pstmt.setString(3, dni);
            pstmt.setString(4, ciclo);

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Estudiante añadido con éxito.");
            }
        }
    }

    public static void modificarEstudiante(Connection conexion, String numExpediente, String nuevoNombre,
            String nuevoDni, String nuevoCiclo) throws SQLException {
        String sqlModificacion = "UPDATE estudiante SET nombre = ?, dni = ?, ciclo = ? WHERE numexpediente = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sqlModificacion)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoDni);
            pstmt.setString(3, nuevoCiclo);
            pstmt.setString(4, numExpediente);

            int filasModificadas = pstmt.executeUpdate();
            if (filasModificadas > 0) {
                System.out.println("Datos del estudiante modificados con éxito.");
            }
        }
    }
}
