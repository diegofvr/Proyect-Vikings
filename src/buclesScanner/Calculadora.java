package buclesScanner;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("---Bienvenido a su calculadora---");


        System.out.println("Dame el primer numero:");
        int n1 = leer.nextInt();

        System.out.println("Dame el segundo  numero:");
        double n2 = leer.nextDouble();


        System.out.println("¿Que operacion quieres hacer?");
        System.out.println("1.Sumar");
        System.out.println("2.Restar");
        System.out.println("3.Multiplicar");
        System.out.println("4.Divicion");
        System.out.println("0.Cerrar");


        int opcion = leer.nextInt();

        if(opcion == 1){
            double suma = n1 + n2;
            System.out.println("Su resultado es: " + suma);
        } else if (opcion == 2) {
            double resta = n1 - n2;
            System.out.println("Su resultado es: " + resta);
        }else if (opcion == 3) {
            double multiplicacion = n1 * n2;
            System.out.println("Su resultado es: " + multiplicacion);
        }else if (opcion == 4){
            if (n2 != 0){
                double division = n1 / n2;
                System.out.println("Su resultado es: " + division );
            }else{
                System.out.println("Error, no se puede dividir entre 0");
            }

        }












    }
}
