// El estudiante SI recibe notificaciones (por eso implementa Notificable).
// Ejemplo: "Su prestamo fue renovado" o "Su reserva ya esta disponible".
public class Estudiante extends Usuario implements Notificable {
    private String codigoEstudiantil;
    private String programaAcademico;

    public Estudiante(String identificacion, String nombre, String correo,
                      String codigoEstudiantil, String programaAcademico) {
        super(identificacion, nombre, correo);
        this.codigoEstudiantil = codigoEstudiantil;
        this.programaAcademico = programaAcademico;
    }

    public String getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    @Override
    public void notificar(String mensaje) {
        // Por ahora solo lo mostramos en consola para probar.
        // Despues se podria enviar por correo sin cambiar el contrato.
        System.out.println("[Notificacion para " + getNombre() + "]: " + mensaje);
    }

    @Override
    public String toString() {
        return "Estudiante " + super.toString() + " cod:" + codigoEstudiantil;
    }
}
