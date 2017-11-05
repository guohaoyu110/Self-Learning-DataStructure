import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.List;

public class Main extends JFrame
{
    public static JLabel l1=new JLabel("用户名:");
    public static JLabel l2=new JLabel("      密   码:");
    public static JLabel l0=new JLabel("企业员工管理系统");
    private JTextField textField1=new JTextField(10);
    private JPasswordField passwordField=new JPasswordField(10);
    private JRadioButton button11,button12;
    private ButtonGroup radioGroup;
    //ItemHandler handler=new ItemHandler();
    public static JButton button1=new JButton("注册");
    public static JButton button2=new JButton("修改密码");
    public static JButton button3=new JButton("登录");
    public static JButton button4=new JButton("退出");

    public Main()
    {
        super("登录页面");
        l0.setFont(new Font("宋体",Font.BOLD,24));
        Container container=getContentPane();
        container.setLayout(new GridLayout(5,1,5,5));
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        button11=new JRadioButton("用户",true);
        button12=new JRadioButton("管理员",false);
        container.add(button11);  container.add(button12);
        container.add(button1);container.add(button2);container.add(button3);container.add(button4);
        radioGroup=new ButtonGroup();
        radioGroup.add(button11); radioGroup.add(button12);
       // button11.addActionListener(handler);
        //button12.addActionListener(handler);
        p1.add(l0);//第一行
        p2.add(l1);   p2.add(textField1);  p2.add(button1);//第二行
        p3.add(l2);   p3.add(passwordField); p3.add(button2);//第三行
        p4.add(button11); p4.add(button12);
        p5.add(button3); p5.add(button4);
        button1.addActionListener(//注册
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        SignUp me=new SignUp();
                        me.setVisible(true);
                    }
                }
        );

        button2.addActionListener(//修改密码
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();//release resources
                        ModyPassword modyPassword=new ModyPassword();
                        modyPassword.setVisible(true);
                    }
                }
        );
        button3.addActionListener(//登录
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        DisplayRecord();
                    }
                }
        );
        button4.addActionListener(//退出
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);

                    }
                }
        );
        container.add(p1);container.add(p2); container.add(p3); container.add(p4);container.add(p5);
        this.setSize(400,250);
        this.setVisible(true);
    }

    public void DisplayRecord()
    {
        String value1=textField1.getText();//value1是员工号
        String value2=passwordField.getText();//value2是员工的密码

        if(!value1.equals(""))
        {
            try{
                String sqlString="select * from 登录信息"+" where ID='"+value1+"' AND PASSWORD='"+value2+"'";
               // String sql="select * from 登录信息 "+"where ID ='"+value1+"' AND PASSWORD<>'"+value2+"'";
                RegistarManager registarManager=new RegistarManager();
                List<登录信息> list=registarManager.Query(sqlString);
                //List<登录信息> list1=registarManager.Query(sql);
                if(list.size()!=0)
                {
                   if(button12.isSelected())//这个是管理员界面
                   {
                       if(list.get(0).getINDEX()==2)
                       {
                         dispose();
                         MainFrame frame=new MainFrame();
                         //this.remove(this.getContentPane());
                         this.setContentPane(frame);
                         this.setVisible(true);
                       }
                       else {
                           JOptionPane.showMessageDialog(this,"请调至用户模式","Invalid Number Format",JOptionPane.INFORMATION_MESSAGE);
                       }
                   }
                   else if(button11.isSelected())//这个是用户界面
                   {
                       if(list.get(0).getINDEX()==1){
                       dispose();
                       MainFrame1 frame1=new MainFrame1(value1);
                       //this.remove(this.getContentPane());
                       this.setContentPane(frame1);
                       this.setVisible(true);
                       }
                       else {
                           JOptionPane.showMessageDialog(this,"请调至管理员模式","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
                       }
                   }

                }

                else if(list.size()==0)
                {
                    textField1.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(Main.this,"请重新输入用户名和密码",
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

    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
