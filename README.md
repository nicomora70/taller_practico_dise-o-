# SmartLibrary – Taller Práctico Bloque 5
### De clases aisladas a objetos que colaboran

Trabajo de Diseño de Software – IV semestre.

**Integrantes:** Jose Nicolas Mora y Drako David Salazar

**Repo:** https://github.com/nicomora70/taller_practico_dise-o-.git

## Qué hay aquí
- `src/` → código Java del taller (solo el pedazo que pedían, no toda la app).
  - `Notificable.java` → interfaz del contrato de notificación.
  - `Usuario.java` → superclase abstracta (identificación, nombre, correo).
  - `Estudiante.java` → hereda de Usuario **e implementa Notificable**.
  - `Bibliotecario.java` → hereda de Usuario, **no** es Notificable (decisión justificada en el PDF).
  - `Libro.java` / `Ejemplar.java` → agregación (R10).
  - `Prestamo.java` / `Renovacion.java` → composición + regla de renovación (R11).
  - `Reserva.java` → clase sencilla para completar componentes.
  - `Main.java` → prueba mínima (válida + inválida).
- `Solucion_Taller_Bloque5_SmartLibrary.pdf` → **todo el documento resuelto en un solo PDF** (actividades 1 a 6, diagramas, justificaciones y evidencias).
- `img/` → imágenes de los diagramas UML.

## Cómo compilar y correr (lo probé en Windows con Java 25)
```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Salida esperada:
```
=== PRUEBA SMARTLIBRARY BLOQUE 5 ===
Prestamo creado: Prestamo de EJ-001 a Nicolas Mora devuelve: 2026-10-08
--- Prueba 1: renovacion VALIDA al 2026-10-15 ---
[Notificacion para Nicolas Mora]: Su prestamo fue renovado.
Nueva fecha: 2026-10-15
Cantidad de renovaciones: 1
--- Prueba 2: renovacion INVALIDA al 2026-10-10 ---
OK, el sistema la rechazo...
```

La prueba 1 renueva bien y notifica, la prueba 2 intenta una fecha anterior y el sistema la rechaza sin cambiar nada.

## Decisiones rápidas
- `Estudiante - Prestamo`: asociación (solo se conocen).
- `Prestamo - Ejemplar`: asociación.
- `Libro - Ejemplar`: agregación (el físico sigue existiendo aunque se borre del catálogo).
- `Prestamo - Renovacion`: composición (la renovación no vive sola).
- `Usuario <- Estudiante / Bibliotecario`: herencia porque sí es un “es-un”.
- `Notificable`: solo `Estudiante`, porque los avisos son para el que pide prestado.

Todo justificado en el PDF.

## Conclusión
Antes veíamos clases sueltas y ahora entendemos que lo importante es cómo colaboran. Aprendimos a no usar composición por todo, a que la herencia solo vale si es un verdadero es-un y a que la interfaz es un contrato que no dice cómo se hace. El préstamo protege su regla de renovación y los componentes nos ayudan a ordenar el sistema por funciones. Diseñar relaciones nos obliga a leer bien los requisitos y a justificar cada decisión.
