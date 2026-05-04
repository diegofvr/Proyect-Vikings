package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class DiegoAir {
    public static void main(String[]arg){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>diegoAir = new ArrayList<>();

        int opcion = 0;
        int asientosLibres = 4;

        System.out.println("Bienvenido a Vuelos DIEGO");
        System.out.println("Es un placer que vuele con nosotros");

        while (opcion != 4) {
            System.out.println(" Estado: " + asientosLibres + " Asientos libres");
            System.out.println("1.Comprar voleto");
            System.out.println("2.Lista");
            System.out.println("3.Borrar");
            System.out.println("4.Salir");

            opcion = leer.nextInt();

            if (opcion == 1) {
                if (asientosLibres > 0) {
                    System.out.println("Dame el nombre ");
                    leer.nextLine();

                    String nombre = leer.nextLine();


                    diegoAir.add(nombre);
                    asientosLibres = asientosLibres - 1;
                    System.out.println("Persona agreagada: " + nombre );

                } else {
                    System.out.println("Lo siento, no tenemos asientos disponibles");
                }


            } else if (opcion == 2) {
                if (diegoAir.isEmpty()){
                    System.out.println("El avion esta vacio");
                }else{
                    System.out.println("Tenemos a: " + diegoAir);
                    System.out.println("Tenemos " + diegoAir.size() + " Personas");
                }
                
            } else if (opcion == 3) {
                if (diegoAir.isEmpty()){
                    System.out.println("No hay nadie en la lista para sacar ");
                }else{
                    System.out.println("A quien quieres sacar? (escribe el nombre exacto)");
                    leer.nextLine();
                    String nombreBorrar = leer.nextLine();

                    if (diegoAir.remove(nombreBorrar)){
                        asientosLibres = asientosLibres + 1;
                        System.out.println(nombreBorrar + " Ha salido, ahora hay " + asientosLibres + " asientos libres");
                    }else{
                        System.out.println("Ese nombre no esta en la lista ");
                    }
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo...");

            }


        } // este cierra el while//

        System.out.println("Gracias por volar con nosotros, te esperamos de pronto");

    }
}
