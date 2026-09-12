package tiendaVirtual;

import java.sql.*;
import java.util.Scanner;

public class tienda{
    public static void main (String[] args){

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
                System.out.println("Escribe una opcion: ");
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
                    actualizarProducto (conexion,leer);
                    break;
                case 5:
                    eliminarProducto (conexion, leer);
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
               int id = rs.getInt("id");
               String producto = rs.getString("producto");
               String marca = rs.getString("marca");
               String talla = rs.getString("talla");
               String color = rs.getString("color");
               double precio = rs.getDouble("precio");


               Producto p = new Producto(id,producto,marca,talla,color,precio);
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
        System.out.println("ID del producto a buscar: ");
        String IdBuscar = leer.nextLine();

        boolean encontrado = false;

        String sql = "SELECT * FROM productos  WHERE id = ?";


        try {

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1,IdBuscar);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()){
                int id = rs.getInt("id");
                String producto = rs.getString("Producto");
                String marca = rs.getString("Marca");
                String talla = rs.getString("Talla");
                String color = rs.getString("Color");
                double precio = rs.getDouble("Precio");


                Producto p = new Producto(id, producto,marca,talla,color,precio);
                    p.mostrarProductos();
                    encontrado = true;

            }
            if (!encontrado){
                System.out.println("No se encontro el producto buscado");
            }


        }catch (Exception e){
            System.out.println("Error al buscar prodcuto " + e.getMessage());

        }

    }

    public static void actualizarProducto(Connection conexion, Scanner leer){
        System.out.println("ID del producto a buscar: ");
        int IdActualizar = leer.nextInt();
        leer.nextLine();





        System.out.println("¿Qué desea actualizar?");
        System.out.println("1. Producto");
        System.out.println("2. Marca");
        System.out.println("3. Talla");
        System.out.println("4. Color");
        System.out.println("5. Precio");

        int opcionActualizar = leer.nextInt();
        leer.nextLine();


        try {
            String sql = "";

            switch (opcionActualizar){
                case 1:
                    sql = "UPDATE productos SET producto = ? WHERE id = ?";
                    break;

                case 2:
                    sql = "UPDATE productos SET marca = ? WHERE id = ?";
                    break;

                case 3:
                    sql = "UPDATE productos SET talla = ? WHERE id = ?";
                    break;

                case 4:
                    sql = "UPDATE productos SET color = ? WHERE id = ?";
                    break;


                case 5:
                    sql = "UPDATE productos SET precio = ? WHERE id = ?";
                    break;
            }




            PreparedStatement stmt = conexion.prepareStatement(sql);


            switch (opcionActualizar){

                case 1:
                    System.out.println("Nuevo producto: ");
                    String nuevoProducto = leer.nextLine();
                    stmt.setString(1,nuevoProducto);
                    break;

                case 2:
                    System.out.println("Nueva marca: ");
                    String nuevaMarca = leer.nextLine();
                    stmt.setString(1,nuevaMarca);
                    break;

                case 3:
                    System.out.println("Nueva talla: ");
                    String nuevaTalla = leer.nextLine();
                    stmt.setString(1,nuevaTalla);
                    break;

                case 4:
                    System.out.println("Nuevo color: ");
                    String nuevoColor = leer.nextLine();
                    stmt.setString(1,nuevoColor);
                    break;

                case 5:
                    System.out.println("Nuevo precio: ");
                    double nuevoPrecio = leer.nextDouble();
                    stmt.setDouble(1,nuevoPrecio);
                    break;

            }

            stmt.setInt(2,IdActualizar);

            int filaAfectadas = stmt.executeUpdate();

            if (filaAfectadas > 0){
                System.out.println("Producto actualizado correctamente");
            }else{
                System.out.println("Producto no existe");
            }






        } catch (Exception e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());

        }









    }

    public static void eliminarProducto (Connection conexion, Scanner leer) {
        System.out.println("ID del producto a eliminar: ");
        int IdEliminar = leer.nextInt();
        leer.nextLine();


        String sql = "DELETE FROM productos WHERE id = ?";

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, IdEliminar);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado correctamente.");

            } else {
                System.out.println("Producto no encontrado ");
            }


        } catch (Exception e) {
            if (e.getMessage().contains("foreign key constraint")) {
                System.out.println("No se puede eliminar: este producto tiene ventas registradas.");
            } else {
                System.out.println("Error al eliminar producto: " + e.getMessage());
            }
        }


    }

}
