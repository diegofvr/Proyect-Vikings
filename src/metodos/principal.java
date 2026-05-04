package metodos;

import java.util.Scanner;
import java.util.ArrayList;

public class principal {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Libro> biblioteca = new ArrayList<>();
        int opcion = 0;

        // Cambié la condición a 5 para que coincida con "Salir"
        while (opcion != 5) {
            try {
                System.out.println("\n--- BIENVENIDOS A LA BIBLIOTECA ---");
                System.out.println("1. Registrar libro");
                System.out.println("2. Ver libros");
                System.out.println("3. Prestar libro");
                System.out.println("4. Devolver libro");
                System.out.println("5. Salir");
                System.out.print("Seleccione: ");

                opcion = leer.nextInt();
                leer.nextLine(); // Limpiar el buffer

                // Usamos SWITCH, es más limpio que muchos IF
                switch (opcion) {
                    case 1 -> registrarLibro(biblioteca, leer);
                    case 2 -> verBiblioteca(biblioteca);
                    case 3 -> prestarLibro(biblioteca, leer);
                    case 4 -> devolverlibro(biblioteca, leer);
                    case 5 -> System.out.println("Cerrando sistema...");
                    default -> System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("¡Error! Ingresa un número válido.");
                leer.nextLine(); // Limpiar el error
                opcion = 0;
            }
        }
    }

    public static void registrarLibro(ArrayList<Libro> lista, Scanner leer) {
        System.out.print("Título: ");
        String titulo = leer.nextLine();
        System.out.print("Autor: ");
        String autor = leer.nextLine();

        lista.add(new Libro(titulo, autor));
        System.out.println("¡Libro ingresado con éxito!");
    }

    public static void verBiblioteca(ArrayList<Libro> lista) {
        if (lista.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            System.out.println("\n--- INVENTARIO ---");
            for (Libro l : lista) {
                // Le agregamos el estado para saber si está ahí o no
                String estado = l.estaPrestado ? "[PRESTADO]" : "[DISPONIBLE]";
                System.out.println(estado + " - " + l.titulo + " (" + l.autor + ")");
            }
        }
    }

    public static void prestarLibro(ArrayList<Libro> lista, Scanner leer) {
        System.out.print("Título a prestar: ");
        String nombreLibro = leer.nextLine();
        boolean encontrado = false;

        for (Libro l : lista) {
            if (l.titulo.equalsIgnoreCase(nombreLibro)) {
                if (!l.estaPrestado) {
                    l.estaPrestado = true;
                    System.out.println("Libro prestado con éxito.");
                } else {
                    System.out.println("Ese libro ya está prestado.");
                }
                encontrado = true;
                break;
            }
        }
        // Solo mostramos error si NO se encontró el libro después de buscar en toda la lista
        if (!encontrado) {
            System.out.println("Error: El libro no existe en el catálogo.");
        }
    }

    public static void devolverlibro(ArrayList<Libro> lista, Scanner leer) {
        System.out.print("Título a devolver: ");
        String nombreBuscado = leer.nextLine();
        boolean encontrado = false;

        for (Libro l : lista) {
            if (l.titulo.equalsIgnoreCase(nombreBuscado)) {
                if (l.estaPrestado) {
                    l.estaPrestado = false;
                    System.out.println("¡Gracias! Libro devuelto.");
                } else {
                    System.out.println("El libro ya estaba en la biblioteca.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Error: No se encontró ese título.");
        }
    }
}