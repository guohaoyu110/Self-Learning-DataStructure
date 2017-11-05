/**
 * Created by haoyuguo on 03/07/2017.
 */
import com.sun.codemodel.internal.JOp;
import javafx.beans.property.adapter.JavaBeanObjectProperty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.sql.*;
import java.util.List;
public class PXInfo extends JPanel
{
    JLabel l1=new JLabel("培训信息:     ");
    JLabel l2=new JLabel("员工编号:     ");
    JLabel l3=new JLabel("培训编号      ");//主码
    JLabel l4=new JLabel("培训日期      ");
    JLabel l5=new JLabel("培训地点      ");
    JLabel l6=new JLabel("培训内容      ");
    JLabel l8=new JLabel("员工编号:   ");
    JLabel l7=new JLabel("培训编号:  ");
    JPanel p1,p2;
    JTextField textField1=new JTextField(10);
    JTextField textField2=new JTextField(10);
    JTextField textField3=new JTextField(10);
    JTextField textField4=new JTextField(10);
    JTextField textField5=new JTextField(10);
    JTextField textField6=new JTextField(10);
    JTextField textField7=new JTextField(10);
    JButton b1=new JButton("添加");
    JButton b2=new JButton("修改");
    JButton b3=new JButton("删除");
    JButton b4=new JButton("退出");
    JButton b5=new JButton("确定");
    JButton b6=new JButton("清除");
    //String value1,value2,value3,value4,value5;
    public PXInfo()
    {
        p1=new JPanel(); p2=new JPanel();
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
        box1.add(l2); box1.add(textField1);
        box2.add(l3); box2.add(textField2);
        box3.add(l4); box3.add(textField3);
        box3.add(l5); box3.add(textField4);
        box4.add(l6); box4.add(textField5);
        box5.add(b1); box5.add(b2); box5.add(b3); box5.add(b4);

        box6.add(box0); box6.add(Box.createVerticalStrut(20));
        box6.add(box1); box6.add(Box.createVerticalStrut(10));
        box6.add(box2); box6.add(Box.createVerticalStrut(10));
        box6.add(box3); box6.add(Box.createVerticalStrut(10));
        box6.add(box4); box6.add(Box.createVerticalStrut(20));
        box6.add(box5);
        p1.add(box6);

        //下面是第二个panel
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box10=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l7); box7.add(textField6);
        box8.add(b5); box8.add(b6);
        box10.add(l8); box10.add(textField7);
        box9.add(box10); box9.add(Box.createVerticalStrut(10));
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);

        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.validate();

        b1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InsertRecord();
                    }
                }
        );
        b2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();
                    }
                }
        );
        b3.addActionListener(
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
        b5.addActionListener(//确定
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConfirmRecord();
                    }
                }
        );
        b6.addActionListener(//清除
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        EliminateRecord();
                    }
                }
        );
    }
    String value1,value2,value3,value4,value5,value6;
    public void InsertRecord()//插入培训信息表
    {
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        //value6=textField6.getText();
        if(!value2.equals("")&&!value1.equals(""))//确保培训编号不是空
        {
            try{
                String sqlString="Insert into 培训信息 values('"+value1+"','"+value3+"','"+value4
                        +"','"+value5+"','"+value2+"')";
                System.out.println(sqlString);
                PXManager pxManager=new PXManager();
                int result=pxManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(PXInfo.this,"Inserted Success!","Insert Result",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException formatException)
            {
                JOptionPane.showMessageDialog(this,JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException ee)
            {
                System.out.println(ee);
            }
        }
        else JOptionPane.showMessageDialog(this,"Bad PX_ID","Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
    public void UpdateRecord()//更改培训信息表
    {
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        if(!value2.equals(""))
        {
            try{
                String sqlString="Update 培训信息 set "+"ID='"+value1+"',"+"PX_ID='"+value2+"',"+
                        "PX_DATE='"+value3+"',"+"PX_DEST='"+value4+"',"+"PX_REASON='"+value5+"' where "+
                        "PX_ID='"+value2+"'";
                System.out.println(sqlString);
                PXManager pxManager=new PXManager();
                int result=pxManager.execUpdate(sqlString);
                if(result!=0)
                {
                    JOptionPane.showMessageDialog(this,"Updated Success!",
                            "Update Result",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException formatException)
            {
                JOptionPane.showMessageDialog(this,"Input wrong message!",
                        "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException EE)
            {
                System.out.println(EE);
            }

        }
        else {
            JOptionPane.showMessageDialog(this,"Bad PX_ID","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void DeleteRecord()//删除培训信息表
    {
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        if(!value2.equals(""))
        {
            try{
                String sqlString="Delete from 培训信息 "+"where PX_ID='"+value2+"'";
                System.out.println(sqlString);
                PXManager pxManager=new PXManager();
                int result=pxManager.execUpdate(sqlString);
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
        else {
            JOptionPane.showMessageDialog(this,"Bad PX_ID","Invalid Number Format", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void ConfirmRecord()//确定按钮
    {
        value1=textField1.getText();
        value2=textField2.getText();
        value3=textField3.getText();
        value4=textField4.getText();
        value5=textField5.getText();
        value6=textField6.getText();
        String value7=textField7.getText();
        if(!value6.equals("")&&!value7.equals(""))  //记录编号
        {
            try{
                String sqlString="select * from 培训信息 "+"where PX_ID='"+value6+"'AND ID='"+value7+"'";
                PXManager pxManager=new PXManager();
                List<培训信息>list=pxManager.Query(sqlString);
                if(list.size()!=0)
                {
                    String value1=list.get(0).getID();//员工编号
                    String value2=list.get(0).getPX_ID();
                    String value3=list.get(0).getPX_DATE();
                    String value4=list.get(0).getPX_DEST();
                    String value5=list.get(0).getPX_REASON();
                    JOptionPane.showMessageDialog(this,"存在这条记录",
                            "Valid Number Format",JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(value1);
                    textField2.setText(value2);
                    textField3.setText(value3);
                    textField4.setText(value4);
                    textField5.setText(value5);
                }
                else {
                    textField6.setText("");
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
            JOptionPane.showMessageDialog(this,"Bad PX_ID Number","Invalid Number Format",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void EliminateRecord()//清除按钮
    {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }
}
