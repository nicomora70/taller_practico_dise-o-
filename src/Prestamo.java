import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Prestamo de un ejemplar a un estudiante.
// Tiene asociacion con Estudiante y Ejemplar (se conocen pero viven solos)
// y composicion con Renovacion (las renovaciones solo viven dentro del prestamo).
public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar,
                    LocalDate fechaPrestamo, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        // 1. Validar que la nueva fecha sea posterior a la vigente
        if (nuevaFecha == null) {
            throw new IllegalArgumentException("La nueva fecha no puede ser nula.");
        }
        if (!nuevaFecha.isAfter(fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "Renovacion invalida: la nueva fecha (" + nuevaFecha
                + ") debe ser posterior a la fecha prevista vigente ("
                + fechaPrevistaDevolucion + ").");
        }
        // 2. Crear la renovacion guardando el historial
        Renovacion r = new Renovacion(LocalDate.now(), fechaPrevistaDevolucion, nuevaFecha);
        // 3. Guardarla en la lista
        renovaciones.add(r);
        // 4. Actualizar la fecha prevista
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Ejemplar getEjemplar() { return ejemplar; }
    public LocalDate getFechaPrevistaDevolucion() { return fechaPrevistaDevolucion; }
    public List<Renovacion> getRenovaciones() { return renovaciones; }
    public int getCantidadRenovaciones() { return renovaciones.size(); }

    @Override
    public String toString() {
        return "Prestamo de " + ejemplar.getCodigo() + " a " + estudiante.getNombre()
             + " devuelve: " + fechaPrevistaDevolucion;
    }
}
