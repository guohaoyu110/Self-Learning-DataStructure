/**
 * Created by haoyuguo on 21/04/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mm on 2017/4/14.
 */
public class Stu extends JFrame{
    private JLabel s1_sno , s2_sno , s1_sname , s2_sname ,  s1_grade , s2_grade;
    private JTextField s1_s , s2_s , s1_sn , s2_sn , s1_g , s2_g;
    private JButton ssno , ssname , sgrade;
    private JPanel s1 , s2 , jb;
    private int Sno;
    private String Sname;
    private int Grade;
    public Stu()
    {
        setTitle("排序");
        setSize(600, 160);// 窗口大小
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口则退出虚拟机
        setLayout(new FlowLayout());// 设置布局流式布局
        s1 = new JPanel();
        s1_sno = new JLabel("第一个学生的信息:  学号");
        s1_s = new JTextField(10);
        s1_sname = new JLabel("姓名");
        s1_sn = new JTextField(10);
        s1_grade = new JLabel("成绩");
        s1_g = new JTextField(10);
        s1.add(s1_sno);
        s1.add(s1_s);
        s1.add(s1_sname);
        s1.add(s1_sn);
        s1.add(s1_grade);
        s1.add(s1_g);
        add(s1);
        s2 = new JPanel();
        s2_sno = new JLabel("第二个学生的信息:  学号");
        s2_s = new JTextField(10);
        s2_sname = new JLabel("姓名");
        s2_sn = new JTextField(10);
        s2_grade = new JLabel("成绩");
        s2_g = new JTextField(10);
        s2.add(s2_sno);
        s2.add(s2_s);
        s2.add(s2_sname);
        s2.add(s2_sn);
        s2.add(s2_grade);
        s2.add(s2_g);
        add(s2);
        jb = new JPanel();
        ssno = new JButton("按学号排序");
        ssname = new JButton("按姓名排序");
        sgrade = new JButton("按成绩排序");
        jb.add(ssno);
        jb.add(ssname);
        jb.add(sgrade);
        add(jb);
        ssno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stu> list = new ArrayList<Stu>();
                list.add(new Stu( Integer.parseInt(s1_s.getText()), s1_sn.getText(), Integer.parseInt(s1_g.getText())));
                list.add(new Stu( Integer.parseInt(s2_s.getText()), s2_sn.getText(), Integer.parseInt(s2_g.getText())));
                Collections.sort( list, new sortSno());
                String string = "按学号排序\n";
                for(Stu stu : list)
                {
                    string += stu.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, string, "通知", JOptionPane.CANCEL_OPTION);
            }
        });
        ssname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stu> list = new ArrayList<Stu>();
                list.add(new Stu( Integer.parseInt(s1_s.getText()), s1_sn.getText(), Integer.parseInt(s1_g.getText())));
                list.add(new Stu( Integer.parseInt(s2_s.getText()), s2_sn.getText(), Integer.parseInt(s2_g.getText())));
                Collections.sort( list, new sortSname());
                String string = "按姓名排序\n";
                for(Stu stu : list)
                {
                    string += stu.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, string, "通知", JOptionPane.CANCEL_OPTION);
            }
        });
        sgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Stu> list = new ArrayList<Stu>();
                list.add(new Stu( Integer.parseInt(s1_s.getText()), s1_sn.getText(), Integer.parseInt(s1_g.getText())));
                list.add(new Stu( Integer.parseInt(s2_s.getText()), s2_sn.getText(), Integer.parseInt(s2_g.getText())));
                Collections.sort( list, new sortGrade());
                String string = "按成绩排序\n";
                for(Stu stu : list)
                {
                    string += stu.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, string, "通知", JOptionPane.CANCEL_OPTION);
            }
        });
    }
    public Stu(int sno, String sname, int grade)
    {
        Sno = sno;
        Sname = sname;
        Grade = grade;
    }
    public void setSno(int sno)
    {
        Sno = sno;
    }
    public void setSname(String sname)
    {
        Sname = sname;
    }
    public void setGrade(int grade)
    {
        Grade = grade;
    }
    public int getSno()
    {
        return Sno;
    }
    public String getSname()
    {
        return Sname;
    }
    public int getGrade()
    {
        return Grade;
    }
    public String toString()
    {
        return "学号: " + Sno + "\t  姓名: " + Sname + "\t  成绩: " + Grade;
    }
    static class sortSno implements Comparator<Stu>
    {
        public int compare(Stu s1, Stu s2)
        {
            return s1.getSno() - s2.getSno();
        }
    }
    static class sortSname implements Comparator<Stu>
    {
        public int compare(Stu s1, Stu s2)
        {
            return s1.getSname().compareTo(s2.getSname());
        }
    }
    static class sortGrade implements Comparator<Stu>
    {
        public int compare(Stu s1, Stu s2)
        {
            return s1.getGrade() - s2.getGrade();
        }
    }
    public static void main(String [] args)
    {
        new Stu().setVisible(true);
    }
}
