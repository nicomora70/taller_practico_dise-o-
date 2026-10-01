// Ejemplar fisico que esta en la estanteria.
// Cada ejemplar pertenece a un unico libro (R10).
public class Ejemplar {
    private String codigo;
    private String estado; // DISPONIBLE, PRESTADO, etc.
    private Libro libro;

    public Ejemplar(String codigo, String estado, Libro libro) {
        this.codigo = codigo;
        this.estado = estado;
        this.libro = libro;
        // Avisamos al libro para mantener la relacion por los dos lados
        if (libro != null) {
            libro.agregarEjemplar(this);
        }
    }

    public String getCodigo() { return codigo; }
    public String getEstado() { return estado; }
    public Libro getLibro() { return libro; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar " + codigo + " [" + estado + "] de " + libro.getTitulo();
    }
}
