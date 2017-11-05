/**
 * Created by haoyuguo on 24/06/2017.
 */
import com.sun.codemodel.internal.JOp;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.util.List;

//这张是员工基本信息管理表
public class EmployeeInfo extends JPanel{
    private JLabel l0=new JLabel("员工基本信息管理");
    private JLabel l1=new JLabel("员工编号");
    private JLabel l2=new JLabel("姓名");
    private JLabel l3=new JLabel("性别");
    private JLabel l4=new JLabel("工龄");
    private JLabel l5=new JLabel("年龄");
    private JLabel l6=new JLabel("状态");
    private JLabel l7=new JLabel("学历");
    private JLabel l8=new JLabel("政治面貌");
    private JLabel l9=new JLabel("员工编号:   ");
    private JPanel p1,p2;
    private JButton button1,button2,button3,button4,button5,button6;
    //private String names1[]={"总部","营业部","财务部","研发部","营销部","生产部","公关部"};
    private String names2[]={"男","女"};
    private String names3[]={"在职","离职","退休","请假"};
    private String names4[]={"高中","本科","研究生","其他"};
    private String names5[]={"共产党员","共青团员","群众"};
    private JComboBox c1,c3,c4,c5;
    public JTextField textField1,textField2,textField3,textField4,textField5,textField6;
    public EmployeeInfo()
    {
        p1=new JPanel();p2=new JPanel();
        setLayout(new BorderLayout());
        l0.setFont(new Font("宋体",Font.PLAIN,30));
        /*l1.setFont(new Font("宋体",Font.PLAIN,20));
        l2.setFont(new Font("宋体",Font.PLAIN,20));
        l3.setFont(new Font("宋体",Font.PLAIN,20));
        l4.setFont(new Font("宋体",Font.PLAIN,20));
        l5.setFont(new Font("宋体",Font.PLAIN,20));
        l6.setFont(new Font("宋体",Font.PLAIN,20));
        l7.setFont(new Font("宋体",Font.PLAIN,20));
        l8.setFont(new Font("宋体",Font.PLAIN,20));*/
        //setFont(new Font("宋体",Font.PLAIN,30));
        textField1=new JTextField(10);
        textField2=new JTextField(10);
        textField3=new JTextField(10);
        textField4=new JTextField(10);
        textField5=new JTextField(10);
        textField6=new JTextField(10);
        c1=new JComboBox(names2);
        //c2=new JComboBox(names1);
        c3=new JComboBox(names3);
        c4=new JComboBox(names4);
        c5=new JComboBox(names5);
        button1=new JButton("添加");
        button2=new JButton("修改");
        button3=new JButton("删除");
        button4=new JButton("退出");
        button5=new JButton("确定");
        button6=new JButton("清除");
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box0=Box.createVerticalBox();
        box1.add(l0);
        box2.add(l1); box2.add(textField1); box2.add(l2); box2.add(textField2);
        box3.add(l3); box3.add(c1); box3.add(l4); box3.add(textField3); box3.add(l6);box3.add(c3);
        box4.add(l5); box4.add(textField4); box4.add(l7); box4.add(c4); box4.add(l8); box4.add(c5);
        box5.add(button1); box5.add(button2); box5.add(button3); box5.add(button4);

        box0.add(box1); box0.add(Box.createVerticalStrut(30));
        box0.add(box2); box0.add(Box.createVerticalStrut(20));
        box0.add(box3); box0.add(Box.createVerticalStrut(20));
        box0.add(box4); box0.add(Box.createVerticalStrut(30));
        box0.add(box5);
        p1.add(box0);

        //下面是第二个panel
        Box box6=Box.createHorizontalBox();
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createVerticalBox();
        box6.add(l9); box6.add(textField6);
        box7.add(button5); box7.add(button6);
        box8.add(box6); box8.add(Box.createVerticalStrut(10));
        box8.add(box7);
        p2.add(box8);

        button5.addActionListener(//确定
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConfirmRecord();
                    }
                }
        );

        button6.addActionListener(//清除
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EliminateRecord();
                    }
                }
        );

        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.validate();

        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InsertRecord();
                    }
                }
        );
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();
                    }
                }
        );
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeleteRecord();
                    }
                }
        );
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);

                    }
                }
        );
        //this.setSize(500,400);
        //this.setVisible(true);
    }
    public void InsertRecord()
    {
        String value1;String value2;String value3;int value4;int value5;String value6;
        String value7;String value8;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=c1.getSelectedItem().toString();
        value4=Integer.valueOf(textField3.getText());
        value5=Integer.valueOf(textField4.getText());
        value6=c3.getSelectedItem().toString();
        value7=c4.getSelectedItem().toString();
        value8=c5.getSelectedItem().toString();
        if(!value1.equals(""))
        {
            try{
                String sqlString="Insert into 员工信息 "+"values ('"+value1+"','"+value2+"','"+value3+"',"+value4+","+value5+",'"+value6+"','"+value7+"','"+value8+"')";
                System.out.println(sqlString);
                EmployManager employManager=new EmployManager();
                int result=employManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Inserted Success!","Inserte Result",
                            JOptionPane.INFORMATION_MESSAGE);
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
        else JOptionPane.showMessageDialog(this,"Input wrong message!","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
    }
    public void UpdateRecord()
    {
        String value1;String value2;String value3;int value4;int value5;String value6;String value7,value8;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=c1.getSelectedItem().toString();
        value4=Integer.valueOf(textField3.getText());
        value5=Integer.valueOf(textField4.getText());
        value6=c3.getSelectedItem().toString();
        value7=c4.getSelectedItem().toString();
        value8=c5.getSelectedItem().toString();

        if(!value1.equals(""))
        {
            try{
                String sqlString="Update 员工信息 set "+"E_NAME='"+value2+"',"+"E_SEX='"+value3+"',"+
                        "E_DATE="+value4+","+"E_BIRTH="+value5+","+"E_CONDITION='"+value6+"',"+"E_EDUCATION='"+value7+"',"+"E_POLITICS='"+value8+"'  where ID='"+value1+"'";
                System.out.println(sqlString);
                EmployManager employManager=new EmployManager();
                int result=employManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Updated Success!",
                            "Update Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException formatException)
            {
                JOptionPane.showMessageDialog(this,"Input wrong message!","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
        }
        else JOptionPane.showMessageDialog(this,"Bad ID","Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
    public void DeleteRecord()
    {
        String value1;String value2;String value3;int value4;int value5;String value6;String value7,value8;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=c1.getSelectedItem().toString();
        value4=Integer.valueOf(textField3.getText());
        value5=Integer.valueOf(textField4.getText());
        value6=c3.getSelectedItem().toString();
        value7=c4.getSelectedItem().toString();
        value8=c5.getSelectedItem().toString();
        if(!value1.equals("")){
            try{
                String sqlString="Delete from 员工信息"+" where ID='"+value1+"'";
                System.out.println(sqlString);
                EmployManager employManager=new EmployManager();
                int result=employManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Deleted Success!",
                            "Delete Result",JOptionPane.ERROR_MESSAGE);
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
        else JOptionPane.showMessageDialog(this,"Bad ID",
                "Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
    public void ConfirmRecord()//l9和textField6
    {
        String value1,value2,value3; int value4;String value5;int value6;
        String value7,value8,value9;
        value9=textField6.getText();//得到员工编号
        if(!value9.equals(""))
        {
            try{
                String sqlString="select * from 员工信息 "+"where ID='"+value9+"'";
                EmployManager employManager=new EmployManager();
                List<员工信息>list=employManager.Query(sqlString);
                if(list.size()!=0)
                {
                    value1=list.get(0).getID();
                    value2=list.get(0).getE_NAME();
                    value3=list.get(0).getE_SEX();
                    value4=list.get(0).getE_DATE();
                    value5=list.get(0).getE_CONDITION();
                    value6=list.get(0).getE_BIRTH();
                    value7=list.get(0).getE_EDUCATION();
                    value8=list.get(0).getE_POLITICS();
                    JOptionPane.showMessageDialog(this,"存在这条记录",
                            "Valid Number Format",JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(value1);
                    textField2.setText(value2);
                    c1.setSelectedItem(value3);
                    textField3.setText(String.valueOf(value4));
                    c3.setSelectedItem(value5);
                    textField4.setText(String.valueOf(value6));
                    c4.setSelectedItem(value7);
                    c5.setSelectedItem(value8);
                }
                else {
                    textField6.setText("");
                    JOptionPane.showMessageDialog(this,"不存在这条记录","Find Result",JOptionPane.INFORMATION_MESSAGE);
                }

            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
        }
        else {
            JOptionPane.showMessageDialog(this,"Bad ID Number","Invalid Number Format",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void EliminateRecord()
    {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");

    }

}

