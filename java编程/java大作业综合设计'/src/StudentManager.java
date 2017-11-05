/**
 * Created by haoyuguo on 23/05/2017.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentManager extends DBCollection {
    private Connection conn=null;
    /*String sqlString="INSERT INTO student VALUES('2001','张红','女',22,'足球')";
    StudentManager studentManager=new StudentManager();
    int result=studentManager.execUpdate(sqlString);*/
    //DBCollection A= new DBCollection();
    public  StudentManager(){

        conn=getConnection();
    }
    public int execUpdate(String sql)throws SQLException{
        int result=0;
        Statement statement=null;
        try{
            statement=conn.createStatement();
            result=statement.executeUpdate(sql);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            if(statement!=null){
                statement.close();
            }
            closeConnection();
        }
        return result;
    }
    public List<Student>Query(String sqlString) throws SQLException{
        List<Student>list=new ArrayList<Student>();
        Statement statement=null;
        ResultSet rs=null;
        try{
            statement=conn.createStatement();
            rs=statement.executeQuery(sqlString);
            while(rs.next()){
                Student m=new Student();
                m.setSno(rs.getString("sno"));
                m.setSname(rs.getString("sname"));
                m.setSsex(rs.getString("ssex"));
                m.setSage(rs.getInt("sage"));
                m.setHobby(rs.getString("hobby"));
                list.add(m);
            }
        }
        catch(SQLException e){
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
