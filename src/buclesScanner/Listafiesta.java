package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class Listafiesta {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String> listaFiesta = new ArrayList<>();

        int opcion = 8;

        System.out.println("\n Bienvenidos a la fiesta");


        while(opcion != 3){
            System.out.println("¿Te quieres registrar? 0 (presiona 0 para salir)");
            System.out.println("1.Anotar nuevo invitado");
            System.out.println("2.Ver mi lista de invitados");
            System.out.println("3.Salir");

            opcion = leer.nextInt();


            if (opcion == 1){
                System.out.println(" Regalame tu nombre ");
                leer.nextLine();
                String nombre = leer.nextLine();
                listaFiesta.add(nombre);
                System.out.println("Invitado agregado");

            } else if (opcion == 2) {
                if (listaFiesta.isEmpty()){
                    System.out.println("Aun no hay nadie registrado");
                }else{
                    System.out.println("La lista va asi: " + listaFiesta );
                }
            } else if (opcion == 3) {
                System.out.println("Saliendo de la lista...");

            }

        }

        System.out.println("Lo esperamos pronto");




    }
}
