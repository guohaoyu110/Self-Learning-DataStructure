/**
 * Created by haoyuguo on 07/05/2017.
 */
import javax.swing.*;
import java.awt.*;
public class test extends JFrame {
    public static JLabel l1=new JLabel("输入城市数");
    public static JLabel l2=new JLabel("输入多少条通道");
    public static JLabel l3=new JLabel("输入哪两个城市之间和权重");
    public static JTextField j1=new JTextField();
    public static JTextField j2=new JTextField();
    public static JTextField j3=new JTextField();
    public static JTextField j4=new JTextField();
    public static JTextField j5=new JTextField();
    public static JButton button2=new JButton("确定城市");
    public static JButton button1=new JButton("ok");
    public static JButton button3=new JButton("画图");
    public static Box box1=Box.createHorizontalBox();
    public static Box box2=Box.createHorizontalBox();
    public static Box box4=Box.createHorizontalBox();
    public static Box box3=Box.createVerticalBox();
    public test()
    {
        super("画图");
        this.setSize(400,300);
        box1.add(l1);
        box1.add(j1);
        box1.add(l2);
        box1.add(j2);
        box2.add(l3);
        box2.add(j3);
        box2.add(j4);
        box2.add(j5);
        box3.add(Box.createVerticalStrut(40));
        box3.add(box1);
        box3.add(Box.createVerticalStrut(40));
        box3.add(box2);
        box3.add(Box.createVerticalStrut(40));
        box4.add(button2);
        box4.add(button1);
        box4.add(button3);
        box3.add(box4);
        box3.add(Box.createVerticalStrut(40));
        this.add(box3);
        this.setVisible(true);

    }


}
