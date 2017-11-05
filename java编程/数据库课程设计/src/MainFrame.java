/**
 * Created by haoyuguo on 28/06/2017.
 */
//管理员登录界面
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame implements  ActionListener
{

    JMenuBar jMenuBar1=new JMenuBar();
    JMenu jMenuFile=new JMenu("文件");
    JMenuItem item1=new JMenuItem("退出");
    JMenuItem item2=new JMenuItem("返回");
    JMenu jMenu1=new JMenu("员工管理");
    JMenuItem jMenuItem1=new JMenuItem("员工操作");
    JMenuItem jMenuItem2=new JMenuItem("浏览全部员工信息");
    JMenu jMenu2=new JMenu("部门管理");
    JMenuItem jMenuItem3=new JMenuItem("部门操作");
    JMenuItem jMenuItem4=new JMenuItem("浏览所有部门信息");
    JMenu jMenu3=new JMenu("培训管理");
    JMenuItem jMenuItem5=new JMenuItem("培训操作");
    JMenuItem jMenuItem6=new JMenuItem("浏览所有培训信息");
    JMenu jMenu4=new JMenu("奖惩管理");
    JMenuItem jMenuItem7=new JMenuItem("奖惩操作");
    JMenuItem jMenuItem8=new JMenuItem("浏览所有奖惩信息");
    JMenu jMenu5=new JMenu("薪资信息");
    JMenuItem jMenuItem9=new JMenuItem("薪资操作");
    JMenuItem jMenuItem10=new JMenuItem("浏览所有薪资");
    JMenu jMenu6=new JMenu("职务信息");
    JMenuItem jMenuItem11=new JMenuItem("职务操作");
    JMenuItem jMenuItem12=new JMenuItem("浏览所有职务");
    public MainFrame()
    {
        JPanel contentpane=(JPanel)getContentPane();
        contentpane.setLayout(new BorderLayout());
        setSize(new Dimension(700,410));//面积类对象
        setTitle("管理员操作界面");
        setJMenuBar(jMenuBar1);
        jMenuBar1.add(jMenuFile); jMenuBar1.add(jMenu1); jMenuBar1.add(jMenu2); jMenuBar1.add(jMenu3); jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5); jMenuBar1.add(jMenu6);
        jMenuFile.add(item1);//退出按钮
        jMenuFile.add(item2);
        jMenu1.add(jMenuItem1); jMenu1.add(jMenuItem2);
        jMenu2.add(jMenuItem3); jMenu2.add(jMenuItem4);
        jMenu3.add(jMenuItem5); jMenu3.add(jMenuItem6);
        jMenu4.add(jMenuItem7); jMenu4.add(jMenuItem8);
        jMenu5.add(jMenuItem9); jMenu5.add(jMenuItem10);
        jMenu6.add(jMenuItem11); jMenu6.add(jMenuItem12);

        item1.addActionListener(this);item2.addActionListener(this);jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);jMenuItem3.addActionListener(this);jMenuItem4.addActionListener(this);
        jMenuItem5.addActionListener(this); jMenuItem6.addActionListener(this); jMenuItem7.addActionListener(this);
        jMenuItem8.addActionListener(this); jMenuItem9.addActionListener(this);jMenuItem10.addActionListener(this);
        jMenuItem11.addActionListener(this); jMenuItem12.addActionListener(this);
        
        Icon bug=new ImageIcon(getClass().getResource("mac.jpeg"));
        JLabel label=new JLabel(bug,SwingConstants.CENTER);
        contentpane.add(label,BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==item1)
        {
            System.exit(0);
        }
        else if(actionEvent.getSource()==item2)
        {
            dispose();
            MainFrame mainFrame=new MainFrame();
            setContentPane(mainFrame);
            setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem1)//员工操作
        {
            EmployeeInfo employeeInfo=new EmployeeInfo();
            this.remove(this.getContentPane());
            this.setContentPane(employeeInfo);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem2)//浏览员工信息
        {
            ListEmpPanel listEmpPanel=new ListEmpPanel();
            this.remove(this.getContentPane());
            this.setContentPane(listEmpPanel);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem3)//部门操作
        {
            //dispose();
            DepatInfo depatInfo=new DepatInfo();
            this.remove(this.getContentPane());
            this.setContentPane(depatInfo);
            this.setVisible(true);

        }
        else if(actionEvent.getSource()==jMenuItem4)//浏览部门信息
        {
            ListDeptPanel listDeptPanel=new ListDeptPanel();
            this.remove(this.getContentPane());
            this.setContentPane(listDeptPanel);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem5)//培训操作
        {
            PXInfo pxInfo=new PXInfo();
            this.remove(this.getContentPane());
            this.setContentPane(pxInfo);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem6)//浏览培训信息
        {
            ListPXPanel listPXPanel=new ListPXPanel();
            this.remove(this.getContentPane());
            this.setContentPane(listPXPanel);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem7)//奖惩操作
        {
            JCInfo jcInfo=new JCInfo();
            this.remove(this.getContentPane());
            this.setContentPane(jcInfo);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem8)//浏览奖惩信息
        {
            ListJCPanel listJCPanel=new ListJCPanel();
            this.remove(this.getContentPane());
            this.setContentPane(listJCPanel);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem9)//薪资操作
        {
            SalaryInfo salaryInfo=new SalaryInfo();
            this.remove(this.getContentPane());
            this.setContentPane(salaryInfo);
            this.setVisible(true);

        }
        else if(actionEvent.getSource()==jMenuItem10)//浏览薪资操作
        {
            ListWagePanel listWagePanel=new ListWagePanel();
            this.remove(this.getContentPane());
            this.setContentPane(listWagePanel);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem11)//职务操作
        {
            JobInfo jobInfo=new JobInfo();
            this.remove(this.getContentPane());
            this.setContentPane(jobInfo);
            this.setVisible(true);
        }
        else if(actionEvent.getSource()==jMenuItem12)//浏览职务信息

        {
            ListJobPanel listJobPanel=new ListJobPanel();
            this.remove(this.getContentPane());
            this.setContentPane(listJobPanel);
            this.setVisible(true);
        }
    }

}
