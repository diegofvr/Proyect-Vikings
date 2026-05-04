package buclesScanner;

import java.util.Scanner; // 2. La "llamada" a la herramienta (SIEMPRE AQUÍ)
public class pruebaScanner { // 3. El nombre de tu archivo (Que no sea solo "Scanner")
    public static void main(String[] args) {
        // 4. Aquí creas tu "lector"
        Scanner lector = new Scanner(System.in);

        // 1. Creamos una variable para decidir si seguimos o no
        boolean continuar = true;

        while (continuar) {
            System.out.println("--- NUEVA MULTIPLICACIÓN ---");

            System.out.println("Dime el primer número (o escribe 0 para salir):");
            int n1 = lector.nextInt();

            // Si el usuario escribe 0, el programa se apaga
            if (n1 == 0) {
                continuar = false;
                System.out.println("Saliendo de la calculadora...");
            } else {
                System.out.println("Dime el segundo número:");
                int n2 = lector.nextInt();

                int resultado = n1 * n2;
                System.out.println("El resultado es: " + resultado);
                System.out.println("-----------------------------");
            }
        }

















    }
}