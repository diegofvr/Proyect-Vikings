package tiendaVirtual;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
        private static final String URL = "jdbc:mysql://localhost:3306/vikings_tienda";
        private static final String USUARIO = "root";
        private static final String CONTRASEÑA = "Nalacansona1";


        public static Connection obtenerConexion(){
            try {
                Connection conexion = DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
                System.out.println("Conexion exitosa a la base de datos");
                return conexion;
            } catch (Exception e){
                System.out.println("Error al conectar" + e.getMessage());
                return null;
            }
            }





}
