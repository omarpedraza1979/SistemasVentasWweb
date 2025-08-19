
package Config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    
    Connection con;
    public Connection Conexion(){
        try {
            
            System.err.println("INICIANDO CONEXION");
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ventas","root","");            
            System.err.println("CONEXION A BD SUCCESSFULL");
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        return con; 
     }
    
}