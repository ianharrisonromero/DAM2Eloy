public interface EstudianteInterface {

    // GET
    public String obtenerNumeroExpediente();

    public String obtenerNombre();

    public String obtenerCicloEstudio();

    public String obtenerDni();

    // SET
    public void establecerNombre(String nombre);

    public void establecerCicloEstudio(String cicloEstudio);

    public void establecerDni(String dni);

    // FIND
    public EstudianteInterface obtenerEstudiantePorNumeroExpediente(String numeroExpediente);

    public java.util.Collection obtenerEstudiantesPorCiclo(String cicloEstudio);

    public java.util.Collection obtenerEstudiantesPorNombre(String nombreEstudiante);

    // constructor
    public EstudianteInterface obtenerNuevoEstudiante(String numeroExpediente, String nombreEstudiante,
            String cicloEstudio, String dniEstudiante);
}
