// El bibliotecario es otro tipo de Usuario, pero decidimos que NO sea Notificable.
// Justificacion: en este bloque las notificaciones son para avisar al que pide
// prestado (el estudiante). El bibliotecario es quien opera el sistema,
// no quien recibe esos avisos. Si despues se necesita, solo habria que
// agregarle "implements Notificable" sin tocar la herencia.
public class Bibliotecario extends Usuario {
    private String codigoEmpleado;
    private String turno;

    public Bibliotecario(String identificacion, String nombre, String correo,
                         String codigoEmpleado, String turno) {
        super(identificacion, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return "Bibliotecario " + super.toString() + " cod:" + codigoEmpleado;
    }
}
