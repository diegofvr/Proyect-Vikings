package tiendaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class tienda{
    public static void main (String[] args){

        ArrayList<Producto> listaProductos = new ArrayList<>();
        Scanner leer = new Scanner(System.in);
        Connection conexion = Conexion.obtenerConexion();


        int opcion = 0;

        do {
            System.out.println("Bienvenido a Vikings Store");
            System.out.println("¿Que desear hacer hoy?");
            System.out.println("1. Ingresar producto.");
            System.out.println("2. Ver productos.");
            System.out.println("3. Buscar producto");
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
                    agregarProducto (conexion,leer);
                    break;
                case 2:
                    verProductos (conexion);





                    break;
                case 3:
                    buscarProducto (conexion,leer);
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
    public static void agregarProducto(Connection conexion,Scanner leer){
        System.out.println("--- Ingresar producto ---");

        System.out.println("Que producto quieres agregar: ");
        System.out.println("1.Camisa.");
        System.out.println("2.Pantalon.");
        System.out.println("3.Zapatos.");
        int tipoDeProducto = leer.nextInt();
        leer.nextLine();

        System.out.println("Marca: ");
        String marca = leer.nextLine();

        System.out.println("Talla: ");
        String talla = leer.nextLine();

        System.out.println("Color: ");
        String color = leer.nextLine();

        System.out.println("Precio: ");
        Double precio = leer.nextDouble();
        leer.nextLine();

        while (precio <= 0){
            System.out.println("No se aceptan valores negativos");
            precio = leer.nextDouble();
            leer.nextLine();
        }

        System.out.println("Tipo (Oversize, training, runnig...");
        String tipo = leer.nextLine();
        String producto = "";


        switch (tipoDeProducto){
            case 1:
                producto = "Camisa";
                break;
            case 2:
                producto = "Pantalon";
                break;
            case 3:
                producto = "Zapatos";
                break;

            default:
                System.out.println("Opcion no valida");
                return;

        }

        try{
            String sql = "INSERT INTO productos (producto,marca,talla,color,precio) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1,producto);
            stmt.setString(2,marca);
            stmt.setString(3,talla);
            stmt.setString(4,color);
            stmt.setDouble(5,precio);

            stmt.executeUpdate();

            System.out.println("Producto agregado correctamente.");



        } catch (Exception e){
            System.out.println("Error al agregar: " + e.getMessage());
        }





    }

    public static void verProductos (Connection conexion){

       String sql = "SELECT * FROM productos";

       try {
           PreparedStatement stmt = conexion.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();

           boolean hayProductos = false;

           while (rs.next()){
               String producto = rs.getString("producto");
               String marca = rs.getString("marca");
               String talla = rs.getString("talla");
               String color = rs.getString("color");
               double precio = rs.getDouble("precio");


               Producto p = new Producto(producto,marca,talla,color,precio);
               p.mostrarProductos();

               hayProductos = true;


               }
               if (!hayProductos){
                   System.out.println("No hay productos");

           }


       }catch (Exception e){
        System.out.println("Error al consultar productos: " + e.getMessage());
    }

    }

    public static void buscarProducto (Connection conexion, Scanner leer){
        System.out.println("Nombre del producto a buscar: ");
        String Nombre = leer.nextLine();

        boolean encontrado = false;

        String sql = "SELECT * FROM productos WHERE productos = ?";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1,Nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                String producto = rs.getString("producto");
                String marca = rs.getString("marca");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                double precio = rs.getDouble("precio");


                encontrado = true;

                Producto p = new Producto(producto, marca, talla, color, precio);
                p.mostrarProductos();


            }
            if (!encontrado){
                System.out.println("No se encontro el producto buscado");
            }


        } catch (SQLException e) {
            System.out.println("Error al buscar el producto: " + e.getMessage());

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
