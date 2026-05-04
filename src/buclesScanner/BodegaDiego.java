package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class BodegaDiego {
    public static void main(String[]arg){

        Scanner leer = new Scanner(System.in);
        ArrayList<String>bodega = new ArrayList<>();

            int capacidad = 6;
            int opcion = 0;

            while (opcion != 5){
                System.out.println("Estado: " + capacidad + " Disponibles" );
                System.out.println("1.Recibir");
                System.out.println("2.Borrar");
                System.out.println("3.Inventario");
                System.out.println("4.Vaciar bodega");
                System.out.println("5.Salir");

                opcion = leer.nextInt();


                if (opcion == 1){
                    if (capacidad > 0){
                        System.out.println("Dame el primer numero y la primera letra de la caja");
                        leer.nextLine();

                        String numero = leer.nextLine();

                        bodega.add(numero);
                        capacidad = capacidad - 1;

                        System.out.println(numero + " Ha sido agreagado");

                    }else{
                        System.out.println("Lo siento, ya no tenemos espacio disponible");
                    }
                } else if (opcion == 2) {
                    if (bodega.isEmpty()){
                        System.out.println("No hay ninguna lista");

                    }else{
                        System.out.println("¿Que caja quieres sacar? (Dame la letra y el numero)");
                        leer.nextLine();
                        String letraYNumeroBorrar = leer.nextLine();

                        if (bodega.remove(letraYNumeroBorrar)){
                            capacidad = capacidad + 1;
                            System.out.println("Ha salido, ahora hay " + capacidad + " lugares libres" );
                        }else{
                            System.out.println("No existe la caja o escribiste mal");
                        }
                    }


                } else if (opcion == 3) {
                    if (bodega.isEmpty()){
                        System.out.println("La bodega esta vacia");
                    }else{
                        System.out.println("Tenemos: " + bodega.size() + " cajas y nos sobran " + capacidad + " espacios");
                    }

                } else if (opcion == 4) {
                    bodega.clear();{
                        capacidad = 6;
                        System.out.println("Listo, la bodega quedo vacia");
                    }

                } else if (opcion == 5) {
                    System.out.println("Saliendo del sistema de inventario...");

                }


            }























    }
}
