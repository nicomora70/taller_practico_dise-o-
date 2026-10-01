import java.util.Objects;

// Superclase que representa a cualquier usuario de la biblioteca.
// La hicimos abstracta porque no tiene sentido crear un "Usuario" solo,
// siempre es un Estudiante o un Bibliotecario.
public abstract class Usuario {
    private String identificacion;
    private String nombre;
    private String correo;

    public Usuario(String identificacion, String nombre, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + " (" + identificacion + ") - " + correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario otro = (Usuario) o;
        return Objects.equals(identificacion, otro.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion);
    }
}
