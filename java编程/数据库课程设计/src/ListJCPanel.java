/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
public class ListJCPanel extends JPanel
{
    public ListJCPanel()
    {
        try{
            String names1[]={"员工编号","记录编号","记录时间","记录原因"};
            String sqlString=new String("select * from 奖惩信息");
            JCManager jcManager=new JCManager();
            List<奖惩信息>list=jcManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append("\t");
            for(int i=0;i<names1.length;i++)
            {
                results.append(names1[i]+"\t");
            }
            results.append("\n");
            for(int i=0;i<list.size();i++)
            {
                results.append("\t");
                results.append(list.get(i).getID()+"\t");
                results.append(list.get(i).getJC_ID()+"\t");
                results.append(list.get(i).getJC_DATE()+"\t");
                results.append(list.get(i).getJC_REASON()+"\t");
                if(i!=list.size()-1)
                    results.append("\n");
            }
            JTextArea textArea=new JTextArea(results.toString());
            this.add(new JScrollPane(textArea));
            //setSize(300,300);
        }
        catch(SQLException sqlException)
        {
            JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
