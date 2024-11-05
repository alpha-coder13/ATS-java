package src.bms.connection;
import java.sql.*;

public class Connect {
    Connection c;
    public Statement s;
    public Connect(){
        try{
            // registering the driver
            c = DriverManager.getConnection("jdbc:mysql:///bms","root","1969");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
