/**
 * Created by haoyuguo on 23/05/2017.
 */
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
public class DBCollection {
    static Connection  conn=null;
    private static String username="root";
    private static String password="";//默认设置的密码为空
    private static String driverClassName="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/test";
    public Connection getConnection(){
        try{
            Class.forName(driverClassName);
            conn=DriverManager.getConnection(url,username,password);
            //System.out.println("cg");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConnection() throws SQLException{
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
