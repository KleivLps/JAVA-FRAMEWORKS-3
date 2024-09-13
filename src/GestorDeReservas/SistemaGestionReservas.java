import java.util.HashMap;

public class SistemaGestionReservas{
    private final HashMap<String, Reserva> reservas;

    public SistemaGestionReservas() {
        reservas = new HashMap<>();
    }

    public void agregarReserva(Reserva reserva) {
        if (reservas.containsKey(reserva.getIdentificador())) {
            System.out.println("Error: Ya existe una reserva con el identificador " + reserva.getIdentificador());
        } else {
            reservas.put(reserva.getIdentificador(), reserva);
            System.out.println("Reserva agregada exitosamente.");
        }
    }

    public Reserva obtenerReserva(String identificador) {
        if (reservas.containsKey(identificador)) {
            return reservas.get(identificador);
        } else {
            System.out.println("No se encontró ninguna reserva con el identificador " + identificador);
            return null;
        }
    }

    public void eliminarReserva(String identificador) {
        if (reservas.containsKey(identificador)) {
            reservas.remove(identificador);
            System.out.println("Reserva eliminada exitosamente.");
        } else {
            System.out.println("No se encontró ninguna reserva con el identificador " + identificador);
        }
    }

    public void mostrarEstadoActual() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas en el sistema.");
        } else {
            System.out.println("\n--- Estado actual del sistema ---");
            for (Reserva reserva : reservas.values()) {
                System.out.println(reserva);
            }
            System.out.println("Cantidad total de reservas: " + reservas.size());
        }
    }
}