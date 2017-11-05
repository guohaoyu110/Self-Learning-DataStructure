/**
 * Created by haoyuguo on 29/06/2017.
 */
//这个是管理员看到的界面
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.List;

public class ListWagePanel extends JPanel
{
    public ListWagePanel()
    {
        try{
            String names1[]={"员工编号","时  间","基本工资","奖  金"};
            String sqlString=new String("select * from 薪资信息 ");
            SalaryManager salaryManager=new SalaryManager();
            List<薪资信息>list=salaryManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append(" ");
            for(int i=0;i<names1.length;i++)
            {
                results.append(names1[i]+"\t");
            }
            results.append("\n");
            for(int i=0;i<names1.length;i++)
            {
                results.append(" ");
                results.append(list.get(i).getID()+"\t");
                results.append(list.get(i).getSEASON()+"\t");
                results.append(list.get(i).getBasic_pay()+"\t");
                results.append(list.get(i).getBonus()+"\t");
                if(i!=list.size()-1)
                {
                    results.append("\n");
                }
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
