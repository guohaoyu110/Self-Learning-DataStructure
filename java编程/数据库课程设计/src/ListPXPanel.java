/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
public class ListPXPanel extends  JPanel
{
    public ListPXPanel()
    {
        try{
            String names1[]={"员工编号","培训编号","培训日期","培训地点","培训内容"};
            String sqlString=new String("select * from 培训信息");
            PXManager pxManager=new PXManager();
            List<培训信息>list=pxManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append(" ");
            for(int i=0;i<names1.length;i++)
            {
                results.append(names1[i]+"\t");
            }
            results.append("\n");
            for(int i=0;i<list.size();i++)
            {
                results.append(" ");
                results.append(list.get(i).getID()+"\t");
                results.append(list.get(i).getPX_ID()+"\t");
                results.append(list.get(i).getPX_DATE()+"\t");
                results.append(list.get(i).getPX_DEST()+"\t");
                results.append(list.get(i).getPX_REASON()+"\t");
                if(i!=list.size()-1)
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
