import com.sun.jnlp.FileOpenServiceNSBImpl;
import javafx.beans.property.adapter.JavaBeanObjectProperty;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class JCInfo extends JPanel
{
    JLabel l1=new JLabel("奖 惩 信 息");
    JLabel l2=new JLabel("员工编号:           ");
    JLabel l3=new JLabel("奖惩编号:           ");
    JLabel l4=new JLabel("奖惩时间:           ");
    JLabel l5=new JLabel("奖惩原因:           ");
    JLabel l6=new JLabel("奖惩编号:    ");

    private JPanel p1,p2;
    JTextField textField1=new JTextField(10);
    JTextField textField2=new JTextField(10);
    JTextField textField3=new JTextField(10);
    JTextField textField4=new JTextField(10);
    JTextField textField5=new JTextField(10);


    JButton b1=new JButton("添加");
    JButton b2=new JButton("修改");
    JButton b3=new JButton("删除");
    JButton b4=new JButton("退出");
    JButton b5=new JButton("确定");
    JButton b6=new JButton("清除");
    //String value1,value2,value3,value4;
    public JCInfo()
    {
        p1=new JPanel(); p2=new JPanel();
        setLayout(new BorderLayout());
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createHorizontalBox();
        Box box0=Box.createVerticalBox();
        l1.setFont(new Font("宋体",Font.PLAIN,30));
        box1.add(l1);
        box2.add(l2); box2.add(textField1);
        box3.add(l3); box3.add(textField2);
        box4.add(l4); box4.add(textField3);
        box5.add(l5); box5.add(textField4);
        box6.add(b1); box6.add(b2); box6.add(b3); box6.add(b4);
        box0.add(box1); box0.add(Box.createVerticalStrut(20));
        box0.add(box2); box0.add(Box.createVerticalStrut(10));
        box0.add(box3); box0.add(Box.createVerticalStrut(10));
        box0.add(box4); box0.add(Box.createVerticalStrut(10));
        box0.add(box5); box0.add(Box.createVerticalStrut(20));
        box0.add(box6);
        p1.add(box0);

        //下面是第二个panel
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l6); box7.add(textField5);
        box8.add(b5); box8.add(b6);
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);

        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.validate();

        b5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConfirmRecord();
                    }
                }
        );

        b6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EliminateRecord();
                    }
                }
        );

        b1.addActionListener(//添加
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InsertRecord();
                    }
                }
        );
        b2.addActionListener(//修改
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();
                    }
                }
        );
        b3.addActionListener(//删除
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         DeleteRecord();
                    }
                }
        );
        b4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                         System.exit(0);
                    }
                }
        );
    }
    public void InsertRecord()
    {
         String value1,value2,value3,value4;
         value1=textField1.getText();
         value2=textField2.getText();
         value3=textField3.getText();
         value4=textField4.getText();
         if(!value1.equals("")) {
             try {
                 String sqlString = "Insert into 奖惩信息" + " values ('" + value1 + "','" + value2 + "','"
                         + value3 + "','" + value4 + "')";
                 System.out.println(sqlString);
                 JCManager jcManager=new JCManager();
                 int result = jcManager.execUpdte(sqlString);
                 if (result != 0) {
                     JOptionPane.showMessageDialog(this, "Inserted Success!", "Inserted Result", JOptionPane.INFORMATION_MESSAGE);
                 }

             } catch (NumberFormatException formatException) {
                 JOptionPane.showMessageDialog(this, "Input wrong message!",
                         "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
             }
             catch (SQLException ee) {
                 System.out.println(ee);
             }
         }
             else JOptionPane.showMessageDialog(this,"Input wrong message!","Invalid Number Format",
                 JOptionPane.ERROR_MESSAGE);

    }
    public void ConfirmRecord()
    {
        String value5=textField5.getText();
        if(!value5.equals(""))
        {
            try{
                String sqlString="select * from 奖惩信息 "+"where JC_ID='"+value5+"'";
                JCManager jcManager=new JCManager();
                List<奖惩信息>list=jcManager.Query(sqlString);
                if(list.size()!=0)
                {
                    String value1=list.get(0).getID();
                    String value2=list.get(0).getJC_ID();
                    String value3=list.get(0).getJC_DATE();
                    String value4=list.get(0).getJC_REASON();
                    JOptionPane.showMessageDialog(this,"存在这条记录","Valid Number Format",
                            JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(value1);
                    textField2.setText(value2);
                    textField3.setText(value3);
                    textField4.setText(value4);

                }
                else {
                    textField5.setText("");
                    JOptionPane.showMessageDialog(this,"不存在这条记录","Find Result",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Bad JC_ID Number","Invalid Number Format",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    public void DeleteRecord()
    {
        String value1,value2,value3,value4,value5;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        if(!value2.equals(""))
        {
            try
            {
                String sqlString="Delete from 奖惩信息 "+"where JC_ID='"+value2+"'";
                System.out.println(sqlString);
                JCManager jcManager=new JCManager();
                int result=jcManager.execUpdte(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Deleted Success!",
                            "Delete Result",JOptionPane.INFORMATION_MESSAGE);
                }

            }
            catch(NumberFormatException formatException)
            {
                JOptionPane.showMessageDialog(this,"Input wrong message!",
                        "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
        }
        else JOptionPane.showMessageDialog(this,"Bad PX_ID","Invalid Number Format",
                JOptionPane.ERROR_MESSAGE);

    }
    public void UpdateRecord()
    {
        String value1,value2,value3,value4,value5;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        if(!value2.equals("")) {
            try {
                String sqlString = "Update 奖惩信息 set " + "JC_DATE='" + value3 + "','" + "JC_REASON='"
                        + value4 + "' where JC_ID='" + value2 + "'";
                System.out.println(sqlString);
                JCManager jcManager = new JCManager();
                int result = jcManager.execUpdte(sqlString);
                if (result != 0) {
                    JOptionPane.showMessageDialog(this, "Updated Sccess!",
                            "Update Result", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException formatException) {
                JOptionPane.showMessageDialog(this, "Updated Success!",
                        "Update Result", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ee) {
                System.out.println(ee);
            }
        }
            else JOptionPane.showMessageDialog(this,"Bad JC_ID","Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
    public void EliminateRecord()
    {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
    }
}
