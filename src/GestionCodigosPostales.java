import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionCodigosPostales {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, String> codigosPostales = new HashMap<>();

        codigosPostales.put("28001", "Madrid");
        codigosPostales.put("08001","Barcelona");
        codigosPostales.put("41001","Sevilla");
        codigosPostales.put("29001","Málaga");
        codigosPostales.put("50001","Zaragoza");
        codigosPostales.put("46001","Valencia");
        codigosPostales.put("48001","Bilbao");
        codigosPostales.put("03001","Alicante");
        codigosPostales.put("37001", "Salamanca");
        codigosPostales.put("15001", "La coruña");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Mostrar los datos existentes.");
            System.out.println("2. Ingresar una nueva ciudad con su código postal.");
            System.out.println("3. Buscar ciudad por codigo postal.");
            System.out.println("4. Eliminar tres ciudades.");
            System.out.println("5. Actualizar ciudad por código postal.");
            System.out.println("6. Salir.");
            System.out.println("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ciudades y sus codigos postales:");
                    for (Map.Entry<String, String> entry : codigosPostales.entrySet()) {
                        System.out.println("Codigo postal: " +entry.getKey() + " - Ciudad: " +entry.getValue());
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese el código postal: ");
                    String nuevoCodigoPostal = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la ciudad: ");
                    String nuevaCiudad = scanner.nextLine();
                    codigosPostales.put(nuevoCodigoPostal, nuevaCiudad);
                    System.out.println("Ciudad agregada exitosamente.");
                }
                case 3 -> {
                    System.out.println("Ingrese el codigo postal: ");
                    String codigoPostalBusqueda = scanner.nextLine();
                    if (codigosPostales.containsKey(codigoPostalBusqueda)) {
                        System.out.println("La ciudad asociada al código postal " + codigoPostalBusqueda + " es " +codigosPostales.get(codigoPostalBusqueda));
                    } else {
                        System.out.println("No se encontro ninguna ciudad con ese codigo postal.");
                    }
                }
                case 4 -> {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Ingrese el codigo postal de la ciudad a eliminar: ");
                        String eliminarCodigoPostal = scanner.nextLine();
                        if (codigosPostales.containsKey(eliminarCodigoPostal)) {
                            codigosPostales.remove(eliminarCodigoPostal);
                            System.out.println("Ciudad eliminada con exito.");
                        } else {
                            System.out.println("No se encontro ninguna ciudad con ese codigo postal.");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Ingrese el codigo postal de la ciudad que desea actualizar: ");
                    String actualizarCodigoPostal = scanner.nextLine();
                    if (codigosPostales.containsKey(actualizarCodigoPostal)) {
                        System.out.println("Ingrese el nuevo nombre de la ciudad: ");
                        String nuevaCiudadActualizada = scanner.nextLine();
                        codigosPostales.put(actualizarCodigoPostal, nuevaCiudadActualizada );
                        System.out.println("Ciudad actualizada exitosamente. ");
                    } else {
                        System.out.println("No se encontro ninguna ciudad con ese codigo postal.");
                    }
                }
                case 6 -> salir = true;
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

}