package metodosScannerWhile;

import java.util.Scanner;
import java.util.ArrayList;

public class ProgramaInventario {
    public static void main (String[] args){

        Scanner leer = new Scanner(System.in);
        ArrayList<Producto> bodega = new ArrayList<>();


        int opcion = 0;
        int espacioBodega = 5;

        while (opcion != 5){
            System.out.println("Tenemos " + espacioBodega + " Espacios  Disponibles");

            System.out.println("1. Agregar producto.");
            System.out.println("2. Retirar producto.");
            System.out.println("3. Ver bodega.");
            System.out.println("4. Vaciar bodega.");
            System.out.println("5.Modificar Stock o producto");
            System.out.println("6. Salir.");
            opcion = leer.nextInt();

            leer.nextLine();



            if (opcion == 1 ){
                if (espacioBodega > 0){
                    agregarProdcuto(bodega, leer);
                    espacioBodega--;


                }else{
                    System.out.println("La bodega esta llena.");
                }

            } else if (opcion == 2) {
                retirarProducto(bodega, leer);
                espacioBodega++;

            } else if (opcion == 3) {
                verBodega(bodega);

            } else if (opcion == 4) {
                vaciarBodega(bodega);
                espacioBodega = 5;


            } else if (opcion == 5) {
                actualizarStock(bodega, leer);

            }


        }




    }public static void agregarProdcuto(ArrayList<Producto> lista,Scanner leer){
        System.out.println("---- Registro de producto ----");

        System.out.println("Nombre: ");
        String nombre = leer.nextLine();

        System.out.println("Codigo: ");
        int codigo = leer.nextInt();

        System.out.println("Precio: ");
        double precio = leer.nextDouble();

        System.out.println("Cantidad: ");
        int cantidad = leer.nextInt();


        Producto nuevo = new Producto(nombre,codigo,precio,cantidad);

        lista.add(nuevo);

        System.out.println(nombre + " Fue agregado correctamente");


    }public static void retirarProducto(ArrayList<Producto> lista, Scanner leer){
        System.out.println("Ingrese el codigo del producto que quiere retirar: ");
        int codigoBusqueda = leer.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).codigo == codigoBusqueda){
                System.out.println("Producto " + lista.get(i).nombre + " Eliminado");
                lista.remove(i);
                encontrado = true;
                break;
            }
            }
        if (!encontrado){
            System.out.println("No se encontro ningun producto con el codigo: " + codigoBusqueda);

        }


    }public static void verBodega(ArrayList<Producto> lista){
        System.out.println("--- Estado actual de la bodega---");

        if (lista.isEmpty()){
            System.out.println("La bodega esta vacia, no hay nada para mostrar.");
        }else {
            for (int i = 0; i < lista.size(); i++){

                Producto p = lista.get(i);

                System.out.println((i + 1) + ". [ID: " + p.codigo + "] " + p.nombre + " - Cantidad: " + p.cantidad + " - Precio: $" + p.precio +  " Valor total: " + (p.precio * p.cantidad)  );
            }
        }
        System.out.println("-------------------------------------\n");


    }public static void vaciarBodega (ArrayList<Producto> lista){
        lista.clear();

        System.out.println("La bodega ha sido vaciada.");



    }public static void actualizarStock(ArrayList<Producto> lista, Scanner leer){
        System.out.println(" ¿Que codigo buscas modificar? ");
        int id = leer.nextInt();

        for (int i = 0; i < lista.size(); i ++){
            if (lista.get(i).codigo == id ){
                System.out.println("Ingrese la nueva cantidad");
                int nuevaCantidad = leer.nextInt();

                Producto p = lista.get(i);

                lista.get(i).cantidad = nuevaCantidad;
                System.out.println(p.codigo + " Cantidad actualizada " + p.cantidad );
                return;


            }

        }
        System.out.println(" No se encotro este codigo ");

    }




}
