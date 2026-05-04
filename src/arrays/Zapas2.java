package arrays;

import java.util.Scanner;
import java.util.ArrayList; // 1. IMPORTAMOS LA "BOLSA"

public class Zapas2 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        // 2. CREAMOS LA LISTA PARA GUARDAR NOMBRES (Empieza vacía)
        ArrayList<String> listaVentas = new ArrayList<>();

        int stock = 20;
        int opcion = 10;

        System.out.println("\n--- BIENVENIDO A ZAPAS DIEGO 2.0 ---");

        while (opcion != 5) { // Cambié a 5 para tener una opción más
            System.out.println("\n¿Que opcion quiere realizar?");
            System.out.println("1. Ver stock");
            System.out.println("2. Comprar (y registrar cliente)");
            System.out.println("3. Recibir mercancia");
            System.out.println("4. Ver lista de compradores"); // NUEVA
            System.out.println("5. Salir");

            opcion = leer.nextInt();

            if (opcion == 1) {
                System.out.println("Stock actual: " + stock + " pares.");

            } else if (opcion == 2) {
                System.out.println("¿Cuantos pares quiere comprar?");
                int cantidad = leer.nextInt();

                if (cantidad <= stock) {
                    // AQUÍ ESTÁ EL REGISTRO
                    System.out.println("¿Cual es el nombre del cliente?");
                    String nombreCliente = leer.next(); // Leemos el nombre

                    stock = stock - cantidad;
                    listaVentas.add(nombreCliente); // 3. ¡LO GUARDAMOS EN LA BOLSA!

                    System.out.println("¡Venta exitosa para " + nombreCliente + "!");
                } else {
                    System.out.println("Error: No hay suficiente stock.");
                }

            } else if (opcion == 3) {
                System.out.println("¿Cuantos pares llegaron?");
                int recibir = leer.nextInt();
                stock = stock + recibir;
                System.out.println("Nuevo Stock: " + stock);

            } else if (opcion == 4) {
                // 4. MOSTRAR LA LISTA
                if (listaVentas.isEmpty()) {
                    System.out.println("Aun no se ha vendido nada hoy.");
                } else {
                    System.out.println("Clientes de hoy: " + listaVentas);
                }

            } else if (opcion == 5) {
                System.out.println("Cerrando sistema...");
            }
        }
        System.out.println("Gracias por visitarnos.");
    }
}

