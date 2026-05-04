package proyectoVikings;


// Declaro la clase //
public class Producto {

    // Atributos de los productos - caracteristicas, Private para que nadie de afuera los toque//
    private String nombre;
    private String talla;
    private double precio;
    private int stock;


    // Este es el constructor, el metodo que se ejecuta cuando creo un producto con "new prducto" y recibe los 4 parametros que definimos//
    public Producto(String nombre, String talla, double precio, int stock){

        //Aquí "this" es la clave. Como el parámetro y el atributo tienen el mismo nombre, Java necesita diferenciarlos
        // this.nombre  →  el atributo de la clase
        //nombre       →  el dato que llegó como parámetro

        this.nombre = nombre;
        this.talla = talla;
        this.precio = precio;
        this.stock = stock;
    }

    //Un método que imprime los detalles del producto en consola //

    public void mostrarDetalles(){
        System.out.println("\n-------------------------");
        System.out.println(" VIKING SPORT STORE");
        System.out.println("---------------------------");
        System.out.println("Producto: " + nombre);
        System.out.println("Talla: " + talla);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock + " Unds");
        System.out.println("----------------------------");
    }

    //Estos son los 4 getters — las ventanillas que permiten leer cada atributo desde afuera sin poder modificarlos.
    // Nota que el tipo que devuelve cada getter coincide exactamente con el tipo del atributo://

    public String getNombre() {
        return nombre;
    }

    public String getTalla() {
        return talla;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

}
//Clase Producto
//│
//├── Atributos (private) ← nadie los toca directo
//│   ├── nombre
//│   ├── talla
//│   ├── precio
//│   └── stock
//│
//├── Constructor ← crea el objeto con los 4 datos
//│
//├── mostrarDetalles() ← imprime todo en consola
//│
//└── Getters ← ventanillas para leer cada atributo
//    ├── getNombre()
//    ├── getTalla()
//    ├── getPrecio()
//    └── getStock() //