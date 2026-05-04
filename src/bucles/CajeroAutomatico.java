package bucles;

import java.util.Scanner;

public class CajeroAutomatico {
    public static  void main(String[]args) {


        Scanner leer = new Scanner(System.in);

        double saldo = 100.;
        int opcion = 10;


        System.out.println("\n --- Bienvenido a nuestro cajero ---");

        while (opcion != 4){

            System.out.println("\n ¿Que operacion desea realizar ( presiona 4 para salir)");


            System.out.println("\n 1.Consulta de saldo");
            System.out.println(" 2.Retiro");
            System.out.println(" 3.Consignacion");
            System.out.println(" 4.Salir");
            opcion = leer.nextInt();

            if (opcion == 1){
                System.out.println(" Tu saldo es: " + saldo);


            } else if (opcion == 2) {
                System.out.println("¿Cuanto dinero va a retirar? ");
                double dineroARetirar = leer.nextDouble();

                if(dineroARetirar <= saldo){
                    saldo = saldo - dineroARetirar;
                    System.out.println("Su retiro fue exitoso, su nuevo saldo es: " +  saldo);
                }else{
                    System.out.println("Error, dinero insuficiente ");
                }
            } else if (opcion == 3) {
                System.out.println("¿Cual es el monto a consignar? ");
                double monto = leer.nextDouble();

                if (monto > 0 ){
                    saldo = saldo + monto;
                    System.out.println("Su consignacion fue exitosa, nuevo saldo: " + monto);
                }else{
                    System.out.println("Error, no se pueden consignar numeros negativos ");
                }
            }


        }


        System.out.println("Gracias por utlizar nuestros cajeros, ¡que vuelva pronto!");
































    }
}
