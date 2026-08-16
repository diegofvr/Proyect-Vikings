package proyectoAnimales;



import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main (String[]args){

        Scanner leer = new Scanner(System.in);
        ArrayList<Animal> hospital = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n===============================");
            System.out.println("    Bienvenido a Viking Vet      ");
            System.out.println("=================================");
            System.out.println("1.Registrar animal.");
            System.out.println("2.Ver animales.");
            System.out.println("3.Buscar animal.");
            System.out.println("4.Dar de alta a un animal.");
            System.out.println("5.Salir.");


            try {

                opcion = leer.nextInt();
                leer.nextLine();

            }catch (Exception e){
                System.out.println("Opcion invalida, Ingrese un numero");
                leer.nextLine();
                opcion = 0;
                continue;

            }

            switch (opcion){
                case 1:
                    registrarAnimal(hospital, leer);
                    break;
                case 2:
                    verAnimales(hospital);
                    break;
                case 3:
                    buscarAnimal(hospital, leer);


            }



        }while (opcion != 5);






    }


    public static void registrarAnimal(ArrayList<Animal> hospital, Scanner leer ){
        System.out.println("\n --- Registrar animal ---");

        System.out.println("Nombre: ");
        String nombre = leer.nextLine();

        System.out.println("Edad: ");
        int edad =  leer.nextInt();
        leer.nextLine();

        System.out.println("Peso: ");
        double peso = leer.nextDouble();
        leer.nextLine();

        hospital.add(new Animal(nombre,edad,peso));
        System.out.println("El animal ha sido registrado correctamente.");


    }

    public static void verAnimales (ArrayList<Animal> hospital ){
        if (hospital.isEmpty()){
            System.out.println("No hay animales en el hospital");
        }else{
            System.out.println("\n--- Animales en el hospital ---");
            for (Animal a : hospital){
                a.mostarDatos();
            }
        }

    }


    public static void buscarAnimal(ArrayList<Animal> hospital, Scanner leer ){
        // Paso 1: pedir dato
        System.out.println("Ingrese nombre del Animal.");
        String nombre = leer.nextLine();

        // Paso 2: variable de control
        boolean encontrado = false;

        // Paso 3: recorrer lista
        for (Animal a : hospital){

            // Paso 4: comparar
            if (a.getNombre().equalsIgnoreCase(nombre)){

                // Paso 5: mostrar
                a.mostarDatos();
                encontrado = true;

            }
        }
        // Paso 6: si no existe
        if (! encontrado){
            System.out.println("Nombre no encontrado");
        }
    }

    public static void darDeAlta(ArrayList<Animal>hospital, Scanner leer){
        System.out.println("\n--- Dar de alta ---");

        System.out.println("Ingrese nombre del animal: ");
        String nombre = leer.nextLine();

        for (Animal a : hospital){
            if (a.getNombre().equalsIgnoreCase(nombre)){

            }
        }

    }


}
