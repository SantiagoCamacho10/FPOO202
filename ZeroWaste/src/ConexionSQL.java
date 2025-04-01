import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/zerowaste?serverTimezone=UTC"; //cuida el nombre de la BD
    private static final String USUARIO = "root"; // Cambia esto si tienes otro usuario
    private static final String CONTRASENA = "root"; // Pon tu contraseña aquí en workbeach

    public static Connection conectar() {
        
        Connection conex = null;
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
            conex = DriverManager.getConnection(URL, USUARIO, CONTRASENA);  //Intenta conectarse a la base de datos usando los parámetros proporcionados.
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("🚨 Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
        return conex;
    }
}