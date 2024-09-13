import java.util.Scanner;

public class AppGestionReservas {
    public static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {
        SistemaGestionReservas sistema = new SistemaGestionReservas();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Reservas ---");
            System.out.println("1. Agregar reserva");
            System.out.println("2. Obtener reserva");
            System.out.println("3. Eliminar reserva");
            System.out.println("4. Mostrar estado del sistema");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el identificador de la reserva: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese la fecha de la reserva (dd/mm/yyyy): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Ingrese el nombre del reservante: ");
                    String nombre = scanner.nextLine();
                    Reserva nuevaReserva = new Reserva(id, fecha, nombre);
                    sistema.agregarReserva(nuevaReserva);
                }

                case 2 -> {
                    System.out.print("Ingrese el identificador de la reserva: ");
                    String id = scanner.nextLine();
                    Reserva reserva = sistema.obtenerReserva(id);
                    if (reserva != null) {
                        System.out.println("Detalles de la reserva: " + reserva);
                    }
                }

                case 3 -> {
                    System.out.print("Ingrese el identificador de la reserva a eliminar: ");
                    String id = scanner.nextLine();
                    sistema.eliminarReserva(id);
                }

                case 4 -> sistema.mostrarEstadoActual();

                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del programa...");
                }

                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}