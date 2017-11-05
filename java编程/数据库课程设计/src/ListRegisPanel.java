/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
public class ListRegisPanel extends JPanel
{
    public ListRegisPanel()
    {
        try{
            String names1[]={"员工编号","密  码","权  限"};
            String sqlString=new String("select * from 登录信息");
            RegistarManager registarManager=new RegistarManager();
            List<登录信息>list=registarManager.Query(sqlString);
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
                results.append(list.get(i).getPASSWORD()+"\t");
                if(list.get(i).getINDEX()==1)
                {
                    results.append("用 户"+"\t");
                }
                else results.append("管理员"+"\t");
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
