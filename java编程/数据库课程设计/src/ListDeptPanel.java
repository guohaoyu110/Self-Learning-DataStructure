/**
 * Created by haoyuguo on 29/06/2017.
 */
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.List;
import java.util.*;
public class ListDeptPanel extends JPanel
{
    public ListDeptPanel()
    {
        try{
            String names1[]={"部门编号","部门名称","部门人数"};

            String sqlString=new String("select * from 部门信息");
            DeptManager deptManager=new DeptManager();
            List<部门信息>list=deptManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append(" ");
            for(int i=0;i<names1.length;i++)
            {
                results.append(names1[i]+"\t\t");
            }
            results.append("\n");
            for(int i=0;i<list.size();i++)
            {
                results.append("");
                results.append(list.get(i).getNumber()+"\t\t");
                results.append(list.get(i).getName()+"\t\t");
                results.append(list.get(i).getCount()+"\t\t");
                if(i!=list.size()-1){
                    results.append("\n");
                }
            }
            JTextArea textArea=new JTextArea(results.toString());
            //textArea.setBounds(0,0,300,300);
            this.add(new JScrollPane(textArea));

        }
        catch(SQLException sqlException)
        {
            JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
