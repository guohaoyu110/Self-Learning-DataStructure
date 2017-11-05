import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by haoyuguo on 04/07/2017.
 */
public class SearchWageInfo extends JFrame {

    JLabel l1 = new JLabel("薪 水 信 息");
    JLabel l2 = new JLabel("员工编号:");
    JLabel l3 = new JLabel("基本工资:");
    JLabel l4 = new JLabel("奖    金: ");
    JLabel l5=new JLabel("时    间: ");
    JLabel l6=new JLabel("员工编号：  ");
    JLabel l7=new JLabel("时    间:    ");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JButton button1=new JButton("确定");
    JButton button2=new JButton("清除");
    JButton button3=new JButton("返回");
    JTextField textField1 = new JTextField(10);//员工编号
    JTextField textField2 = new JTextField(10);//基本工资
    JTextField textField3 = new JTextField(10);//奖金
    JTextField textField4=new JTextField(10);//时间
    JTextField textField5=new JTextField(10);
    JTextField textField6=new JTextField(10);

    //String value1,value2,value3,value4;
    public SearchWageInfo(final String selecty) {
        super("搜索薪水信息");
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


        box6.add(box0); box6.add(Box.createVerticalStrut(20));
        box6.add(box1); box6.add(Box.createVerticalStrut(10));
        box6.add(box2); box6.add(Box.createVerticalStrut(10));
        box6.add(box3); box6.add(Box.createVerticalStrut(10));
        box6.add(box4);
        p1.add(box6);
        //textField1.setText(""); textField2.setText(""); textField3.setText("");
        //这一步错在哪里
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box10=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l6); box7.add(textField5);
        box10.add(l7); box10.add(textField6);
        box8.add(button1); box8.add(button2); box8.add(button3);
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box10);box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);



        textField5.setText(selecty); textField5.setEditable(false);
        //String value;

        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String value = textField6.getText();
                        try {
                            String sqlString = "select * from 薪资信息 " + " where ID='" + selecty + "'AND SEASON='" +
                                    value + "'";
                            SalaryManager salaryManager = new SalaryManager();
                            List<薪资信息> list = salaryManager.Query(sqlString);
                            if(list.size()!=0)
                            {
                                String value1=list.get(0).getID();
                                int value2=list.get(0).getBasic_pay();
                                int value3=list.get(0).getBonus();
                                String value4=list.get(0).getSEASON();
                                textField1.setText(value1);
                                textField2.setText(String.valueOf(value2));
                                textField3.setText(String.valueOf(value3));
                                textField4.setText(value4);
                            }
                            else {
                                textField6.setText("");
                                JOptionPane.showMessageDialog(SearchWageInfo.this,"不存在这条记录","Find Result",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        catch(Exception ee)
                        {
                            System.out.println(ee);
                        }
                    }
                }
        );

        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField6.setText("");
                    }
                }
        );

        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        MainFrame1 mainFrame1=new MainFrame1(selecty);
                        setContentPane(mainFrame1);
                        setVisible(true);
                    }
                }
        );
        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        setSize(600,400);
        setVisible(true);
        //this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //this.validate();

        //value1=textField1.getText();value2=textField2.getText();value3=textField3.getText();
        //value4=textField4.getText();




    }

}



