package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class SalaCine {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>salacine = new ArrayList<>();

        int opcion = 0;
        int asientos = 5;


        System.out.println("Bienvenido a salas de Cine Diego");

        while (opcion != 4) {
            System.out.println("Asientos disponibles:  " + asientos);
            System.out.println("1.Comprar boleta");
            System.out.println("2.Ver asientos disponibles");
            System.out.println("3.Borrar");
            System.out.println("4.Salir");
            opcion = leer.nextInt();


            if (opcion == 1) {
                if (asientos > 0) {
                    System.out.println("Dame tu nombre");
                    leer.nextLine();

                    String disponibles = leer.nextLine();

                    asientos = asientos - 1;

                    salacine.add(disponibles);
                    System.out.println("Persona agreagada " + disponibles);

                }else{

                    System.out.println("Lo sentimos, no tenemos hacientos disponibles");
                }
            } else if (opcion == 2) {
                if (salacine.isEmpty()) {
                    System.out.println("Aun no has agregado a nadie");
                } else {
                    System.out.println("Personas en sala: " + salacine);
                    System.out.println("Llevas un total de: " + salacine.size() + " personas");
                }


            } else if (opcion == 3) {
                if (salacine.isEmpty()) {
                    System.out.println("No hay nadie en la sala para sacar.");
                } else {
                    System.out.println("¿A quién quieres sacar? (Escribe el nombre exacto)");
                    leer.nextLine();
                    String nombreBorrar = leer.nextLine();

                    // .remove(objeto) busca el nombre y lo borra si lo encuentra
                    if (salacine.remove(nombreBorrar)) {
                        asientos = asientos + 1; // ¡Recuperamos el espacio!
                        System.out.println(nombreBorrar + " ha salido. Ahora hay " + asientos + " libres.");
                    } else {
                        System.out.println("Ese nombre no está en la lista.");
                    }
                }


            } else if (opcion == 4) {
                System.out.println("Saliendo...");

            }

        }
        System.out.println("Gracias por visitarnos");
    }
}
