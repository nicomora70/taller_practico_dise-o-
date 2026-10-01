// Contrato para los objetos que pueden recibir notificaciones del sistema.
// Solo dice QUE se puede notificar, no COMO se envia el mensaje.
public interface Notificable {
    void notificar(String mensaje);
}
