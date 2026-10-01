import java.util.ArrayList;
import java.util.List;

// Libro logico del catalogo (ej: "Cien anios de soledad").
// Un libro puede tener varios ejemplares fisicos (R10).
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Agregacion: el ejemplar se crea afuera y se agrega al libro.
    // Si se elimina el libro del catalogo, en la vida real el ejemplar
    // fisico sigue existiendo, por eso no es composicion.
    public void agregarEjemplar(Ejemplar e) {
        ejemplares.add(e);
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + isbn + ")";
    }
}
