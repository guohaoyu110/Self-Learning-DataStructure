import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeptManager extends Database{
    private Connection conn=null;
    //构造方法中完成打开数据库的连接
    public DeptManager()
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
    public List<部门信息>Query(String sqlString)throws SQLException{
        List<部门信息>list=new ArrayList<部门信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next())
            {
                部门信息 m=new 部门信息();
                m.setNumber(rs.getInt("D_NUMBER"));
                m.setName(rs.getString("D_NAME"));
                m.setCount(rs.getInt("D_COUNT"));
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
