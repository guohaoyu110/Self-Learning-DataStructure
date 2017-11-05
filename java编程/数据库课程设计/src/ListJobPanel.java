/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import java.util.*;
public class ListJobPanel extends JPanel
{
    public ListJobPanel()
    {
        try{
            String names1[]={"员工编号","职务名称","部门名称"};
            String sqlString=new String("select * from 职务信息");
            JobManager jobManager=new JobManager();
            List<职务信息>list=jobManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append(" ");
            for(int i=0;i<names1.length;i++)
            {
                results.append(names1[i]+"\t\t");
            }
            results.append("\n");
            for(int i=0;i<list.size();i++)
            {
                results.append(" ");
                results.append(list.get(i).getID()+"\t\t");
                results.append(list.get(i).getD_NAME()+"\t\t");
                results.append(list.get(i).getJ_NAME()+"\t\t");
                if(i!=list.size())
                    results.append("\n");
            }
            JTextArea textArea=new JTextArea(results.toString());
            this.add(new JScrollPane(textArea));
            setSize(300,300);
        }
        catch(SQLException sqlException)
        {
            JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
