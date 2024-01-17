public class AppEstudiante {
    public static void main(String[] args) {
        EstudianteInterface daoObjeto = FactoriaEstudiantes.getEstudianteDao();

        EstudianteInterface estudiante1 = daoObjeto.obtenerNuevoEstudiante("1111", "Sonia Rodríguez Martín", "DAM",
                "1234");
    }
}
