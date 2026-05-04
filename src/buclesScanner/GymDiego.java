package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class GymDiego {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>socios = new ArrayList<>();


        int maquinasLibres = 5;
        int opcion = 0;

        while (opcion != 4){
            System.out.println("Estado: " + maquinasLibres + " Maquinas disponibles");
            System.out.println("1.Registrar entrada");
            System.out.println("2.Registrar salida");
            System.out.println("3.Estado del Gym");
            System.out.println("4.Salir");
            opcion = leer.nextInt();

            if (opcion == 1) {
                if (maquinasLibres > 0) {
                    System.out.println("Dame tu nombre");
                    leer.nextLine();

                    String nombre = leer.nextLine();

                    maquinasLibres = maquinasLibres - 1; // empiezo a restar segun los socios que se vayan agregando//

                    socios.add(nombre);
                    System.out.println(nombre + " Ha sido agregado");
                } else {
                    System.out.println("Lo siento, no hay maquinas disponibles");
                }



            } else if (opcion == 2) {
                if (socios.isEmpty()) {
                    System.out.println("No has agregado a nadie");

                }else{
                    System.out.println("Dame el nombre de quien sale");
                    leer.nextLine();

                    String nombreEliminar = leer.nextLine();

                    if (socios.remove(nombreEliminar)){
                        maquinasLibres = maquinasLibres + 1;
                        System.out.println(nombreEliminar + " Ha sido eliminado");
                    }else {
                        System.out.println("Nombre incorrecto");
                    }


                }

            } else if (opcion == 3) {
                if (socios.isEmpty()){
                    System.out.println("Las maquinas estan vacias");
                }else{
                    System.out.println("Entrenado ahora " + socios);
                    System.out.println("Ocupadas :" + socios.size() );
                }


            } else if (opcion == 4) {
                System.out.println(" Saliendo...");
            }



        }// cierro el bucle del While//


































    }
}
