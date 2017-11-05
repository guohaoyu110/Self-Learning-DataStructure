/**
 * Created by haoyuguo on 23/06/2017.
 */
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryManager extends Database{
    private Connection conn=null;
    //构造方法中完成打开数据库的连接
    public SalaryManager()
    {
        conn=getConnection();
    }

    //对部门信息表进行增删改查操作
    public int execUpdate(String sql) throws SQLException
    {
        int result=0;
        Statement statement=null;
        try{
            statement=conn.createStatement();
            result=statement.executeUpdate(sql);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally
        {
            if(statement!=null)
                statement.close();
            closeConnection();
        }
        return result;
    }
    public  List<薪资信息>Query(String sqlString)throws SQLException{
        List<薪资信息>list=new ArrayList<薪资信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next())
            {
                薪资信息 m=new 薪资信息();
                m.setID(rs.getString("ID"));
                m.setBasic_pay(rs.getInt("BASIC_PAY"));
                m.setBonus(rs.getInt("BONUS"));
                m.setSEASON(rs.getString("SEASON"));
                list.add(m);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        finally {
            if(statement!=null)
                statement.close();
            if(rs!=null)
                rs.close();
            closeConnection();
        }
        return list;
    }

}
