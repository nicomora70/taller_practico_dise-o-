import java.time.LocalDate;

// Reserva sencilla, solo para completar la vista de componentes.
// Un estudiante reserva un libro cuando no hay ejemplares disponibles.
public class Reserva {
    private Estudiante estudiante;
    private Libro libro;
    private LocalDate fechaReserva;

    public Reserva(Estudiante estudiante, Libro libro, LocalDate fechaReserva) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Libro getLibro() { return libro; }
    public LocalDate getFechaReserva() { return fechaReserva; }

    @Override
    public String toString() {
        return "Reserva de " + libro.getTitulo() + " por " + estudiante.getNombre();
    }
}
