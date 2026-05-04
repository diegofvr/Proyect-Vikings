package buclesScanner;

import java.util.Scanner;

public class ejerciciosScanner {
    public  static void main(String[]args) {

        Scanner lectura = new Scanner(System.in);

        boolean continuar = true;


        while(continuar) {
            System.out.println("--- Listado de compras ---");

            System.out.println("Producto o (pulsa 0 para salir):");
            String producto = lectura.nextLine(); // 1. Guardamos el nombre aquí

            // 2. Corregido: Comparamos el TEXTO 'producto' con "0"
            if (producto.equals("0")) {
                continuar = false;
                System.out.println("Saliendo de la compra...");
            } else {
                System.out.println("Dime el precio del producto:");
                int precio = lectura.nextInt();

                System.out.println("Dime la cantidad:");
                int cantidad = lectura.nextInt();

                // 3. ¡TRUCO MÁGICO!: Esta línea limpia el "Enter" que quedó flotando
                lectura.nextLine();

                int total = precio * cantidad;
                System.out.println("Total a pagar por " + producto + " es: " + total);
                System.out.println("-----------------------------");


            }

        }

































    }
}
