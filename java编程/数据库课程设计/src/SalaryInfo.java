/**
 * Created by haoyuguo on 23/06/2017.
 */
import javafx.beans.property.adapter.JavaBeanObjectProperty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.sql.*;
import java.util.List;

public class SalaryInfo extends JPanel{
    JLabel l1 = new JLabel("薪 水 信 息");
    JLabel l2 = new JLabel("员工编号:");
    JLabel l3 = new JLabel("基本工资:");
    JLabel l4 = new JLabel("奖    金: ");
    JLabel l5=new JLabel("时    间: ");
    JLabel l6=new JLabel("员工编号：  ");
    JLabel l7=new JLabel("时   间:    ");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();

    JTextField textField1 = new JTextField(10);//员工编号
    JTextField textField2 = new JTextField(10);//基本工资
    JTextField textField3 = new JTextField(10);//奖金
    JTextField textField4=new JTextField(10);//时间
    JTextField textField5=new JTextField(10);
    JTextField textField6=new JTextField(10);

    //JButton b1=new JButton("保存");
    JButton b2=new JButton("添加");
    JButton b3=new JButton("修改");
    JButton b4=new JButton("删除");
    JButton b5=new JButton("退出");
    JButton b6=new JButton("确定");
    JButton b7=new JButton("清除");

    String value1,value2,value3,value4;
    public SalaryInfo() {

        p1=new JPanel();p2=new JPanel();
        setLayout(new BorderLayout());

        l1.setFont(new Font("宋体",Font.BOLD,35));
        Box box0=Box.createHorizontalBox();
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createVerticalBox();
        box0.add(l1);
        box1.add(l2);box1.add(textField1);
        box2.add(l3);box2.add(textField2);
        box3.add(l4);box3.add(textField3);
        box4.add(l5); box4.add(textField4);
        box5.add(b2);box5.add(b3); box5.add(b4);box5.add(b5);

        box6.add(box0); box6.add(Box.createVerticalStrut(20));
        box6.add(box1); box6.add(Box.createVerticalStrut(10));
        box6.add(box2); box6.add(Box.createVerticalStrut(10));
        box6.add(box3); box6.add(Box.createVerticalStrut(10));
        box6.add(box4); box6.add(Box.createVerticalStrut(20));
        box6.add(box5);
        p1.add(box6);
        //textField1.setText(""); textField2.setText(""); textField3.setText("");
        //这一步错在哪里
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box10=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l6); box7.add(textField5);
        box10.add(l7); box10.add(textField6);
        box8.add(b6); box8.add(b7);
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box10); box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);


        b6.addActionListener(//确定
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConfirmRecord();
                    }
                }
        );
        b7.addActionListener(//清除
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

        value1=textField1.getText();value2=textField2.getText();value3=textField3.getText();
        value4=textField4.getText();


        b2.addActionListener(//添加按钮
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       InsertRecord();
                    }
                }
        );

        b3.addActionListener(//修改
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();

                    }
                }
        );
        b4.addActionListener(//删除
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeleteRecord();
                    }
                }
        );
        b5.addActionListener(//退出
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );

        //container.add(box1); container.add(box2); container.add(box3); container.add(box4);
        this.setSize(400,300);
        this.setVisible(true);

    }
    public void DeleteRecord()
    {
        String value1;int value2;int value3;String value4;
        value1=textField1.getText();
        value2=Integer.valueOf(textField2.getText());
        value3=Integer.valueOf(textField3.getText());
        value4=textField4.getText();
        if(!value1.equals(""))
        {
            try{
                String sqlString="Delete from 薪资信息"+" where ID='"+value1+"' AND SEASON='"+value4+"'";
                System.out.println(sqlString);
                SalaryManager salaryManager=new SalaryManager();
                int result=salaryManager.execUpdate(sqlString);
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
        else JOptionPane.showMessageDialog(this,"Bad ID",
                "Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
    public void InsertRecord()
    {
        String value1; int value2,value3;String value4;
        value1=textField1.getText();
        value2=Integer.valueOf(textField2.getText());
        value3=Integer.valueOf(textField3.getText());
        value4=textField4.getText();
        //value4=Integer.valueOf()
        if(!value1.equals(""))
        {
            try{
                String sqlString="Insert into 薪资信息 "+"values ('"+value1+"',"+value2+","+value3+",'"+value4+"')";
                System.out.println(sqlString);
                SalaryManager salaryManager=new SalaryManager();
                int result=salaryManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Inserted Success!",
                    "Inserted Result!",JOptionPane.INFORMATION_MESSAGE);
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
        else JOptionPane.showMessageDialog(this,"Input Wrong Message!",
                "Invalid Number Format", JOptionPane.ERROR_MESSAGE);

    }
    public void UpdateRecord()
    {
        String value1; int value2;int value3;String value4;
        value1=textField1.getText();
        value2=Integer.valueOf(textField2.getText());
        value3=Integer.valueOf(textField3.getText());
        value4=textField4.getText();
        //value4
        if(!value1.equals(""))
        {
            try{
                String sqlString="Update 薪资信息 set "+"BASIC_PAY="+value2+","+"BONUS="+value3+","+"SEASON='"+value4+"'"+
                       " where ID='"+value1+"'";
                System.out.println(sqlString);
                SalaryManager salaryManager=new SalaryManager();
                int result=salaryManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Updated success!",
                            "Update Result",JOptionPane.INFORMATION_MESSAGE);
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
    public void ConfirmRecord()
    {
        String value5=textField5.getText();
        String value6=textField6.getText();
        if(!value5.equals("")&&!value6.equals(""))
        {
            try{
                String sqlString="select * from 薪资信息 "+"where ID='"+value5+"' AND SEASON='"+value6+"'";
                SalaryManager salaryManager=new SalaryManager();
                List<薪资信息>list=salaryManager.Query(sqlString);
                if(list.size()!=0)
                {
                    String value1=list.get(0).getID();
                    int value2=list.get(0).getBasic_pay();
                    int value3=list.get(0).getBonus();
                    String value4=list.get(0).getSEASON();
                    JOptionPane.showMessageDialog(this,"存在这条记录",
                            "Valid Number Format",JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(value1);
                    textField2.setText(String.valueOf(value2));
                    textField3.setText(String.valueOf(value3));
                    textField4.setText(value4);
                }
                else {
                    textField5.setText("");
                    JOptionPane.showMessageDialog(this,"不存在这条记录",
                            "Find Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception ee)
            {
                JOptionPane.showMessageDialog(this,"Bad ID Number","Invalid Number Format",
                        JOptionPane.ERROR_MESSAGE);
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
























