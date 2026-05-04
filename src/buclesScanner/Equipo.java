package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class Equipo {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>equipoFutbol = new ArrayList<>();

        int opcion = 10;

        while (opcion != 4) {
            System.out.println("\n1. Fichar | 2. Ver Plantilla | 3. Verificar Equipo | 4. Salir");
            opcion = leer.nextInt();

            if (opcion == 1) {
                System.out.println("Como te llamas");
                leer.nextLine();

                String jugador = leer.nextLine();
                equipoFutbol.add(jugador);
                System.out.println("Jugador agragado");

            } else if (opcion == 2) {
                if (equipoFutbol.isEmpty()) {
                    System.out.println("Aun no hay nadie en el equipo");
                } else {
                    System.out.println("Equipo: " + equipoFutbol);
                }


            } else if (opcion == 3) {
                int cantidad = equipoFutbol.size();
                System.out.println("Actualmente tienes " + cantidad + " jugadores ");

                if (cantidad >= 5){
                    System.out.println("Ya estamos completos, podemos jugar");
                }else {
                    int faltantes = 5 - cantidad;
                    System.out.println("Aun nos faltan " + faltantes + " jugadores ");
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo de listas del equipo ...");

            }


        }

        System.out.println("Estuviste con DIEGO FC, hasta pronto");

        }
}
