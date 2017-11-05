/**
 * Created by haoyuguo on 24/06/2017.
 */
import com.sun.codemodel.internal.JOp;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import sun.awt.AWTIcon32_java_icon16_png;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.sql.*;
import java.util.List;

public class JobInfo extends JPanel{
    JLabel l1 = new JLabel("职 务 信 息");
    JLabel l2 = new JLabel("员工编号：     ");
    JLabel l3 = new JLabel("职务名称：     ");
    JLabel l4 = new JLabel("部门名称：     ");
    JLabel l5=new JLabel("员工编号:   ");
    JTextField textField1 = new JTextField(10);//部门编号
    JTextField textField2 = new JTextField(10);//部门名称
    JTextField textField3 = new JTextField(10);//部门人数
    JTextField textField4=new JTextField(10);//搜索员工编号
    //JButton b1=new JButton("保存");
    JButton b2=new JButton("添加");
    JButton b3=new JButton("修改");
    JButton b4=new JButton("删除");
    JButton b5=new JButton("退出");
    JButton b6=new JButton("确认");
    JButton b7=new JButton("清除");

    private JPanel p1,p2;
    String value1,value2,value3;
    public JobInfo() {
        p1=new JPanel();p2=new JPanel();
        setLayout(new BorderLayout());
        l1.setFont(new Font("宋体",Font.BOLD,35));
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box0=Box.createVerticalBox();
        box5.add(l1);
        box1.add(l2);box1.add(textField1);
        box2.add(l3);box2.add(textField2);
        box3.add(l4);box3.add(textField3);

        value1=textField1.getText();value2=textField2.getText();value3=textField3.getText();
        box4.add(b2);box4.add(b3); box4.add(b4);box4.add(b5);

        box0.add(box5); box0.add(Box.createVerticalStrut(20));
        box0.add(box1); box0.add(Box.createVerticalStrut(10));
        box0.add(box2); box0.add(Box.createVerticalStrut(10));
        box0.add(box3); box0.add(Box.createVerticalStrut(20));
        box0.add(box4); //box0.add(Box.createVerticalStrut(20));
        p1.add(box0);

        //下面是第二个panel
        Box box6=Box.createHorizontalBox();
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createVerticalBox();
        box6.add(l5); box6.add(textField4);
        box7.add(b6); box7.add(b7);
        box8.add(box6); box8.add(Box.createVerticalStrut(10));
        box8.add(box7);
        p2.add(box8);

        b6.addActionListener(//确定按钮
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConfirmRecord();
                    }
                }
        );

        b7.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EliminateRecord();
                    }
                }
        );

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
        //连接数据库
        //Database.joinDB();
        //初始化窗体数据
        this.add(p1, BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.validate();

        this.setSize(400,300);
        this.setVisible(true);

    }
    public void InsertRecord()
    {
        String value1,value2,value3;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        if(!value1.equals(""))
        {
            try{
            String sqlString="Insert into 职务信息"+" values ('"+value1+"','"+value2+"','"
                    +value3+"')";
            System.out.println(sqlString);
            JobManager jobManager=new JobManager();
            int result=jobManager.execUpdate(sqlString);
            if(result!=0)
            {
                JOptionPane.showMessageDialog(this,"Inserted Success!",
                        "Inserted Result!", JOptionPane.INFORMATION_MESSAGE);
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
        else JOptionPane.showMessageDialog(this,"Input wrong message!","Invalid Number Format",
                JOptionPane.ERROR_MESSAGE);
    }
    public void UpdateRecord()
    {
        String value1,value2,value3;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        if(!value1.equals(""))
        {
            try{
            String sqlString="Update 职务信息 set "+"J_NAME='"+value2+"','"+"D_NAME='"+value3+"' where ID='"+value1+"'";
            System.out.println(sqlString);
            JobManager jobManager=new JobManager();
            int result=jobManager.execUpdate(sqlString);
            if(result!=0)
            {
                JOptionPane.showMessageDialog(this,"Updated Success!",
                        "Update Result",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(NumberFormatException formatException){
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
    public void DeleteRecord()
    {
        String value1,value2,value3;
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        if(!value1.equals(""))
        {
            try{
                String sqlString="Delete from 职务信息 "+"where ID='"+value1+"'";
                System.out.println(sqlString);
                JobManager jobManager=new JobManager();
                int result=jobManager.execUpdate(sqlString);
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
        else JOptionPane.showMessageDialog(this,"Bad ID","Invalid Number Format",
                JOptionPane.ERROR_MESSAGE);

    }
    public void ConfirmRecord()
    {
       // String value1=textField1.getText();String value2=textField2.getText();
       // String value3=textField3.getText();
        String value4=textField4.getText();
        if(!textField4.equals(""))
        {
            try{
                String sqlString ="select * from 职务信息 "+"where ID='"+value4;
                JobManager jobManager=new JobManager();
                List<职务信息>list=jobManager.Query(sqlString);
                if(list.size()!=0)
                {
                    String value2=list.get(0).getJ_NAME();
                    String value3=list.get(0).getD_NAME();
                    JOptionPane.showMessageDialog(this,"存在这条记录","Valid Number Format",
                            JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(textField4.getText());textField1.setEditable(false);
                    textField2.setText(value2);
                    textField3.setText(value3);
                }
                else
                {
                    textField4.setText("");
                    JOptionPane.showMessageDialog(this,"不存在这条记录",
                            "Find Result",JOptionPane.INFORMATION_MESSAGE);

                }
            }
            catch(Exception ee)
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

    }
}
























