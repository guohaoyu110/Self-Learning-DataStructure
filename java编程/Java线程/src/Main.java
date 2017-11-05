import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
    public static JButton l1=new JButton("添加");
    public static JButton l2=new JButton("修改");
    public static JButton l3=new JButton("删除");
    public static JLabel l4=new JLabel("学号");
    public static JLabel l5=new JLabel("姓名");
    public static JLabel l6=new JLabel("年龄");
    public static JLabel l7=new JLabel("爱好");
    public static JLabel l8=new JLabel("照片");
    private JTextField textField1,textField2,textField3,textField4;
    private JRadioButton maleButton,womenButton;
    private ButtonGroup radioGroup;
    public Main(){
        super("学生表");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        JMenuBar bar=new JMenuBar();//创建菜单栏，并且置于Main窗体内
        setJMenuBar(bar);
        JMenu fileMenu=new JMenu("File");
        JMenuItem sortitem=new JMenuItem("Refer by age");
        fileMenu.add(sortitem);
        sortitem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
        //创建菜单项Exit,并且退出
        JMenuItem exititem=new JMenuItem("Exit");
        fileMenu.add(exititem);
        exititem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        
        Box box1=Box.createHorizontalBox();//创建一个水平的box对象
        textField1=new JTextField(10);
        textField2=new JTextField(10);
        textField3=new JTextField(10);
        textField4=new JTextField(10);
        box1.add(l4);box1.add(textField1);
        box1.add(l5);box1.add(textField2);
        container.add(box1);
        JLabel label1=new JLabel("性别：");
        container.add(label1);
        maleButton=new JRadioButton("男",true);
        container.add(maleButton);
        womenButton=new JRadioButton("女",false);
        container.add(womenButton);
        radioGroup=new ButtonGroup();
        radioGroup.add(maleButton);
        radioGroup.add(womenButton);
      //上面这段主要是为了判断性别是男还是女
        Box box2=Box.createHorizontalBox();
        box2.add(l6);box2.add(textField3);
        box2.add(l7);box2.add(textField4);
        container.add(box2);
        Icon bug=new ImageIcon(getClass().getResource("AC米兰.jpg"));
        JLabel label2=new JLabel("照片",bug,SwingConstants.LEFT);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.BOTTOM);
        container.add(label2);
        Box box3=Box.createHorizontalBox();
        box3.add(l1);box3.add(l2);box3.add(l3);
        container.add(box3);
        //对第一个button添加注册监听器
        l1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event){


                }
            }
        );
        this.setSize(500,250);
        this.setVisible(true);

    }

    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private class TextFieldHandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            String string="";
           // if(event.getSource()==)

        }
    }
}
