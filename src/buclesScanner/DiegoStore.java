package buclesScanner;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class DiegoStore {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<String> diegoStore = new ArrayList<>();

        int opcion = 0;
        double presupuesto = 1000.0;

        System.out.println("Bienvenido a Diego Store");

        while (opcion != 3) {
            System.out.println("Presupuesto: $ " + presupuesto);
            System.out.println("Comprar cuesta (200)");
            System.out.println("1.Comprar ");
            System.out.println("2.Ver carrito");
            System.out.println("3.Salir");

            opcion = leer.nextInt();


            if (opcion == 1) {
                if (presupuesto >= 200) {
                    System.out.println("¿Nombre del producto?");
                    leer.nextLine();
                    String producto = leer.nextLine();

                    presupuesto = presupuesto -200;

                    diegoStore.add(producto);
                    System.out.println("Producto agregado " + producto);
                    System.out.println("Nuevo presupuesto: $" + presupuesto);


                    System.out.println("Tu saldo es: $" + presupuesto );

                } else{
                    System.out.println("Lo siento, no tienes presupuesto");
                }

            } else if (opcion == 2) {
                if (diegoStore.isEmpty()) {
                    System.out.println("Aun no has agregado nada");
                } else {
                    System.out.println("Tus productos: " + diegoStore);
                    System.out.println("Llevas un total de " +diegoStore.size());
                }

            } else if (opcion == 3) {
                System.out.println(" Saliendo de DIEGO STORE...");
            }
        }
        System.out.println("Muchas gracias por visitarnos, que vuelva pronto");


        }
}
