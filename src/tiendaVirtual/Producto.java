package tiendaVirtual;

public class Producto {

     private String producto;
     private String marca;
     private String talla;
     private  String color;
     private double precio;




    public Producto (String producto,String marca, String talla, String color, double precio){
        this.producto = producto;
        this.marca = marca;
        this.talla = talla;
        this.color = color;
        this.precio = precio;

    }

    public void mostrarProductos(){
        System.out.println("--- Vikings Store ---");
        System.out.println("Producto: " + producto);
        System.out.println("Marca: " + marca);
        System.out.println("Talla: " + talla);
        System.out.println("Color: " + color);
        System.out.println("Precio: " + precio);

    }


    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTalla() {
        return talla;
    }

    public String getProducto() {
        return producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio){
        if (precio > 0 ){
            this.precio = precio;
            System.out.println("Precio agregado correctamente");
        }else {
            System.out.println("No se permiten valores en negativo");
        }
    }
}
