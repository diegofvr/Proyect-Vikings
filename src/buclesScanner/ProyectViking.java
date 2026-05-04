package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class ProyectViking {
    public static void main(String[] args) {


        Scanner leer = new Scanner(System.in);
        ArrayList<Tenis> stockTenis = new ArrayList<>();


        int espacioBodega = 5;
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("Estado: " + espacioBodega + " Espacios disponibles");
            System.out.println("1.Comprar.");
            System.out.println("2.Vender.");
            System.out.println("3.Ver inventario");
            System.out.println("4.Vaciar");
            System.out.println("5.Salir");
            System.out.println("6.Aplicar descuento");
            opcion = leer.nextInt();


            if (opcion == 1) {
                if (espacioBodega > 0) {
                    comprarTenis(stockTenis, leer);
                    espacioBodega = espacioBodega - 1;
                } else {
                    System.out.println("No hay espacio en bodega");
                }


            } else if (opcion == 2) {
                boolean ventaExitosa = venderTenis(stockTenis, leer);

                if (ventaExitosa) {
                    espacioBodega = espacioBodega + 1;
                }


            } else if (opcion == 3) {
                mostrarInventario(stockTenis);


            } else if (opcion == 4) {
                vaciarBodega(stockTenis);
                espacioBodega = 5;


            } else if (opcion == 5) {
                System.out.println("Saliendo de Vikings Store...");

            } else if (opcion == 6) {
                aplicarDescuento(stockTenis);



            }

        }

    }

    public static void mostrarInventario(ArrayList<Tenis> listaParaMostrar) {
        if (listaParaMostrar.isEmpty()) {
            System.out.println("⚠️ Bodega vacía.");
        } else {
            System.out.println("👟 INVENTARIO VIKINGS:");
            // Usamos un bucle para ver cada zapato
            for (Tenis t : listaParaMostrar) {
                System.out.println("- " + t.marca + " | Talla: " + t.talla + " | $" + t.precio);
            }
        }
    }

    public static void vaciarBodega(ArrayList<Tenis> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay nada que eliminar ");

        } else {
            lista.clear();
            System.out.println("Se hizo limpieza en la bodega");

        }
    }

    public static void comprarTenis(ArrayList<Tenis> lista, Scanner teclado) {
        Tenis nuevo = new Tenis();

        System.out.println("Ingresando nuevo calzado a Vikings");
        teclado.nextLine();

        System.out.print("Marca: ");
        nuevo.marca = teclado.nextLine();

        System.out.print("Talla: ");
        nuevo.talla = teclado.nextInt();

        System.out.print("Precio: ");
        nuevo.precio = teclado.nextDouble();

        // 2. Guardamos el OBJETO completo en la lista
        lista.add(nuevo);
        System.out.println("✅ " + nuevo.marca + " guardado con éxito.");


    }

    public static boolean venderTenis(ArrayList<Tenis> vender, Scanner teclado) {
        if (vender.isEmpty()) {
            System.out.println("Lo siento, no hay nada para vender");
            return false;
        }

        System.out.println("¿Qué marca vamos a vender?");
        teclado.nextLine();
        String marcaBuscar = teclado.nextLine();

        // 🕵️‍♂️ Buscamos en la lista uno por uno
        for (int i = 0; i < vender.size(); i++) {
            // Sacamos el tenis de la posición i
            Tenis t = vender.get(i);

            // Comparamos el nombre que el usuario escribió con la marca del tenis
            if (t.marca.equalsIgnoreCase(marcaBuscar)) {
                vender.remove(i); // Si coincide, lo borramos de esa posición
                System.out.println("✅ " + marcaBuscar + " ha sido vendida.");
                return true;
            }
        }

        System.out.println("❌ Esa marca no está en el inventario.");
        return false;


    }public static void aplicarDescuento(ArrayList<Tenis> lista) {
        for (Tenis t : lista) {
            // Accedemos al atributo precio y lo bajamos un 20%
            t.precio = t.precio * 0.80;
        }
        System.out.println("¡Promoción activada! Todos los tenis tienen 20% de descuento.");
    }

}
