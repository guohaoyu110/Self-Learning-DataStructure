/**
 * Created by haoyuguo on 24/05/2017.
 */
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ListStudentsPanel extends JPanel{
    public ListStudentsPanel(){
        try{
            String names2[]={"学 号","姓 名","性 别","年 龄","爱 好"};
            String sqlString=new String("select sno,sname,ssex,sage,hobby from student");
            StudentManager studentManager=new StudentManager();
            List<Student>list=studentManager.Query(sqlString);
            StringBuffer results=new StringBuffer();
            results.append(" ");
            for(int i=0;i<names2.length;i++){
                results.append(names2[i]+"\t");
            }

            results.append("\n");
            for(int i=0;i<list.size();i++)
            {
                results.append(" ");
                results.append(list.get(i).getSno()+"\t");
                results.append(list.get(i).getSname()+"\t");
                results.append(list.get(i).getSsex()+"\t");
                results.append(String.valueOf(list.get(i).getSage()+"\t"));
                results.append(list.get(i).getHobby()+"\t");
                if(i!=list.size()-1){
                    results.append("\n");
                }
            }

                JTextArea textArea=new JTextArea(results.toString());
                this.add(new JScrollPane(textArea));
            Icon bug=new ImageIcon(getClass().getResource("AC米兰.jpg"));
            JLabel label2=new JLabel("照片",bug,SwingConstants.LEFT);
            label2.setHorizontalTextPosition(SwingConstants.CENTER);
            label2.setVerticalTextPosition(SwingConstants.BOTTOM);
            this.add(label2);
                setSize(300,100);

        }
        catch(SQLException sqlException)
        {
            JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
