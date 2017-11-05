
//import com.sun.java.swing.action.AlignCenterAction;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame //implements  ActionListener
{
    public static JButton l1=new JButton("添加");
    public static JButton l2=new JButton("修改");
    public static JButton l3=new JButton("删除");
    public static JLabel l4=new JLabel("学号");
    public static JLabel l5=new JLabel("姓名");
    public static JLabel l6=new JLabel("年龄");
    public static JLabel l7=new JLabel("爱好");
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
        JMenuItem exititem=new JMenuItem("Exit");
        JMenu addMenu=new JMenu("Edit");
        JMenuItem item1=new JMenuItem("Add");
        JMenuItem item2=new JMenuItem("Delete");
        JMenuItem item3=new JMenuItem("Modify");
        JMenu searchMenu=new JMenu("View");
        JMenuItem item4=new JMenuItem("Search by age");
        bar.add(fileMenu);
        bar.add(addMenu);
        bar.add(searchMenu);
        fileMenu.add(exititem);
        addMenu.add(item1);
        addMenu.add(item2);
        addMenu.add(item3);
        searchMenu.add(item4);
        Box box1=Box.createHorizontalBox();//创建一个水平的box对象
        textField1=new JTextField(10);
        textField2=new JTextField(10);
        textField3=new JTextField(10);
        textField4=new JTextField(10);
        box1.add(l4); box1.add(textField1);
        box1.add(l5); box1.add(textField2);
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
        /*Icon bug=new ImageIcon(getClass().getResource("AC.jpg"));
        JLabel label2=new JLabel("照片",bug,SwingConstants.LEFT);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.BOTTOM);
        container.add(label2);*/
        Box box3=Box.createHorizontalBox();
        box3.add(l1);box3.add(l2);box3.add(l3);
        container.add(box3);
        //对第一个button添加注册监听器
        exititem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        item1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddStudentPanel add=new AddStudentPanel();
                        remove(getContentPane());
                        setContentPane(add);
                        setVisible(true);
                    }
                }
        );
        item2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeleteStudentPanel delete=new DeleteStudentPanel();
                        remove(getContentPane());
                        setContentPane(delete);
                        setVisible(true);
                    }
                }
        );
        item3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateStudentPanel mod=new UpdateStudentPanel();
                        remove(getContentPane());
                        setContentPane(mod);
                        setVisible(true);
                    }
                }
        );
        item4.addActionListener(//对学生的年龄进行排序
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


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
}
