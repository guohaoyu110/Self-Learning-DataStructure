import java.sql.*;
public class Main {
    public static void main(String[] args){
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        String sql = null;
        String url = new String("jdbc:mysql://localhost:3306/database_01?characterEncoding=utf8&useSSL=false");
        try{
            System.out.println("*");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","123456");
            sta = con.createStatement();
            sql = new String("select * from student");
            res = sta.executeQuery(sql);
            System.out.println("name     sex     age");
            while(res.next()){
                System.out.print(res.getString("name"));
                System.out.print("     ");
                System.out.print(res.getString("sex"));
                System.out.print("     ");
                System.out.print(res.getString("age") + "\n");
            }
        }catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException");

        }catch (SQLException a){
            System.out.println("SQLException");
        }
        catch (Exception b){

        }
        finally {
            try{
                if(con != null)
                    con.close();
                if (sta != null)
                    sta.close();
                if(res != null)
                    res.close();
            }catch (Exception e){

            }
        }
    }
}
