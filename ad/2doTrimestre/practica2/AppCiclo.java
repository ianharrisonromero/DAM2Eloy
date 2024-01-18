package practica2;

public class AppCiclo {
    public static void main(String[] args) {

        // Obtener una instancia de la interfaz de DAO de Ciclo
        CicloDaoInterface daoCiclo = CicloDaoFactory.getCicloDao();

        // Crear un nuevo objeto de Ciclo usando la interfaz de DAO
        Ciclo ciclo1 = daoCiclo.getNuevoCiclo("ARI", "Administración de Recursos Integrales", "SUPERIOR");
    }
}
