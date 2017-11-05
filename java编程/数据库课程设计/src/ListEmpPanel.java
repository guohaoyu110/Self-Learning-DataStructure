/**
 * Created by haoyuguo on 29/06/2017.
 */
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.List;
public class ListEmpPanel extends JPanel
{
    public ListEmpPanel()
    {
    try {
        String names1[] = {"员工编号", "员工姓名", "性  别", "工  龄", "年  龄","状  态","学  历","政治面貌"};
        String sqlString = new String("select * from 员工信息");
        EmployManager employManager = new EmployManager();
        List<员工信息> list = employManager.Query(sqlString);
        StringBuffer results = new StringBuffer();
        results.append(" ");
        for (int i = 0; i < names1.length; i++) {
            results.append(names1[i] + "\t");
        }
        results.append("\n");
        for (int i = 0; i < list.size(); i++) {
            results.append(" ");
            results.append(list.get(i).getID() + "\t");
            results.append(list.get(i).getE_NAME() + "\t");
            results.append(list.get(i).getE_SEX() + "\t");
            results.append(list.get(i).getE_DATE() + "\t");
            results.append(list.get(i).getE_BIRTH() + "\t");
            results.append(list.get(i).getE_CONDITION()+"\t");
            results.append(list.get(i).getE_EDUCATION()+"\t");
            results.append(list.get(i).getE_POLITICS()+"\t");

            if (i != list.size() - 1) {
                results.append("\n");
            }

            //setSize(300, 300);
        }
        JTextArea textArea = new JTextArea(results.toString());
        this.add(new JScrollPane(textArea));
    }
        catch(SQLException sqlException)
    {
        JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
    }
}
}
