package src.bms.connection;
import java.sql.*;

public class Connect {
    Connection c;
    public Statement s;
    public Connect(){
        try{
            // registering the driver
            Keys K = new Keys();
            c = DriverManager.getConnection(K.url,K.usr,K.password);
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
