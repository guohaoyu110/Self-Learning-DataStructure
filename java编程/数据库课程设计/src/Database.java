/**
 * Created by haoyuguo on 17/06/2017.
 */
import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JOptionPane;
public class Database{
    static Connection conn=null;
    private static String username="root";
    private static String password="";
    private static String driverClassName="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/Company";
    public Connection getConnection(){
        try{
            Class.forName(driverClassName);
            conn=DriverManager.getConnection(url,username,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConnection()throws SQLException{
        if(conn!=null){
            try{
                conn.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}