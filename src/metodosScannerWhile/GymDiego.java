package metodosScannerWhile;

import java.util.Scanner;
import java.util.ArrayList;

public class GymDiego {
    public static void main(String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<Socio> gym = new ArrayList<>();


        int opcion = 0;

        while (opcion != 5) {
            try {
                System.out.println(" Bienvenido a Gym Diego, ¿Que opcion quieres realizar?");

                System.out.println("1.Ingresar socio");
                System.out.println("2.Eliminar socio");
                System.out.println("3.Ver socios");
                System.out.println("4.Agregar pago");
                opcion = leer.nextInt();


                leer.nextLine();


                if (opcion == 1) {
                    ingresarSocio(gym, leer);

                } else if (opcion == 2) {
                    eliminarSocio(gym, leer);

                } else if (opcion == 3) {
                    verSocios(gym);

                } else if (opcion == 4) {
                    pagarMensualidad(gym, leer);
                }


            }catch(Exception e) {
                System.out.println("Error,¡Debes ingresar un numero, no letras!");
                leer.nextLine();
                opcion = 0;
            }
        }






    }public static void ingresarSocio(ArrayList<Socio> lista, Scanner leer){
        System.out.println("---- Registro de socio ----");

        System.out.println("Ingrese nombre y apellido");
        String nombre = leer.nextLine();

        System.out.println("Ingrese cedula");
        int cedula = leer.nextInt();


        Socio nuevo = new Socio(nombre, cedula);
        lista.add(nuevo);

        System.out.println("Socio Ingresado");



    }public static void eliminarSocio(ArrayList<Socio> lista, Scanner leer){
        System.out.println("Ingrese el numero de cedula que quieres retirar");
        int cedulaBuscar = leer.nextInt();

        for (int i = 0; i < lista.size(); i++ ){
            if (lista.get(i).cedula == cedulaBuscar){
                System.out.println("Socio " + lista.get(i).nombre + " Ha sido retirado");
                lista.remove(i);
                return;
            }
        }
        System.out.println(" No se encontro ningun socio con esa cedula");



    }public static void verSocios (ArrayList<Socio> lista){
        if (lista.isEmpty()){
            System.out.println(" El gimnasio esta vacio por ahora ");

        }else {
            System.out.println("--- Lista de socios actuales ---");
            for (Socio s : lista){
                String estado = s.tienePlanActivo ? "Al dia" : "Debe mensualidad";

                System.out.println("Nombre: " + s.nombre + " | C.C " + s.cedula + " | Estado: " + estado );

            }
        }

    }public static void pagarMensualidad (ArrayList<Socio> lista, Scanner leer){
        System.out.println("Ingrese numero de cedula a buscar");
        int cedulaBuscar = leer.nextInt();

        boolean encontrado = false;

        for (Socio s : lista){
            if (s.cedula == cedulaBuscar){
                s.tienePlanActivo = true;
                System.out.println("Pago exitoso " + s.nombre + " ya esta al dia");
                encontrado =  true;
                break;

            }
        }
        if (!encontrado){
            System.out.println("Error!! No exsite ningun socio con el numero de cedula " + cedulaBuscar);
        }
    }



}
