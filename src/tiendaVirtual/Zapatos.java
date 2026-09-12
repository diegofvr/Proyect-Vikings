package tiendaVirtual;

public class Zapatos extends Producto {

    private String tipo;

    public Zapatos (int id, String producto, String marca, String talla, String color, double precio, String tipo ){
        super(id, producto, marca, talla, color, precio);
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

    public void  setTipo (String tipo){
        this.tipo = tipo;

    }
}
