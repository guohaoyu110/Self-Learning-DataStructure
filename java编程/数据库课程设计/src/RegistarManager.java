/**
 * Created by haoyuguo on 25/06/2017.
 */
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class RegistarManager extends Database
{
    private Connection conn=null;
    public RegistarManager()
    {
        conn=getConnection();
    }
    //对RegistarManager进行插入，修改，删除操作
    public int execUpdate(String sql)throws SQLException{
        int result=0;
        Statement statement=null;
        try{
            statement=conn.createStatement();
            result=statement.executeUpdate(sql);
        }
        catch(SQLException e){
            System.out.println(e);
        }finally{
            if(statement!=null)
                statement.close();
            closeConnection();
        }
        return result;
    }
    public List<登录信息>Query(String sqlString) throws SQLException
    {
        List<登录信息>list=new ArrayList<登录信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement =conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next())
            {
                登录信息 m=new 登录信息();
                m.setID(rs.getString("ID"));
                m.setPASSWORD(rs.getString("PASSWORD"));
                m.setINDEX(rs.getInt("INDEX"));
                list.add(m);
            }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            if(statement!=null)
                statement.close();
            if(rs!=null)
                rs.close();
            closeConnection();
        }
        return list;
    }
}
