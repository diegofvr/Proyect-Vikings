package metodosScannerWhile;

import java.util.Scanner;
import java.util.ArrayList;

public class ParqueaderoDiego {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<Carro>parqueadero = new ArrayList<>();

        int lugares = 5;
        int opcion = 0;

        while (opcion != 5){
            System.out.println("Estado: " + lugares + " Lugares disponibles");
            System.out.println("1.Entrada de carro");
            System.out.println("2.Salida de carro");
            System.out.println("3.Ver parqueadero");
            System.out.println("4.Vaciar lugares");
            System.out.println("5.Buscar vehiculo por placa");
            opcion = leer.nextInt();


            if (opcion == 1){
                if (lugares > 0){
                    regitrarEntrada(parqueadero, leer);
                    lugares = lugares -1;
                }else {
                    System.out.println("No hay cupo");
                }

            } else if (opcion == 2) {
                boolean salidaExitosa = registrarSalida(parqueadero,leer);

                if (salidaExitosa){
                    lugares = lugares + 1;
                }

            } else if (opcion == 3) {
                verInventario(parqueadero);


            } else if (opcion == 4) {
                vaciarParqueadero(parqueadero);
                lugares = 5;

            }else if(opcion == 5){
                leer.nextLine();
                buscarVehiculo(parqueadero, leer);

            }
        }


    }public static void regitrarEntrada(ArrayList<Carro> entrada, Scanner teclado){
        Carro nuevo = new Carro();

        System.out.println("Ingresando nuevo Carro al sistema");
        teclado.nextLine();

        System.out.println("Ingresa placa");
        nuevo.placa = teclado.nextLine();

        System.out.println("Ingresa Modelo");
        nuevo.modelo = teclado.nextLine();


        entrada.add(nuevo);
        System.out.println("✅ " + nuevo.placa + " Ha sido agregado");


    }public static boolean registrarSalida(ArrayList<Carro> salida, Scanner teclado){
        if (salida.isEmpty()){
            System.out.println("Lo siento no hay carros para sacar");
            return false ;
        }

        System.out.println("¿Que carro vamos a sacar?");
        teclado.nextLine();
        String placaBuscar = teclado.nextLine();

        for (int i = 0; i < salida.size(); i++){
            Carro c = salida.get(i);

            if (c.placa.equalsIgnoreCase(placaBuscar)){
                salida.remove(i);
                System.out.println(placaBuscar + " Ha salido");
                return true;
            }

        }
        System.out.println("La placa que busca no exsite");
        return false;



    }public static void verInventario(ArrayList<Carro> listaParaMostrar){
        if (listaParaMostrar.isEmpty()){
            System.out.println("El parqueadero esta vacio");
        }else {
            System.out.println("Parqueadero: ");
            for (Carro c : listaParaMostrar){
                System.out.println("Carros: " + c.placa +" - " + c.modelo);
            }
        }


    }public static void vaciarParqueadero (ArrayList<Carro>listaParaVaciar){
        if (listaParaVaciar.isEmpty()){
            System.out.println("No hay Carros para eliminar");
        }else{
            listaParaVaciar.clear();
            System.out.println("Se hizo limpieza del parqueadero");
        }



    }public static void buscarVehiculo(ArrayList<Carro> inventario, Scanner teclado) {
        System.out.println("🔎 Ingrese la placa que desea buscar:");
        String placaABuscar = teclado.nextLine();
        boolean encontrado = false;

        for (Carro c : inventario) {
            if (c.placa.equalsIgnoreCase(placaABuscar)) {
                System.out.println("✅ ¡Vehículo encontrado!");
                System.out.println("Placa: " + c.placa + " | Modelo: " + c.modelo);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("❌ No se encontró ningún vehículo con la placa: " + placaABuscar);
        }

    }
}
