import javafx.scene.chart.PieChart;

/**
 * Created by haoyuguo on 24/06/2017.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployManager extends Database {
    private Connection conn=null;
    public EmployManager()
    {
        conn=getConnection();
    }
    public int execUpdate(String sql)throws SQLException{
        int result=0;
        Statement statement=null;
        try{
            statement=conn.createStatement();
            result=statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {System.out.println(e);}
        finally
        {
            if(statement!=null)
                statement.close();
            closeConnection();
        }
        return result;
    }
    //对员工信息表进行查询，并以List结构返回结果，并及时关闭数据库连接

    public List<员工信息>Query(String sqlString)throws SQLException
    {
        List<员工信息>list=new ArrayList<员工信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next()){
                员工信息 m=new 员工信息();
                m.setID(rs.getString("ID"));
                m.setE_NAME(rs.getString("E_NAME"));
                m.setE_SEX(rs.getString("E_SEX"));
                m.setE_DATE(rs.getInt("E_DATE"));
                m.setE_BIRTH(rs.getInt("E_BIRTH"));
                m.setE_CONDITION(rs.getString("E_CONDITION"));
                m.setE_EDUCATION(rs.getString("E_EDUCATION"));
                m.setE_POLITICS(rs.getString("E_POLITICS"));
               // m.setD_NAME(rs.getString("D_NAME"));
                list.add(m);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally{
            if(statement!=null)
                statement.close();
            if(rs!=null)
                rs.close();
            closeConnection();
        }
        return list;
    }

}
