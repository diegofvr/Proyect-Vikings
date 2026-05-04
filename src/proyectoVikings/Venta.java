package proyectoVikings;

public class Venta {
    // Atributos de la venta — private para encapsulamiento
    private Producto producto;    // qué producto se vendió
    private int cantidad;         // cuántos se vendieron
    private double total;         // cuánto se cobró en total

    // Constructor — recibe el producto y la cantidad
    public Venta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        // El total se calcula automáticamente
        this.total = producto.getPrecio() * cantidad;
    }

    // Muestra el detalle de la venta
    public void mostrarVenta() {
        System.out.println("\n--- DETALLE DE VENTA ---");
        System.out.println("Producto: "  + producto.getNombre());
        System.out.println("Cantidad: "  + cantidad + " Unds");
        System.out.println("Total:    $" + total);
        System.out.println("------------------------");
    }

    // Getters
    public Producto getProducto() { return producto; }
    public int getCantidad()      { return cantidad; }
    public double getTotal()      { return total; }
}

