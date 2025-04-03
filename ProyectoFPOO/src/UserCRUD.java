import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class UserCRUD {
     private Connection conexion;
     
     public UserCRUD(){
        conexion=ConexionMySQL.conectar();
    }
}
