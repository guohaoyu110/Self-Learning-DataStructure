/**
 * Created by haoyuguo on 19/06/2017.
 */
//注册用户或者管理员
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class SignUp extends JFrame {
    public static JLabel l1=new JLabel("新账号");
    public static JLabel l2=new JLabel("密码");
    public static JLabel l3=new JLabel("确定密码");
    ItemHandler handler=new ItemHandler();
    private JTextField textField1;
    private JPasswordField textField2,textField3;
    private JRadioButton button1,button2;
    private ButtonGroup radioGroup;
    private JButton button3,button4;
    int value=1;
    public SignUp()
    {
        //包括用户和管理员的注册功能
        super("注册用户账户");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        textField1=new JTextField(10);
        textField2=new JPasswordField(10);
        textField3=new JPasswordField(10);
        button3=new JButton("注册");
        button4=new JButton("退出");
        //设置用户模式为1，管理员模式为2

        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String value1=textField1.getText();String value2=textField2.getText();
                        String value3=textField3.getText();
                        if(!value1.equals("")&&!value2.equals("")&&value3.equals(value2))
                        {
                            try{
                                String sqlString="Insert into 登录信息 values('"+value1+"','"+value2+"',"+value+")";
                                RegistarManager registarManager=new RegistarManager();
                                int result=registarManager.execUpdate(sqlString);
                                if(result!=0)
                                {
                                    JOptionPane.showMessageDialog(SignUp.this,"Inserted Success!","Insert Result",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            catch(SQLException ee){
                                System.out.println(ee);
                            }
                        }
                        else JOptionPane.showMessageDialog(SignUp.this,"Bad ID","Invalid Number Format",JOptionPane.ERROR_MESSAGE);
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

        Box box1=Box.createHorizontalBox();//一个水平的box对象
        box1.add(l1); box1.add(textField1);
        Box box2=Box.createHorizontalBox();
        box2.add(l2);box2.add(textField2);
        Box box3=Box.createHorizontalBox();
        box3.add(l3);box3.add(textField3);
        container.add(box1); container.add(box2); container.add(box3);

        //这个页面是选择进入用户界面
        button1=new JRadioButton("注册用户",true);
        container.add(button1);
        button2=new JRadioButton("注册管理员",false);
        container.add(button2);
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        radioGroup=new ButtonGroup();
        radioGroup.add(button1);
        radioGroup.add(button2);
        Box box4=Box.createHorizontalBox();
        box4.add(button3);box4.add(button4);
        container.add(box4);

        this.setSize(250,250);
        this.setVisible(true);
    }

    public class ItemHandler implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            //String sqlString="Insert into 登录信息"
            if(e.getSource()==button1)
            {//button1是用户，权限默认值是1
                value=1;

            }
            else if(e.getSource()==button2)
            {//button2是管理员，权限默认值是2
                value=2;
            }
        }
    }
}
