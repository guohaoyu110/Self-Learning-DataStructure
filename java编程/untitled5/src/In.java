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
        stationnum.setFont(new Font("楷体",Font.PLAIN,18));
        addComponent(in, stationnum, 0, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        Stationnum = new JTextField();
        Stationnum.setHorizontalAlignment(JTextField.CENTER);
        Stationnum.setFont(new Font("宋体",Font.PLAIN,18));
        addComponent(in, Stationnum, 1, 0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        subnum = new JLabel("候选隧道数:");
        subnum.setFont(new Font("楷体",Font.PLAIN,18));
        addComponent(in, subnum, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        Subnum = new JTextField();
        Subnum.setHorizontalAlignment(JTextField.CENTER);
        Subnum.setFont(new Font("宋体",Font.PLAIN,18));
        addComponent(in, Subnum, 1, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        sure = new JButton("确定");
        addComponent(in, sure, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        space = new JLabel("                 ");
        addComponent(in, space, 2, 2, 1, GridBagConstraints.EAST, GridBagConstraints.EAST);
        sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(Stationnum.getText());
                int m = Integer.parseInt(Subnum.getText());
                in.dispose();
                new Main(n,m).setVisible(true);
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
class Gp extends JPanel
{
    private int a;
    private int startx[];
    private int starty[];
    private int finishx[];
    private int finishy[];
    private int day[];
    private int n;
    private int start[];
    private int finish[];
    private int xPos[], yPos[];
    private int Road [];
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        if (a != 0) {
            for(int l = 0; l < n; l++)
            {
                g.setColor(Color.white);
                g.fillOval(xPos[l], yPos[l], 5, 5);
                g.drawString((l+1) + "号站", xPos[l]-15, yPos[l]-20);
            }
            for(int i = 0; i < day.length; i++) {
                g.setColor(Color.yellow);
                //System.out.print(Arrays.toString(Road));
                for(int p = 0; p < Road.length-1; p++)
                {
                    if(((start[i] - 1) == Road[p]) && ((finish[i] - 1) == Road[p + 1]))
                    {
                        g.setColor(Color.red);
                    }
                }
                g.drawLine(startx[i], starty[i], finishx[i], finishy[i]);
                g.setColor(Color.cyan);
                g.setFont(new Font("宋体",Font.BOLD,20));
                g.drawString(String.valueOf((day[i])), ((startx[i] + finishx[i]) / 2)- 6 * i, ((starty[i] + finishy[i]) / 2) - 6 * i);
            }
        }
    }
    void draw(int[] start, int[] finish, int[] day, int n, String road)
    {
        a = 1;
        startx = new int[start.length];
        starty = new int[start.length];
        finishx = new int[finish.length];
        finishy = new int[finish.length];
        this.n = n;
        this.start = start;
        this.finish = finish;
        xPos = new int[n];
        yPos = new int[n];
        for(int l = 0; l < n; l++)
        {
            double alfa = Math.toRadians(l*(360/n));
            int xpoint = 500;
            int r = 300;
            xPos[l]= xpoint +(int)(r *Math.sin(alfa));
            int ypoint = 500;
            yPos[l]= ypoint -(int)(r *Math.cos(alfa));
        }
        for(int k = 0; k < day.length; k++) {
            startx[k] = xPos[start[k]-1];
            starty[k] = yPos[start[k]-1];
            finishx[k] = xPos[finish[k]-1];
            finishy[k] = yPos[finish[k]-1];
        }
        this.day = day;
        road = road.trim();
        String rroad[] = road.split(" ");
        Road = StringToInt(rroad);
        repaint();
    }
    void clean()
    {
        a = 0;
        repaint();
    }
    private int[] StringToInt(String[] arrs){
        int[] ints = new int[arrs.length];
        for(int i=0;i<arrs.length;i++){
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }
}
