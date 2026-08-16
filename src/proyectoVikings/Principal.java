package proyectoVikings;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>(); // bolsa de productos
        ArrayList<Venta> ventas = new ArrayList<>();        // bolsa de ventas
        int opcion = 0;

        do {
            // Menu principal
            System.out.println("\n================================");
            System.out.println("     BIENVENIDO A VIKING STORE  ");
            System.out.println("================================");
            System.out.println("1. Ver inventario");
            System.out.println("2. Registrar producto");
            System.out.println("3. Vender producto");
            System.out.println("4. Ver historial de ventas");
            System.out.println("5. Buscar producto");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");

            // Manejo de excepciones — si escribe letra no explota
            try {
                opcion = leer.nextInt();
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("⚠ Opcion invalida, ingrese un numero.");
                leer.nextLine(); // limpia el scanner
                opcion = 0;     // reinicia para mostrar menú de nuevo
                continue;       // vuelve al inicio del do-while
            }

            switch (opcion) {
                case 1:
                    verInventario(inventario);
                    break;

                case 2:
                    registrarProducto(inventario, leer);
                    break;

                case 3:
                    venderProducto(inventario, ventas, leer);
                    break;

                case 4:
                    verVentas(ventas);
                    break;

                case 5:
                    buscarProducto(inventario, leer);
                    break;

                case 6:
                    System.out.println("Saliendo... Adios!");
                    break;

                default:
                    System.out.println("Esa opcion no existe, intenta de nuevo.");
            }

        } while (opcion != 6);
    }

    // =====================
    // 1. VER INVENTARIO
    // =====================
    public static void verInventario(ArrayList<Producto> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\n=== INVENTARIO VIKING STORE ===");
            for (Producto p : inventario) {
                p.mostrarDetalles();
            }
        }
    }

    // =====================
    // 2. REGISTRAR PRODUCTO
    // =====================
    public static void registrarProducto(ArrayList<Producto> inventario, Scanner leer) {
        System.out.println("\n=== REGISTRAR PRODUCTO ===");

        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Talla: ");
        String talla = leer.nextLine();

        System.out.print("Precio: ");
        double precio = leer.nextDouble();

        System.out.print("Stock: ");
        int stock = leer.nextInt();
        leer.nextLine();

        inventario.add(new Producto(nombre, talla, precio, stock));
        System.out.println("✅ Producto registrado exitosamente.");
    }

    // =====================
    // 3. VENDER PRODUCTO
    // =====================
    public static void venderProducto(ArrayList<Producto> inventario, ArrayList<Venta> ventas, Scanner leer) {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos para vender.");
            return;
        }

        // Muestra los productos disponibles
        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i).getNombre() + " - Stock: " + inventario.get(i).getStock() + " - $" + inventario.get(i).getPrecio());
        }

        System.out.print("Elija el numero del producto: ");
        int indice = leer.nextInt() - 1;
        leer.nextLine();

        // Valida que el índice exista
        if (indice < 0 || indice >= inventario.size()) {
            System.out.println("Producto no encontrado.");
            return;
        }

        Producto producto = inventario.get(indice);

        System.out.print("Cantidad a vender: ");
        int cantidad = leer.nextInt();
        leer.nextLine();

        // Verifica si hay stock suficiente
        if (cantidad > producto.getStock()) {
            System.out.println("⚠ Stock insuficiente. Solo hay "
                    + producto.getStock() + " unidades.");
            return;
        }

        // Registra la venta
        Venta venta = new Venta(producto, cantidad);
        ventas.add(venta);
        venta.mostrarVenta();
        System.out.println("✅ Venta realizada exitosamente.");
    }

    // =====================
    // 4. VER VENTAS
    // =====================
    public static void verVentas(ArrayList<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            System.out.println("\n=== HISTORIAL DE VENTAS ===");
            double totalGeneral = 0;
            for (Venta v : ventas) {
                v.mostrarVenta();
                totalGeneral += v.getTotal();
            }
            System.out.println("TOTAL GENERAL: $" + totalGeneral);
        }
    }

    // =====================
    // 5. BUSCAR PRODUCTO
    // =====================
    public static void buscarProducto(ArrayList<Producto> inventario, Scanner leer) {
        System.out.print("Ingrese el nombre a buscar: ");
        String buscar = leer.nextLine();

        boolean encontrado = false;
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(buscar)) {
                p.mostrarDetalles();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
}