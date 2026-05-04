package buclesScanner;

import java.util.Scanner;
import java.util.ArrayList;

public class InventarioProyecto {
    public static void main (String[]args){


        Scanner leer = new Scanner(System.in);
        ArrayList<String>stockBodega = new ArrayList<>();


        int espacio = 5;
        int opcion = 0;

        while (opcion != 5){

            System.out.println("Disponibles  "+ espacio + " Espacios en bodega" );
            System.out.println("1. Ingresar ");
            System.out.println("2. Sacar");
            System.out.println("3. Inventario");
            System.out.println("4. Vaciar bodega");
            System.out.println("5. Salir");
            opcion = leer.nextInt();

            if (opcion == 1){
                if (espacio > 0){
                    System.out.println("Nombre del producto a Ingresar :");
                    leer.nextLine();


                    String nombre = leer.nextLine();
                    stockBodega.add(nombre);
                    espacio = espacio - 1;
                    System.out.println(nombre + " Ha ingresado de la bodega");

                }else{
                    System.out.println("Lo siento, la bodega esta llena ");
                }


            } else if (opcion == 2) {
                if (stockBodega.isEmpty()){
                    System.out.println("No has ingresado ningun prodcuto.");

                }else {
                    System.out.println("Dame el nombre del producto que quieres devolver");
                    leer.nextLine();

                    String productoEliminar = leer.nextLine();
                    if (stockBodega.remove(productoEliminar)){
                        espacio = espacio + 1;
                        System.out.println(productoEliminar + " Ha sido eliminado");
                    }else{
                        System.out.println("El producto no existe.");
                    }
                }

            } else if (opcion == 3) {
                if (stockBodega.isEmpty()){
                    System.out.println("No tienes ningun producto en bodega");
                }else{
                    System.out.println("Tienes: " + stockBodega);
                    System.out.println("Tienes: " + stockBodega.size() + " Productos");
                }

            } else if (opcion == 4) {
                stockBodega.clear();{
                    espacio = 5;
                    System.out.println("Su bodega ha sido limpiada");
                }


            } else if (opcion == 5) {
                System.out.println("Saliendo de bodega...");

            }


        }








































    }
}



