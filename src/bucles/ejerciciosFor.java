package bucles;

public class ejerciciosFor {
    public static void main(String[]args){


        for (int i = 1; i <= 8; i++ ) { // aca es para encontrar un numero en especial//
            if (i == 4) {
                System.out.println("¡ALERTA! Tableta #4 dañada, enviando a revisión" + i);
            } else {
                System.out.println("Vendiendo tableta número: " + i);
            }
        }

        for (int i = 1; i <= 8; i++){
            if (i == 4){
                System.out.println("Es la hora de almorzar, son las :" + i);
            }else{
                System.out.println("Son las :" + i);
            }
        }

        for (int i = 1; i <= 10; i++){
            if (i % 2 == 0){ // El simbolo del % es para los numeros pares//
                System.out.println("Luz # " + i + " Encendida" );
            }else{
                System.out.println("Luz # " + i + " Apagada" );
            }
        }

        for (int  i = 5; i >= 1; i--){ // aca es una cuenta regresiva //
            System.out.println("¡Solo quedan " + i + " unidades en Stock!" );
        }
        System.out.println("¡AGOTADO! volvemos mañana");







    }
}
