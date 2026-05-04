package buclesScanner;

import java.util.Scanner;

public class ZapasDiego {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);

        int stock = 20;
        int opcion = 10;

        System.out.println("\n -- Bienvenido a Zapas Diego ---");

        while (opcion != 4){
            System.out.println("¿Que opcion quiere realizar?");
            System.out.println("1.Ver stock.");
            System.out.println("2.Comprar.");
            System.out.println("3.Recibir.");
            System.out.println("4.Salir.");
            opcion = leer.nextInt();


            if (opcion == 1){
                System.out.println("Su cantidad de zapatos son: " + stock);

            } else if (opcion == 2) {
                System.out.println("¿Cuantos quiere comprar?");
                int cantidad = leer.nextInt();

                if (cantidad <= stock){
                    stock = stock - cantidad;
                    System.out.println("¡Gracias por su compra!"  );
                    System.out.println(" Su nuevo inventario es: " + stock);
                }else{
                    System.out.println("Lo siento, no tenemos esa cantidad");
                }

            }if (opcion == 3){
                System.out.println("¿Cuantos voy a recibir?");
                int recibir = leer.nextInt();

                stock = stock + recibir;
                System.out.println(" Su nuevo Stock es: " + stock);


            }if (opcion == 4){
                System.out.println("Saliendo de la operacion...");
            }

        }
        System.out.println("Gracias por visitarnos, Lo esperamos pronto");







    }
}
