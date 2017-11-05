/**
 * Created by haoyuguo on 04/07/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.sql.*;
import java.util.List;
public class SearchPXInfo extends JFrame
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

    JButton b5=new JButton("确定");
    JButton b6=new JButton("清除");
    JButton b7=new JButton("返回");
    //String value1,value2,value3,value4,value5;
    public SearchPXInfo(final String selecty)
    {
        super("搜索培训信息");
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


        box6.add(box0); box6.add(Box.createVerticalStrut(20));
        box6.add(box1); box6.add(Box.createVerticalStrut(10));
        box6.add(box2); box6.add(Box.createVerticalStrut(10));
        box6.add(box3); box6.add(Box.createVerticalStrut(10));
        box6.add(box4);
        p1.add(box6);

        //下面是第二个panel
        Box box7=Box.createHorizontalBox();
        Box box8=Box.createHorizontalBox();
        Box box10=Box.createHorizontalBox();
        Box box9=Box.createVerticalBox();
        box7.add(l7); box7.add(textField6);
        box8.add(b5); box8.add(b6); box8.add(b7);
        box10.add(l8); box10.add(textField7);
        box9.add(box10); box9.add(Box.createVerticalStrut(10));
        box9.add(box7); box9.add(Box.createVerticalStrut(10));
        box9.add(box8);
        p2.add(box9);

        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.NORTH);
        //this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        //this.validate();
        //l8是员工编号，l7是培训编号
        textField7.setText(selecty);textField7.setEditable(false);
        b5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String value=textField6.getText();
                        try{
                            String sqlString="select * from 培训信息 "+" where ID='"+selecty+
                                    "' AND PX_ID='"+value+"'";
                            PXManager pxManager=new PXManager();
                            List<培训信息>list=pxManager.Query(sqlString);
                            if(list.size()!=0)
                            {
                                String value1=list.get(0).getID();
                                String value2=list.get(0).getPX_ID();
                                String value3=list.get(0).getPX_DATE();
                                String value4=list.get(0).getPX_DEST();
                                String value5=list.get(0).getPX_REASON();
                                textField1.setText(value1);
                                textField2.setText(value2);
                                textField3.setText(value3);
                                textField4.setText(value4);
                                textField5.setText(value5);

                            }
                            else {
                                textField6.setText("");
                                JOptionPane.showMessageDialog(SearchPXInfo.this,"不存在这条记录",
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

        b6.addActionListener(//清空
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                        textField6.setText("");
                    }
                }
        );

        b7.addActionListener(//返回
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

