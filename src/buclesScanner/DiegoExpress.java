package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;


public class DiegoExpress {
    public static void main (String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>equipaje = new ArrayList<>();


        int cupo = 5;
        int opcion = 0;

        while (opcion != 4 ){
            System.out.println("Estado: " + cupo + " Disponible.");
            System.out.println("1.Ingresar maleta.");
            System.out.println("2.Retiar maleta.");
            System.out.println("3.Ver pasajeros con maleta.");
            System.out.println("4.Salir.");

            opcion = leer.nextInt(); // para que lea el numero de  las opciones //

            if (opcion == 1) {
                if (cupo > 0) {

                    System.out.println("Dame el nombre del pasajero");
                    leer.nextLine(); // limpiar el enter //

                    String nombre = leer.nextLine();

                    cupo = cupo - 1;
                    equipaje.add(nombre);
                    System.out.println(nombre + " ha sido agreagado ");
                } else {
                    System.out.println("Lo siento, no hay cupos disponibles.");
                }


            } else if (opcion == 2) {
                if (equipaje.isEmpty()){
                    System.out.println("No has agregado ningun equipaje");
                }else{
                    System.out.println("Dame el nombre de la maleta a retirar");
                    leer.nextLine();

                    String nombre = leer.nextLine();

                    if (equipaje.remove(nombre)){
                        cupo = cupo +  1;
                        System.out.println(nombre + " ha sido Retirado");

                    }else{
                        System.out.println("No existe el nombre que quieres eliminar");
                    }
                }

            } else if (opcion == 3) {
                if (equipaje.isEmpty()){
                    System.out.println("No hay nada todavia");
                }else{
                    System.out.println("Tenemos a :" + equipaje);
                    System.out.println("Tenemos : " + equipaje.size() + " personas con equipaje ");
                }

            } else if (opcion == 4) {
                System.out.println("Saleindo del sistema de maletas...");

            }


        } // cerrar el bucle//

    }
}
