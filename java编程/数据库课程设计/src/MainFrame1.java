/**
 * Created by haoyuguo on 28/06/2017.
 */
///普通用户只能查看
//这个界面为普通用户看到的界面
import com.sun.xml.internal.ws.resources.DispatchMessages;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
public class MainFrame1 extends JFrame{
    private ResultSet rs;
    private JTable jTable1,jTable2,jTable3;
    private Object data1[][],data2[][],data3[][];
    private String column1[],column2[],column3[],column4[];
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    private JTextField textField1,textField2,textField3,textField4,textField5,textField6,
    textField7,textField8,textField9,textField10,textField11,textField12,textField13;

    private JTabbedPane jTabbedPane;
    private JPanel p1,p2,p3,p4,p5,p6;
    private JScrollPane scrollPane1,scrollPane2,scrollPane3;
    private JMenuBar menuBar;
    private JMenu operation;
    private JMenuItem item1,item2,item3,item4,item5;
    private String selecty;

    public MainFrame1(String selecty)
    {
        super("员工操作界面");
        this.selecty=selecty;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
            Statement stmt=conn.createStatement();
            String sqlString="select 员工信息.ID,E_NAME,E_SEX,E_DATE,E_BIRTH,E_CONDITION,E_EDUCATION,E_POLITICS,部门信息.D_NUMBER,部门信息.D_NAME,J_NAME,D_COUNT from 员工信息,职务信息" +
                    ",部门信息 where 员工信息.ID=职务信息.ID AND 职务信息.D_NAME=部门信息.D_NAME AND 员工信息.ID=";
            sqlString+="'"+selecty+"'";
            rs=stmt.executeQuery(sqlString);
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null,"查询失败！");
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        operation=new JMenu("操作");
        item1=new JMenuItem("退出");
        item2=new JMenuItem("返回");
        JMenu operation1=new JMenu("搜索记录");
        item3=new JMenuItem("搜索奖惩");
        item4=new JMenuItem("搜索培训");
        item5=new JMenuItem("搜索工资");

        menuBar.add(operation);
        operation.add(item1);
        operation.add(item2);
        operation1.add(item3);
        operation1.add(item4);
        operation1.add(item5);
        menuBar.add(operation1);
        MenuHandler menuHandler=new MenuHandler();
        item1.addActionListener(menuHandler);
        item2.addActionListener(menuHandler);
        item3.addActionListener(menuHandler);
        item4.addActionListener(menuHandler);
        item5.addActionListener(menuHandler);

        jTabbedPane=new JTabbedPane(JTabbedPane.TOP);
        jTabbedPane.setPreferredSize(new Dimension(700,500));
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        container.add(jTabbedPane);

        //下面写的是员工查看到的我的基本信息
        p1=new JPanel();
        p1.setLayout(new FlowLayout());

        jTabbedPane.add("基本信息",p1);
        Box box0=Box.createVerticalBox();
        Box box1=Box.createHorizontalBox();
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createHorizontalBox();
        l1=new JLabel("员工基本信息");
        l1.setFont(new Font("宋体",Font.PLAIN,28));
        l2=new JLabel("员工编号:");
        l3=new JLabel("姓名:");
        l4=new JLabel("性别:");
        l5=new JLabel("工龄:");
        l6=new JLabel(" 年龄:");
        l7=new JLabel("部门号:");
        l8=new JLabel("部门名称:");
        l9=new JLabel("职务名:");
        l10=new JLabel("部门总人数:");
        l11=new JLabel("备注:");
        l12=new JLabel("状态:");
        l13=new JLabel("教育背景:");
        l14=new JLabel("政治面貌:");


        try{
            textField1=new JTextField(rs.getString(1),8);
            textField2=new JTextField(rs.getString(2),8);
            textField3=new JTextField(rs.getString(3),5);
            textField4=new JTextField(String.valueOf(rs.getInt(4)),8);
            textField5=new JTextField(String.valueOf(rs.getInt(5)),5);
            textField6=new JTextField(rs.getString(6),8);
            textField7=new JTextField(rs.getString(7),10);
            textField8=new JTextField(rs.getString(8),10);
            textField9=new JTextField(String.valueOf(rs.getInt(9)),10);
            textField10=new JTextField(11);
            textField11=new JTextField(rs.getString(10),10);
            textField12=new JTextField(rs.getString(11),10);
            textField13=new JTextField(String.valueOf(rs.getInt(12)),10);


            //textField10是自己写的，不是从数据库中读入的
            textField1.setEditable(false);
            textField2.setEditable(false);
            textField3.setEditable(false);
            textField4.setEditable(false);
            textField5.setEditable(false);
            textField6.setEditable(false);
            textField7.setEditable(false);
            textField8.setEditable(false);
            textField9.setEditable(false);
            textField10.setEditable(true);
            textField11.setEditable(false);
            textField12.setEditable(false);
            textField13.setEditable(false);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        box1.add(l1);
        box2.add(l2);box2.add(textField1); box2.add(l3); box2.add(textField2); box2.add(l4); box2.add(textField3);
        box3.add(l5);box3.add(textField4);box3.add(l6);box3.add(textField5);box3.add(l7); box3.add(textField9);
        box4.add(l12); box4.add(textField6); box4.add(l13); box4.add(textField7); box4.add(l14); box4.add(textField8);
        box5.add(l8);box5.add(textField11);box5.add(l9);box5.add(textField12);
        box6.add(l10); box6.add(textField13); box6.add(l11); box6.add(textField10);
        //p1.add(box1);p1.add(box2); p1.add(box3); p1.add(box4); p1.add(box5);
        box0.add(box1); box0.add(Box.createVerticalStrut(20));
        box0.add(box2); box0.add(Box.createVerticalStrut(10));
        box0.add(box3); box0.add(Box.createVerticalStrut(10));
        box0.add(box4); box0.add(Box.createVerticalStrut(10));
        box0.add(box5); box0.add(Box.createVerticalStrut(10));
        box0.add(box6);
        p1.add(box0);


        p2=new JPanel();
        //我的奖惩界面
        try{
            //连接Mysql数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
            Statement statement=conn.createStatement();
            String sqlString="select * from 奖惩信息 where ID=";
            sqlString+="'"+selecty+"'";
            rs=statement.executeQuery(sqlString);
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null,"查询失败");
            }
            else {
                rs.last();
                int n=rs.getRow(),i=0;
                rs.first();
                data1=new Object[n][4];
                while(i<n){
                    data1[i]=new Object[]{rs.getString(1),
                    rs.getString(2),rs.getDate(3),rs.getString(4)};
                    rs.next();
                    i++;
                }
            }
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        column1=new String[4];
        column1[0]="员工编号";column1[1]="记录编号"; column1[2]="记录时间"; column1[3]="记录原因";
        jTable1=new JTable(data1,column1){
            private static final long serialVersionUID=1L;
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        };
        jTable1.setRowHeight(20);
        scrollPane1=new JScrollPane(jTable1);
        jTable1.setPreferredScrollableViewportSize(new Dimension(500,500));
        p2.add(scrollPane1);
        jTabbedPane.add("我的奖惩",p2);


        p3=new JPanel();
        //主要是培训信息
        try{//连接MySQL数据库
            //JLabel label1=new JLabel("我的培训");
            //label1.setFont();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
            Statement statement=conn.createStatement();
            String sqlString="select * from 培训信息 where ID='"+selecty+"'";
            rs=statement.executeQuery(sqlString);
            data2=new Object[1][5];
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"查询失败");

            }
            else {
                rs.last();
                int n=rs.getRow(),i=0;
                rs.first();
                data2=new Object[n][5];
                while(i<n){
                    data2[i]=new Object[]{
                            rs.getString(1),rs.getString(5),
                            rs.getDate(2),
                            rs.getString(3),rs.getString(4)
                    };
                    rs.next();
                    i++;
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        column2=new String[5];
        column2[0]="员工编号";column2[1]="培训编号";column2[2]="培训日期";column2[3]="培训地点"; column2[4]="培训内容";
        jTable2=new JTable(data2,column2){
            private static final long serialVersionUID=1L;
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        scrollPane2=new JScrollPane(jTable2);
        jTable2.setPreferredScrollableViewportSize(new Dimension(500,500));
        jTable2.setRowHeight(20);
        p3.add(scrollPane2);
        jTabbedPane.add("我的培训",p3);



        p4=new JPanel();
        //连接数据库，这个是关于我的工资内容
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","root","");
            Statement statement=conn.createStatement();
            String sqlString="select * from 薪资信息 where ID='"+selecty+"'";
            rs=statement.executeQuery(sqlString);
            data3=new Object[1][4];
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"查询失败");
            }
            else{
                rs.last();
                int n=rs.getRow(),i=0;
                rs.first();
                data3=new Object[n][4];
                while(i<n){
                    data3[i]=new Object[]{
                            rs.getString(1),rs.getString(4),rs.getString(2),rs.getString(3)

                    };
                    rs.next();i++;
                }
            }
        }
        catch(Exception EE)
        {
            EE.printStackTrace();
        }
        column3=new String[4];
        column3[0]="员工编号";column3[1]="月份";column3[2]="基本工资";column3[3]="奖金";
        jTable3=new JTable(data3,column3){
            private static final long serialVersionUID=1L;
            public boolean isCellEditable(int rowIndex,int columnIndex)
            {
                return false;
            }
        };
        scrollPane3=new JScrollPane(jTable3);
        jTable3.setPreferredScrollableViewportSize(new Dimension(500,400));
        jTable3.setRowHeight(20);
        p4.add(scrollPane3);
        jTabbedPane.add("我的工资",p4);

        this.setSize(600,600);
        this.setVisible(true);
    }

    public class MenuHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==item1)
            {
                System.exit(0);
            }
            else if(event.getSource()==item2)
            {
                dispose();
                Main main=new Main();
                setContentPane(main);
                setVisible(true);
            }
            else if(event.getSource()==item3)//搜索奖惩
            {
                dispose();
                SearchJCInfo searchJCInfo=new SearchJCInfo(selecty);
                setContentPane(searchJCInfo);
                setVisible(true);
            }
            else if(event.getSource()==item4)//搜索培训
            {
                dispose();
                SearchPXInfo searchPXInfo=new SearchPXInfo(selecty);
                setContentPane(searchPXInfo);
                setVisible(true);

            }
            else if(event.getSource()==item5)//搜索工资
            {
                dispose();
                SearchWageInfo searchWageInfo=new SearchWageInfo(selecty);
                setContentPane(searchWageInfo);
                setVisible(true);
            }
        }
    }

}