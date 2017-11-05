/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class PXManager extends Database
{
    private Connection conn=null;
    public PXManager()
    {
        conn=getConnection();
    }
    public int execUpdate(String sql)throws SQLException
    {
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
        finally{
            if(statement!=null)
                statement.close();
            closeConnection();
        }
        return result;
    }
    public List<培训信息>Query(String sqlString)throws SQLException
    {
        List<培训信息>list=new ArrayList<培训信息>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next())
            {
                培训信息 m=new 培训信息();
                m.setID(rs.getString("ID"));
                m.setPX_ID(rs.getString("PX_ID"));
                m.setPX_DATE(rs.getString("PX_DATE"));
                m.setPX_DEST(rs.getString("PX_DEST"));
                m.setPX_REASON(rs.getString("PX_REASON"));
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
