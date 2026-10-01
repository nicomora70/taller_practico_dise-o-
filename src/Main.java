import java.time.LocalDate;

// Clase para probar lo que pedian en la actividad 5.3
public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA SMARTLIBRARY BLOQUE 5 ===");

        // Creamos datos de prueba
        Estudiante estudiante = new Estudiante("1001", "Jose Nicolas Mora",
                "nmora@ucc.edu.co", "EST-2024-01", "Ing. Software");
        Libro libro = new Libro("978-0307474728", "Cien anios de soledad", "G. Garcia Marquez");
        Ejemplar ejemplar = new Ejemplar("EJ-001", "DISPONIBLE", libro);

        Prestamo prestamo = new Prestamo(estudiante, ejemplar,
                LocalDate.of(2026, 10, 1),
                LocalDate.of(2026, 10, 8));

        System.out.println("Prestamo creado: " + prestamo);
        System.out.println("Fecha prevista inicial: " + prestamo.getFechaPrevistaDevolucion());

        // PRUEBA 1: renovacion valida
        System.out.println("\n--- Prueba 1: renovacion VALIDA al 2026-10-15 ---");
        prestamo.renovar(LocalDate.of(2026, 10, 15));
        estudiante.notificar("Su prestamo fue renovado.");
        System.out.println("Nueva fecha: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getCantidadRenovaciones());
        System.out.println("Historial: " + prestamo.getRenovaciones().get(0));

        // PRUEBA 2: renovacion invalida (fecha anterior a la vigente)
        System.out.println("\n--- Prueba 2: renovacion INVALIDA al 2026-10-10 ---");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 10));
            System.out.println("ERROR: no debio aceptar esa fecha");
        } catch (IllegalArgumentException e) {
            System.out.println("OK, el sistema la rechazo: " + e.getMessage());
            System.out.println("La fecha sigue siendo: " + prestamo.getFechaPrevistaDevolucion());
            System.out.println("Cantidad de renovaciones sigue en: " + prestamo.getCantidadRenovaciones());
        }

        System.out.println("\n=== FIN DE LA PRUEBA ===");
    }
}
