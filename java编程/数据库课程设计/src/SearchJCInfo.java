/**
 * Created by haoyuguo on 04/07/2017.
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class SearchJCInfo extends JFrame
{
    JLabel l1=new JLabel("奖 惩 信 息");
    JLabel l2=new JLabel("员工编号:           ");
    JLabel l3=new JLabel("奖惩编号:           ");
    JLabel l4=new JLabel("奖惩时间:           ");
    JLabel l5=new JLabel("奖惩原因:           ");
    JLabel l6=new JLabel("奖惩编号:    ");

    private JPanel p1,p2;
    JTextField textField1=new JTextField(10);
    JTextField textField2=new JTextField(10);
    JTextField textField3=new JTextField(10);
    JTextField textField4=new JTextField(10);
    JTextField textField5=new JTextField(10);



    JButton b5=new JButton("确定");
    JButton b6=new JButton("清除");
    JButton b7=new JButton("返回");
    //String value1,value2,value3,value4;
    public SearchJCInfo(final String selecty)
    {
        super("搜索奖惩信息");
        p1=new JPanel(); p2=new JPanel();
        setLayout(new BorderLayout());
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
       // Box box6=Box.createHorizontalBox();
        Box box0=Box.createVerticalBox();
        l1.setFont(new Font("宋体",Font.PLAIN,30));
        box1.add(l1);
        box2.add(l2); box2.add(textField1);
        box3.add(l3); box3.add(textField2);
        box4.add(l4); box4.add(textField3);
        box5.add(l5); box5.add(textField4);

        box0.add(box1); box0.add(Box.createVerticalStrut(20));
        box0.add(box2); box0.add(Box.createVerticalStrut(10));
        box0.add(box3); box0.add(Box.createVerticalStrut(10));
        box0.add(box4); box0.add(Box.createVerticalStrut(10));
        box0.add(box5);
        p1.add(box0);

        //下面是第二个panel
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l6); box7.add(textField5);
        box8.add(b5); box8.add(b6); box8.add(b7);
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);

        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        //this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //this.validate();
        textField1.setText(selecty); textField1.setEditable(false);

        b5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String value=textField5.getText();
                        try{
                            String sqlString="select * from 奖惩信息 "+"where ID='"+selecty+"' AND JC_ID='"+
                                    value+"'";
                            JCManager jcManager=new JCManager();
                            List<奖惩信息>list=jcManager.Query(sqlString);
                            if(list.size()!=0)
                            {
                                String value1=list.get(0).getID();
                                String value2=list.get(0).getJC_ID();
                                String value3=list.get(0).getJC_DATE();
                                String value4=list.get(0).getJC_REASON();
                                textField2.setText(value);
                                textField3.setText(value3);
                                textField4.setText(value4);

                            }
                            else {
                                textField5.setText("");
                                JOptionPane.showMessageDialog(SearchJCInfo.this,"不存在这条记录",
                                        "Find Result",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception ee)
                        {
                            System.out.println(ee);
                        }
                    }
                }
        );

        b6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                    }
                }
        );


        b7.addActionListener(
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
        setSize(600,400);
        setVisible(true);
    }



}
