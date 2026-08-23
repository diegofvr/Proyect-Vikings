package tiendaVirtual;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class tienda{
    public static void main (String[] args){

        ArrayList<Producto> listaProductos = new ArrayList<>();
        Scanner leer = new Scanner(System.in);


        int opcion = 0;

        do {
            System.out.println("Bienvenido a Vikings Store");
            System.out.println("¿Que desear hacer hoy?");
            System.out.println("1. Ingresar producto.");
            System.out.println("2. Ver productos.");
            System.out.println("3.Buscar producto");
            System.out.println("4. Actualizar productos.");
            System.out.println("5. Eliminar productos.");
            System.out.println("6. Salir");

            try {
                opcion = leer.nextInt();
                leer.nextLine();

            }catch (Exception e){
                System.out.println("Opcion no valida, ingrese un numero");
                leer.nextLine();
                opcion = 0;
                continue;

            }


            switch (opcion){
                case 1:
                    agregarProducto (listaProductos,leer);
                    break;
                case 2:
                    verProductos (listaProductos);





                    break;
                case 3:
                    buscarProducto (listaProductos,leer);
                    break;
                case 4:
                    actualizarProducto (listaProductos,leer);
                    break;
                case 5:
                    eliminarProducto (listaProductos, leer);
                    break;
                case 6:
                    System.out.println("Cerrando tienda...");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }


        }while (opcion != 6);

    }
    public static void agregarProducto(ArrayList<Producto> listaProductos, Scanner leer){
        System.out.println("--- Ingresar producto ---");

        System.out.println("Ingrese  producto: ");
        String producto = leer.nextLine();

        System.out.println("Marca: ");
        String marca = leer.nextLine();

        System.out.println("Talla: ");
        String talla = leer.nextLine();

        System.out.println("Color: ");
        String color = leer.nextLine();

        System.out.println("Precio: ");
        Double precio = leer.nextDouble();
        leer.nextLine();


        listaProductos.add(new Producto(producto,marca,talla,color,precio));
        System.out.println("El producto se ha agregado correctamente.");
    }

    public static void verProductos (ArrayList<Producto> listaProductos){
        if (listaProductos.isEmpty()){
            System.out.println("No hay productos");
            return;
        }
        System.out.println("Productos en Viking Store.");
        for (Producto p : listaProductos){
          p.mostrarProductos();
        }


    }

    public static void buscarProducto (ArrayList<Producto> listaProductos, Scanner leer){
        System.out.println("Nombre del producto a buscar: ");
        String Nombre = leer.nextLine();

        boolean encontrado = false;

        for (Producto p : listaProductos){


            if (p.getProducto().equalsIgnoreCase(Nombre)){
                p.mostrarProductos();
                encontrado = true;

            }

        }
        if (! encontrado){
            System.out.println("Producto no existe.");
        }





    }

    public static void actualizarProducto(ArrayList<Producto> listaProductos, Scanner leer){
        System.out.println("Nombre del producto a actualizar: ");
        String Nombre = leer.nextLine();

        boolean encontrado = false;

        for (Producto p : listaProductos){
            if (p.getProducto().equalsIgnoreCase(Nombre)){
                p.mostrarProductos();

                System.out.println("¿Qué desea actualizar?");
                System.out.println("1. Producto");
                System.out.println("2. Marca");
                System.out.println("3. Talla");
                System.out.println("4. Color");
                System.out.println("5. Precio");

                int opcionActualizar = leer.nextInt();
                leer.nextLine();

                switch (opcionActualizar){
                    case 1:
                        System.out.println("Nuevo nombre: ");
                        p.setProducto(leer.nextLine());
                        break;


                    case 2:
                        System.out.println("Nueva marca: ");
                        p.setMarca(leer.nextLine());
                        break;

                    case 3:
                        System.out.println("Nuevo color: ");
                        p.setColor(leer.nextLine());
                        break;

                    case 4:
                        System.out.println("Nueva talla: ");
                        p.setTalla(leer.nextLine());
                        break;

                    case 5:
                        System.out.println("Nuevo precio: ");
                        p.setPrecio(leer.nextDouble());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

                encontrado = true;
                System.out.println("Producto actualizado correctamente.");


            }
        }
        if (!encontrado){
            System.out.println("Producto no existe");
        }




    }

    public static void eliminarProducto (ArrayList<Producto> listaProductos, Scanner leer){
        System.out.println("Nombre del producto a eliminar ");
        String nombreEliminar = leer.nextLine();

        boolean encontrado = false;

        for (Producto p : listaProductos){
            if (p.getProducto().equalsIgnoreCase(nombreEliminar)){
                listaProductos.remove(p);
                encontrado = true;
                break;

            }

        }
        if (! encontrado){
            System.out.println("Producto no encontrado");
        }

    }




}
