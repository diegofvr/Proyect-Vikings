package proyectoAnimales;

public class Animal {
// Los atributos que van a tener //
    private String nombre;
    private int edad;
    private double peso;


// constructor, aca cobra vida //
    public Animal(String nombre,int edad, double peso){
        this.nombre = nombre;
        this.edad  = edad;
        this.peso = peso;

    }

// Un metodo que todos los animales van a compartir //
    public void mostarDatos(){
        System.out.println("--- Viking Vet ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad );
        System.out.println("Peso: " + peso);

    }

//Estos son los 3 getters — las ventanillas que permiten leer cada atributo desde afuera sin poder modificarlos.
    // Nota que el tipo que devuelve cada getter coincide exactamente con el tipo del atributo://

    public String getNombre(){return nombre;}
    public int getEdad(){return edad;}
    public double getPeso(){return peso;}
}
