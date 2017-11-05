/**
 * Created by haoyuguo on 24/05/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddStudentPanel extends JPanel{
    private JButton clearButton,writeButton;
    private StudentUI userInterface;//定义一个StudentUI类
    String names1[]={"学 号","姓 名","性 别","年 龄","爱 好"};
    //set up GUI
    public AddStudentPanel(){
        setLayout(new BorderLayout());
        userInterface=new StudentUI(names1);
        this.add(userInterface,BorderLayout.NORTH);
        writeButton=userInterface.getDoTask1Button();
        writeButton.setText("保存");
        writeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String fieldValues[]=userInterface.getFieldValues();
                        if(!fieldValues[StudentUI.SNO].equals("")){
                            try{
                                int numberAge=Integer.parseInt(fieldValues[StudentUI.SAGE]);
                                String sqlString="INSERT INTO student VALUES('"+fieldValues[0]+"','"+fieldValues[1]+"','"
                                       +fieldValues[2]+"',"+numberAge+",'"+fieldValues[4]+"');";
                                StudentManager studentManager=new StudentManager();
                                int result=studentManager.execUpdate(sqlString);
                                if(result!=0){
                                    userInterface.clearFields();
                                    JOptionPane.showMessageDialog(AddStudentPanel.this,"Inserted success！",
                                            "Insert Result",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }catch(NumberFormatException formatException){
                                JOptionPane.showMessageDialog(AddStudentPanel.this,"Bad age number",
                                       "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
                            }
                            catch(SQLException ee){
                                System.out.println(ee);
                            }
                        }
                        else
                            JOptionPane.showMessageDialog(AddStudentPanel.this,"Bad sno number","student number is empty!",
                                    JOptionPane.ERROR_MESSAGE);

                    }
                }
        );
        Icon bug=new ImageIcon(getClass().getResource("AC米兰.jpg"));
        JLabel label2=new JLabel("照片",bug,SwingConstants.LEFT);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.add(label2);
        clearButton=userInterface.getDoTask2Button();
        clearButton.setText("清除");
        clearButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userInterface.clearFields();
                    }
                }
        );

    }
}
