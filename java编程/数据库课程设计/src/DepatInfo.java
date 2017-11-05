/**
 * Created by haoyuguo on 20/06/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.sql.*;
import java.util.List;

public class DepatInfo extends JPanel{
    JLabel l1 = new JLabel("部 门 信 息");
    JLabel l2 = new JLabel("部门编号：     ");
    JLabel l3 = new JLabel("部门名称：     ");
    JLabel l4 = new JLabel("部门人数：     ");
    JLabel l5= new JLabel("部门编号：   ");
    private JPanel p1,p2;
    JTextField textField1 = new JTextField(10);//部门编号
    JTextField textField2 = new JTextField(10);//部门名称
    JTextField textField3 = new JTextField(10);//部门人数
    JTextField textField4 = new JTextField(10);
    //JButton b1=new JButton("保存");
    JButton b2=new JButton("添加");
    JButton b3=new JButton("修改");
    JButton b4=new JButton("删除");
    JButton b5=new JButton("退出");
    JButton b6=new JButton("确定");
    JButton b7=new JButton("清除");
    String value1,value2,value3;
    public DepatInfo() {
        p1=new JPanel();p2=new JPanel();
        setLayout(new BorderLayout());

       // p1.setPreferredSize(new Dimension(500,400));
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box0=Box.createVerticalBox();
        l1.setFont(new Font("宋体",Font.PLAIN,30));
        box1.add(l1);
        box2.add(l2); box2.add(textField1);
        box3.add(l3); box3.add(textField2);
        box4.add(l4); box4.add(textField3);
        box5.add(b2); box5.add(b3); box5.add(b4); box5.add(b5);

        box0.add(box1); box0.add(Box.createVerticalStrut(10));
        box0.add(Box.createVerticalStrut(10));
        box0.add(box2); box0.add(Box.createVerticalStrut(10));
        box0.add(box3); box0.add(Box.createVerticalStrut(10));
        box0.add(box4); box0.add(Box.createVerticalStrut(10));
        box0.add(Box.createVerticalStrut(10));
        box0.add(box5);
        p1.add(box0);

        //下面是第二个panel
        Box box6=Box.createHorizontalBox();
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createVerticalBox();
        box6.add(l5); box6.add(textField4);
        box7.add(b6);//确定
        box7.add(b7);//清除
        box8.add(box6); box8.add(Box.createVerticalStrut(10));
        box8.add(box7);
        p2.add(box8);
        b6.addActionListener(
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


        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);

        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.validate();

        b2.addActionListener(//添加按钮
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        value1=textField1.getText();value2=textField2.getText();value3=textField3.getText();
                        if (!value1.equals("")) {//只要数据库的主键不为空值
                            try {
                                int number = Integer.parseInt(value1);
                                String name = value2;
                                int count = Integer.parseInt(value3);
                                String sqlString = "Insert into 部门信息 values(" + number + ",'" + name + "'," + count + ")";
                                DeptManager companyManager=new DeptManager();
                                int result=companyManager.execUpdate(sqlString);
                                if(result!=0)
                                {
                                    JOptionPane.showMessageDialog(DepatInfo.this,"Inserted Success!","Insert Result",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            /*catch (NumberFormatException formatException) {
                                JOptionPane.showMessageDialog(DepatInfo.this, JOptionPane.ERROR_MESSAGE);
                            }*/
                            catch(SQLException ee)
                            {
                                System.out.println(ee);
                            }
                        }
                        else JOptionPane.showMessageDialog(DepatInfo.this,"Bad D_Number","Invalid Number Format",JOptionPane.ERROR_MESSAGE);

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

        this.setSize(400,300);
        this.setVisible(true);

    }
    public void UpdateRecord()
    {
        int value1; String value2; int value3;
        value1=Integer.valueOf(textField1.getText());
        value2=textField2.getText();
        value3=Integer.valueOf(textField3.getText());
        if(!textField1.getText().equals(""))
        {
            try{
                String sqlString="Update 部门信息 set "+"D_NAME='"+value2+"',"+"D_COUNT="+value3+" where D_NUMBER="+value1;
                System.out.println(sqlString);
                DeptManager deptManager=new DeptManager();
                int result=deptManager.execUpdate(sqlString);
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
        else JOptionPane.showMessageDialog(this,"Bad D_NUMBER",
                "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
    }
    public void DeleteRecord()
    {
        int value1;String valule2;int value3;
        value1=Integer.valueOf(textField1.getText());
        value2=textField2.getText();
//        value3=Integer.valueOf(textField3.getText());
        if(!textField1.getText().equals(""))
        {
            try{
                String sqlString="Delete from 部门信息 "+"where D_NUMBER="+value1;
                System.out.println(sqlString);
                DeptManager deptManager=new DeptManager();
                int result=deptManager.execUpdate(sqlString);
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
        else JOptionPane.showMessageDialog(this,"Bad D_NUMBER","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
    }
    public void ConfirmRecord()
    {
        int value4=Integer.valueOf(textField4.getText());
        if(!textField4.equals(""))
        {
            try{
                String sqlString="select * from 部门信息 "+"where D_NUMBER ="+value4;
                DeptManager deptManager=new DeptManager();
                List<部门信息>list=deptManager.Query(sqlString);
                if(list.size()!=0)
                {
                    String value2=list.get(0).getName();//部门名称
                    int value3=list.get(0).getCount();//部门总人数
                    JOptionPane.showMessageDialog(this,"存在这条记录","Valid Number Format",
                            JOptionPane.INFORMATION_MESSAGE);
                    textField1.setText(textField4.getText());//textField1.setEditable(false);
                    textField2.setText(value2);
                    textField3.setText(String.valueOf(value3));
                }
                else
                {
                    textField4.setText("");
                    JOptionPane.showMessageDialog(this,"不存在这条记录","Find Result",
                            JOptionPane.INFORMATION_MESSAGE);

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























