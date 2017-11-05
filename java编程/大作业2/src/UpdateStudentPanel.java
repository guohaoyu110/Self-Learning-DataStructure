import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
public class UpdateStudentPanel extends JPanel{
    private StudentUI userInterface1,userInterface2;
    private JButton firstButton1,secondButton1,firstButton2,secondButton2;
    String snoUpdate;
  //  String sqlString;
    public UpdateStudentPanel(){
        String names1[]={"请输入要修改的学生的学号:"};
        userInterface1=new StudentUI(names1);
        String names2[]={"学 号","姓 名","性 别","年 龄","爱 好"};
        userInterface2=new StudentUI(names2);
        this.setLayout(new FlowLayout());
        Box box=Box.createVerticalBox();
        box.add(userInterface1);
        box.add(userInterface2);
        this.add(box);
        firstButton1=userInterface1.getDoTask1Button();
        firstButton1.setText("确认");
        firstButton1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DisplayRecord();
                    }
                }
        );
        secondButton1=userInterface1.getDoTask2Button();
        secondButton1.setText("清除去");
        secondButton1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userInterface1.clearFields();
                    }
                }
        );
        firstButton2=userInterface2.getDoTask1Button();
        firstButton2.setText("确认修改");
        firstButton2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();
                    }
                }
        );
        secondButton2=userInterface2.getDoTask2Button();
        secondButton2.setText("放弃");
        secondButton2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userInterface2.clearFields();
                    }
                }
        );
        setSize(400,260);
        setVisible(true);
    }
    public void DisplayRecord(){
        String fieldValues1[]=userInterface1.getFieldValues();
        String fieldValues2[]=new String[5];
        if(!fieldValues1[StudentUI.SNO].equals("")){
            snoUpdate=fieldValues1[0];
            try{
                String sqlString="selct * from student"+"where sno="+fieldValues1[0]+"'";
                StudentManager studentManager=new StudentManager();
                List<Student>list=studentManager.Query(sqlString);
                if(list.size()!=0)
                {
                    fieldValues2[0]=list.get(0).getSno();
                    fieldValues2[1]=list.get(0).getSname();
                    fieldValues2[2]=list.get(0).getSsex();
                    fieldValues2[3]=String.valueOf(list.get(0).getSage());
                    fieldValues2[4]=list.get(0).getHobby();
                    userInterface2.setFieldValue(fieldValues2);
                }
                else {
                    userInterface2.clearFields();
                    JOptionPane.showMessageDialog(UpdateStudentPanel.this,"Not found this record"
                    ,"Find Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception ee){
                System.out.println(ee);
            }
        }
        else JOptionPane.showMessageDialog(this,"Bad snno number","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
    }
    public void UpdateRecord(){
        String fieldValues[]=userInterface2.getFieldValues();
        if(!fieldValues[StudentUI.SNO].equals("")){
            try{
                int numberAge=Integer.parseInt(fieldValues[StudentUI.SAGE]);
                String sqlString="Update student set"+"sno="+fieldValues[0]+","+"sname="+fieldValues[1]+
                        ","+"ssex="+fieldValues[2]+","+"sage="+numberAge+","+"sdept"+fieldValues[4]+
                        "where sno="+snoUpdate+"";
                System.out.println(sqlString);
                StudentManager studentManager=new StudentManager();
                int result=studentManager.execUpdate(sqlString);
                if(result!=0){
                    JOptionPane.showMessageDialog(this,"Updated success!","Update Result",
                           JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException formatException){
                JOptionPane.showMessageDialog(this,"Bad age number","Invalid Number Format",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException ee){
                System.out.println(ee);
            }
        }
        else //if no field value is empty
        JOptionPane.showMessageDialog(this,"Bad sno number","Invalid Number Format",
                JOptionPane.ERROR_MESSAGE);
    }
}
