package tiendaVirtual;

public class Pantalon extends  Producto{

    private String tipo;


    public Pantalon (String producto, String marca, String talla, String color, double precio, String tipo){
        super(producto, marca, talla, color, precio);
        this.tipo = tipo;
    }
    @Override
    public void mostrarProductos(){
        super.mostrarProductos();
        System.out.println("Tipo: " + tipo);
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }



}
