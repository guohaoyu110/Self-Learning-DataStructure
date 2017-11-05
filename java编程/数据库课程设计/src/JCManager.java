/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JCManager extends Database
{
    private Connection conn=null;//构造方法中完成打开数据库连接
    public JCManager()
    {
        conn=getConnection();
    }
    public int execUpdte(String sql)throws SQLException{
        int result=0;
        Statement statement=null;
        try{
            statement=conn.createStatement();
            result=statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
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
    public List<奖惩信息>Query(String sqlString) throws SQLException
    {
        List<奖惩信息>list=new ArrayList<奖惩信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next())
            {
                奖惩信息 m=new 奖惩信息();
                m.setID(rs.getString("ID"));
                m.setJC_ID(rs.getString("JC_ID"));
                m.setJC_DATE(rs.getString("JC_DATE"));
                m.setJC_REASON(rs.getString("JC_REASON"));
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
