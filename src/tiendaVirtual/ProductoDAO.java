package tiendaVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO {

    private Connection conexion;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregar(String producto, String marca, String talla, String color, double precio) {
        String sql = "INSERT INTO productos (producto,marca,talla,color,precio) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, producto);
            stmt.setString(2, marca);
            stmt.setString(3, talla);
            stmt.setString(4, color);
            stmt.setDouble(5, precio);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Producto> obtenerTodos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String producto = rs.getString("producto");
                String marca = rs.getString("marca");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                double precio = rs.getDouble("precio");

                productos.add(new Producto(id, producto, marca, talla, color, precio));
            }
        } catch (Exception e) {
            System.out.println("Error al consultar productos: " + e.getMessage());
        }
        return productos;
    }

    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String producto = rs.getString("producto");
                String marca = rs.getString("marca");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                double precio = rs.getDouble("precio");

                return new Producto(id, producto, marca, talla, color, precio);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(int id, int opcionActualizar, String nuevoValorTexto, double nuevoValorPrecio) {
        String sql = "";
        switch (opcionActualizar) {
            case 1: sql = "UPDATE productos SET producto = ? WHERE id = ?"; break;
            case 2: sql = "UPDATE productos SET marca = ? WHERE id = ?"; break;
            case 3: sql = "UPDATE productos SET talla = ? WHERE id = ?"; break;
            case 4: sql = "UPDATE productos SET color = ? WHERE id = ?"; break;
            case 5: sql = "UPDATE productos SET precio = ? WHERE id = ?"; break;
        }

        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);

            if (opcionActualizar == 5) {
                stmt.setDouble(1, nuevoValorPrecio);
            } else {
                stmt.setString(1, nuevoValorTexto);
            }
            stmt.setInt(2, id);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public String eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                return "OK";
            } else {
                return "NO_ENCONTRADO";
            }
        } catch (Exception e) {
            if (e.getMessage().contains("foreign key constraint")) {
                return "TIENE_VENTAS";
            }
            return "ERROR: " + e.getMessage();
        }
    }
}