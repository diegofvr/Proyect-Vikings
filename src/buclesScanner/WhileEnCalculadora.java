package buclesScanner;

import java.util.Scanner;

public class WhileEnCalculadora {
    public static void main(String[]args) {

        Scanner leer = new Scanner(System.in);

        int opcion = 10;

        System.out.println("Bienvenido a tu calculadora o (pulsa 0 para salir)");

        while (opcion != 0) {

            System.out.println("\n ¿Que operacion quieres realizar? ");


            System.out.println("1. Suma ");
            System.out.println("2. Resta ");
            System.out.println("0. Salir ");
            opcion = leer.nextInt();

            if (opcion != 0){
                System.out.println("Dame el primer numero: ");
                double n1 = leer.nextDouble();

                System.out.println("Dame el segundo numero: ");
                double n2 = leer.nextDouble();


                if (opcion == 1){
                    double suma = n1 + n2;
                    System.out.println("El resultado de la suma es de: "+ suma );
                } else if (opcion == 2) {
                    double resta = n1 - n2;
                    System.out.println("El resultado de la resta es de: "+ resta);

                }


            }


        }

        System.out.println("Calculadora cerrada, hasta pronto");



    }
}
