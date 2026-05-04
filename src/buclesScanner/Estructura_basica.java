package buclesScanner;

import java.util.Scanner;

public class Estructura_basica {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

       System.out.println("Dame tu nombre");
       String nombre = leer.nextLine();

        System.out.println("¿Que cafe quieres? latte o capuchino ");
        String cafe = leer.nextLine();

        System.out.println("Los cafes cuestan: ");
        int precio = leer.nextInt();

        leer.nextLine();

        System.out.println("Cuantos cafes: ");
        int cantidad = leer.nextInt();

        leer.nextLine();

        int total = precio * cantidad;

        if (total > 20){
            System.out.println("¡Tienes un 10% de descuento para tu proxima compra! ");
        }else{
            System.out.println("Gracias por su compra");
        }


        System.out.println("Cliente " + nombre + "| pedido " + cantidad + " " + cafe + " total a pagar: " + total );










    }


}


