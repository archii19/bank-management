import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","bankcode1");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    
}
