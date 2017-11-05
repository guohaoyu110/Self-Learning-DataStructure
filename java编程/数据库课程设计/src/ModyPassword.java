/**
 * Created by haoyuguo on 19/06/2017.
 */
import com.sun.xml.internal.bind.v2.model.annotation.AbstractInlineAnnotationReaderImpl;
import sun.java2d.pipe.RegionSpanIterator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
public class ModyPassword extends JFrame{
    public static JLabel l0=new JLabel("修改密码");
    public static JLabel l1=new JLabel("用户名:      ");
    public static JLabel l2=new JLabel("原密码:      ");
    public static JLabel l3=new JLabel("新密码:      ");
    public static JLabel l4=new JLabel("确定密码:    ");
    public JTextField textField1=new JTextField(10);
    public JTextField textField2=new JTextField(10);
    public JTextField textField3=new JTextField(10);
    public JTextField textField4=new JTextField(10);
    public JButton button1=new JButton("确定");
    public JButton button2=new JButton("清除");
    public JButton button3=new JButton("修改");
    public JButton button4=new JButton("退出");
    public ModyPassword(){
        super("修改密码");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        l0.setFont(new Font("宋体",Font.BOLD,24));
        container.add(l0);
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createHorizontalBox();
        box1.add(l1); box1.add(textField1);//用户名
        box2.add(l2); box2.add(textField2);//旧密码
        box3.add(button1); box3.add(button2); //确定键和清除键
        box4.add(l3); box4.add(textField3);//新密码
        box5.add(l4); box5.add(textField4);//确定密码
        box6.add(button3); box6.add(button4); //修改和退出
        container.add(box1);container.add(box2);container.add(box3);container.add(box4);container.add(box5); container.add(box6);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      DisplayRecord();
                    }
                }
        );

        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");//把两个文本框全部清零
                    }
                }
        );

        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateRecord();
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
        this.setSize(300,300);
        this.setVisible(true);

    }
    public void DisplayRecord()
    {
        String value1=textField1.getText();//value1是员工号
        String value2;//value2
        if(!value1.equals(""))
        {
            try{
                String sqlString="select * from 登录信息"+" where ID='"+value1+"'";
                RegistarManager registarManager=new RegistarManager();
                List<登录信息>list=registarManager.Query(sqlString);
               if(list.size()!=0)
               {
                   value2=list.get(0).getPASSWORD();
                   textField2.setText(value2);
                   JOptionPane.showMessageDialog(ModyPassword.this,"Found this Record!",
                           "Find Result",JOptionPane.INFORMATION_MESSAGE);
               }
               else//如果表里面没有内容的话
               {
                   textField1.setText(""); textField2.setText("");
                   JOptionPane.showMessageDialog(ModyPassword.this,"Not Found this Record!",
                          "Find Result",JOptionPane.INFORMATION_MESSAGE);
               }

            }
            catch(Exception ee)
            {
                System.out.println(ee);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Bad ID number",
                    "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
        }
    }


    public void UpdateRecord()
    {
        String value1=textField1.getText();//用户名
       // String value2=textField2.getText();//原密码
        String value3=textField3.getText();//现在的密码
        String value4=textField4.getText();//确认密码
        if(!value1.equals("")&&value3.equals(value4)){
            try{
                String sqlString="Update 登录信息 set "+"PASSWORD='"+value3+"' where ID='"+value1+"'";
                System.out.println(sqlString);
                RegistarManager registarManager=new RegistarManager();
                int result=registarManager.execUpdate(sqlString);
                if(result!=0){
                    JOptionPane.showMessageDialog(this,"Updated success!",
                            "Update Result!",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException formatException)
            {
                JOptionPane.showMessageDialog(this,"Input wrong message!",
                        "Invalid Number Format",JOptionPane.ERROR_MESSAGE);
            }
            catch(SQLException ee){
                System.out.println(ee);
            }
        }
        else JOptionPane.showMessageDialog(this,"Bad ID number",
                "Invalid Number Format",JOptionPane.ERROR_MESSAGE);

    }
}
