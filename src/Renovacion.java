import java.time.LocalDate;

// Guarda una renovacion del prestamo.
// No tiene sentido sola, solo existe como parte del historial del prestamo,
// por eso en UML la ponemos como composicion.
public class Renovacion {
    private LocalDate fechaRenovacion; // cuando se hizo
    private LocalDate fechaAnterior;   // fecha que habia antes
    private LocalDate nuevaFecha;       // nueva fecha de devolucion

    public Renovacion(LocalDate fechaRenovacion, LocalDate fechaAnterior, LocalDate nuevaFecha) {
        this.fechaRenovacion = fechaRenovacion;
        this.fechaAnterior = fechaAnterior;
        this.nuevaFecha = nuevaFecha;
    }

    public LocalDate getFechaRenovacion() { return fechaRenovacion; }
    public LocalDate getFechaAnterior() { return fechaAnterior; }
    public LocalDate getNuevaFecha() { return nuevaFecha; }

    @Override
    public String toString() {
        return "Renovacion: " + fechaAnterior + " -> " + nuevaFecha + " (hecha el " + fechaRenovacion + ")";
    }
}
