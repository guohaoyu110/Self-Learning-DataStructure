import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by mm on 2017/5/4.
 */
public class In extends JFrame{
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private JFrame in = new JFrame();
    private JLabel stationnum, subnum, space;
    private JTextField Stationnum, Subnum;
    private JButton sure;
    public In() {
        in.setTitle("输入");
        in.setSize(600, 300);// 窗口大小
        in.setLocationRelativeTo(null);// 窗口居中
        in.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        in.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "退出系统", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        in.setLayout(new GridBagLayout());
        stationnum = new JLabel("交通枢纽数:");
        addComponent(in, stationnum, 0, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        Stationnum = new JTextField();
        Stationnum.setHorizontalAlignment(JTextField.CENTER);
        addComponent(in, Stationnum, 1, 0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        subnum = new JLabel("候选隧道数:");
        addComponent(in, subnum, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        Subnum = new JTextField();
        Subnum.setHorizontalAlignment(JTextField.CENTER);
        addComponent(in, Subnum, 1, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        sure = new JButton("确定");
        addComponent(in, sure, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        space = new JLabel("                 ");
        addComponent(in, space, 2, 2, 1, GridBagConstraints.EAST, GridBagConstraints.EAST);
        sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final int n = Integer.parseInt(Stationnum.getText());
                final int m = Integer.parseInt(Subnum.getText());
                in.dispose();
                new Main(n, m).setVisible(true);
            }
        });
    }
    private static void addComponent(Container container, Component component, int gridx, int gridy,
                                     int gridwidth, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, 1, 1.0, 1.0,
                anchor, fill, insets, 0, 0);//建立网格包对象
        container.add(component, gbc);//添加到容器中
    }
    public static void main(String[] args)
    {
        new In().in.setVisible(true);
    }
}

