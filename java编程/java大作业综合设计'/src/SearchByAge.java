import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
/**
 * Created by haoyuguo on 25/05/2017.
 */
public class SearchByAge extends JPanel{
    private StudentUI userInterface1;
    private JButton firstButton1,secondButton1;
    private int agesearch;
    private Box box1;
    public SearchByAge() {
        String names1[] = {"请输入要查找的年龄:"};
        userInterface1 = new StudentUI(names1);
        this.setLayout(new FlowLayout());
        box1 = Box.createVerticalBox();
        box1.add(userInterface1);
        this.add(box1);
        firstButton1 = userInterface1.getDoTask1Button();
        firstButton1.setText("确认");
        firstButton1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String names2[] = {"学 号","姓 名","性 别","年 龄","爱 好"};
                        String fieldValues1[]=userInterface1.getFieldValues();
                        // String fieldValues2[]=new String[5];
                        agesearch=Integer.parseInt(fieldValues1[0]);
                        if(!fieldValues1[0].equals("")){
                            try{
                                String sqlString="select * from student where sage="+agesearch+";";
                                StudentManager studentManager=new StudentManager();
                                List<Student>list=studentManager.Query(sqlString);
                                StringBuffer results=new StringBuffer();
                                results.append(" ");
                                for(int i=0;i<names2.length;i++)
                                {
                                    results.append(names2[i]+"\t");
                                }
                                results.append("\n");
                                if(list.size()!=0) {
                                    for (int i = 0; i < list.size(); i++) {
                                        results.append(" ");
                                        results.append(list.get(i).getSno() + "\t");
                                        results.append(list.get(i).getSname() + "\t");
                                        results.append(list.get(i).getSsex() + "\t");
                                        results.append(String.valueOf(list.get(i).getSage() + "\t"));
                                        results.append(list.get(i).getHobby() + "\t");
                                        if (i != list.size() - 1) {
                                            results.append("\n");
                                        }
                                        //remove(box1);
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(SearchByAge.this,
                                            "Not found this record!","Find Result",JOptionPane.INFORMATION_MESSAGE);
                                }
                                Box box2;
                                JTextArea textArea=new JTextArea(results.toString());
                                box2=Box.createVerticalBox();
                                box2.add(new JScrollPane(textArea));
                                add(box2);

                            }
                            catch(SQLException sqlException){
                                JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    }
                }
        );

        setSize(400,260);
        setVisible(true);
        secondButton1 = userInterface1.getDoTask2Button();
        secondButton1.setText("清除");
        secondButton1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userInterface1.clearFields();
                    }
                }
        );

    }
   // public void DisplayRecord(){}
}
