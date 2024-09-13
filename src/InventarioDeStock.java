import java.util.HashMap;
import java.util.Scanner;

public class InventarioDeStock {
    public static Scanner scanner = new Scanner(System.in);
    private final HashMap<String, Integer> inventario;
    public InventarioDeStock() {
        inventario = new HashMap<>();
    }

    private String normalizarNombreDeProducto(String nombreProducto) {
        return nombreProducto.trim().toLowerCase();
    }

    public void agregarOActualizarProducto(String nombreProducto, int cantidad) {
        nombreProducto = normalizarNombreDeProducto(nombreProducto);
        if (inventario.containsKey(nombreProducto)) {
            int cantidadExistente = inventario.get(nombreProducto);
            inventario.put(nombreProducto, cantidadExistente + cantidad);
            System.out.println("Producto actualizado. Nueva cantidad: " +inventario.get(nombreProducto));
        } else {
            inventario.put(nombreProducto, cantidad);
            System.out.println("Producto agregado exitosamente.");
        }
    }

    public int obtenerCantidadEnStock(String nombreProducto) {
        nombreProducto = normalizarNombreDeProducto(nombreProducto);
        return inventario.getOrDefault(nombreProducto, 0);
    }

    public boolean verificarExistenciaProducto(String nombreProducto) {
        nombreProducto = normalizarNombreDeProducto(nombreProducto);
        return inventario.containsKey(nombreProducto);
    }

    public static void main(String[] args) {
        InventarioDeStock inventario = new InventarioDeStock();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU DE INVENTARIO ---");
            System.out.println("1. Agregar o actualizar producto");
            System.out.println("2. Verificar cantidad en stok");
            System.out.println("3. Verificar si un producto existe");
            System.out.println("4. Salir");
            System.out.println("ELIGE UNA OPCION");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    inventario.agregarOActualizarProducto(nombreProducto, cantidad);
                }

                case 2 -> {
                    System.out.print("Ingrese el nombre del producto para verificar cantidad en stock: ");
                    String nombreProducto = scanner.nextLine();
                    int cantidadEnStock = inventario.obtenerCantidadEnStock(nombreProducto);
                    System.out.println("Cantidad en stock del producto " + nombreProducto + ": " + cantidadEnStock);
                }

                case 3 -> {
                    System.out.print("Ingrese el nombre del producto para verificar si existe: ");
                    String nombreProducto = scanner.nextLine();
                    boolean existe = inventario.verificarExistenciaProducto(nombreProducto);
                    if (existe) {
                        System.out.println("El producto " + nombreProducto + " existe en el inventario.");
                    } else {
                        System.out.println("El producto " + nombreProducto + " no existe en el inventario.");
                    }
                }

                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo del programa...");
                }
                default -> System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
