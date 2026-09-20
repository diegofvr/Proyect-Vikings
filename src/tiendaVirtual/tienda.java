package tiendaVirtual;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class tienda {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Connection conexion = Conexion.obtenerConexion();
        ProductoDAO dao = new ProductoDAO(conexion);


        int opcion = 0;

        do {
            System.out.println("Bienvenido a Vikings Store");
            System.out.println("¿Que desear hacer hoy?");
            System.out.println("1. Ingresar producto.");
            System.out.println("2. Ver productos.");
            System.out.println("3. Buscar producto");
            System.out.println("4. Actualizar productos.");
            System.out.println("5. Eliminar productos.");
            System.out.println("6. Salir");


            try {
                System.out.println("Escribe una opcion: ");
                opcion = leer.nextInt();
                leer.nextLine();

            } catch (Exception e) {
                System.out.println("Opcion no valida, ingrese un numero");
                leer.nextLine();
                opcion = 0;
                continue;

            }


            switch (opcion) {

                case 1:
                    agregarProducto(dao, leer);
                    break;
                case 2:
                    verProductos(dao);
                    break;
                case 3:
                    buscarProducto(dao, leer);
                    break;
                case 4:
                    actualizarProducto(dao, leer);
                    break;
                case 5:
                    eliminarProducto(dao, leer);
                    break;
                case 6:
                    System.out.println("Cerrando tienda...");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }


        } while (opcion != 6);

    }

    public static void agregarProducto(ProductoDAO dao, Scanner leer) {
        System.out.println("--- Ingresar producto ---");

        System.out.println("Que producto quieres agregar: ");
        System.out.println("1.Camisa.");
        System.out.println("2.Pantalon.");
        System.out.println("3.Zapatos.");
        int categoria = leer.nextInt();
        leer.nextLine();

        String producto = "";
        switch (categoria) {
            case 1:
                producto = "Camisa";
                break;
            case 2:
                producto = "Pantalon";
                break;
            case 3:
                producto = "Zapatos";
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }

        System.out.println("Marca: ");
        String marca = leer.nextLine();

        System.out.println("Talla: ");
        String talla = leer.nextLine();

        System.out.println("Color: ");
        String color = leer.nextLine();

        System.out.println("Precio: ");
        double precio = leer.nextDouble();
        leer.nextLine();

        while (precio <= 0) {
            System.out.println("No se aceptan valores negativos");
            precio = leer.nextDouble();
            leer.nextLine();
        }

        boolean exito = dao.agregar(producto, marca, talla, color, precio);

        if (exito) {
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Hubo un problema al agregar el producto.");
        }
    }

    public static void verProductos(ProductoDAO dao) {
        ArrayList<Producto> productos = dao.obtenerTodos();

        if (productos.isEmpty()) {
            System.out.println("No hay productos");
        } else {
            for (Producto p : productos) {
                p.mostrarProductos();
            }
        }
    }


    public static void buscarProducto(ProductoDAO dao, Scanner leer) {
        System.out.println("ID del producto a buscar: ");
        int idBuscar = leer.nextInt();
        leer.nextLine();

        Producto p = dao.buscarPorId(idBuscar);

        if (p != null) {
            p.mostrarProductos();
        } else {
            System.out.println("No se encontró el producto buscado");
        }
    }


    public static void actualizarProducto(ProductoDAO dao, Scanner leer) {
        System.out.println("ID del producto a actualizar: ");
        int idActualizar = leer.nextInt();
        leer.nextLine();

        System.out.println("¿Qué desea actualizar?");
        System.out.println("1. Producto");
        System.out.println("2. Marca");
        System.out.println("3. Talla");
        System.out.println("4. Color");
        System.out.println("5. Precio");

        int opcionActualizar = leer.nextInt();
        leer.nextLine();

        String nuevoValorTexto = "";
        double nuevoValorPrecio = 0;

        switch (opcionActualizar) {
            case 1:
                System.out.println("Nuevo producto: ");
                nuevoValorTexto = leer.nextLine();
                break;
            case 2:
                System.out.println("Nueva marca: ");
                nuevoValorTexto = leer.nextLine();
                break;
            case 3:
                System.out.println("Nueva talla: ");
                nuevoValorTexto = leer.nextLine();
                break;
            case 4:
                System.out.println("Nuevo color: ");
                nuevoValorTexto = leer.nextLine();
                break;
            case 5:
                System.out.println("Nuevo precio: ");
                nuevoValorPrecio = leer.nextDouble();
                leer.nextLine();
                break;
            default:
                System.out.println("Opcion no valida");
                return;
        }

        boolean exito = dao.actualizar(idActualizar, opcionActualizar, nuevoValorTexto, nuevoValorPrecio);

        if (exito) {
            System.out.println("Producto actualizado correctamente");
        } else {
            System.out.println("Producto no existe");
        }
    }


    public static void eliminarProducto(ProductoDAO dao, Scanner leer) {
        System.out.println("ID del producto a eliminar: ");
        int idEliminar = leer.nextInt();
        leer.nextLine();

        String resultado = dao.eliminar(idEliminar);

        if (resultado.equals("OK")) {
            System.out.println("Producto eliminado correctamente.");
        } else if (resultado.equals("NO_ENCONTRADO")) {
            System.out.println("Producto no encontrado");
        } else if (resultado.equals("TIENE_VENTAS")) {
            System.out.println("No se puede eliminar: este producto tiene ventas registradas.");
        } else {
            System.out.println("Error al eliminar producto: " + resultado);
        }
    }
}

