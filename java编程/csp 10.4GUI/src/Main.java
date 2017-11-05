
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    static int INF = Integer.MAX_VALUE;
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private JPanel in = new JPanel(new GridBagLayout());// 设置布局网格式布局
    private JLabel title, information[];
    private JTextField Information[];
    private JButton graphics, clean, exit;
    private Gp gp = new Gp();
    private int start[], finish[], day[];
    public Main(int n, int m)
    {
        setTitle("个人设置");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        // 全屏设置
        gd.setFullScreenWindow(this);
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int i=JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "退出系统", JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        setLayout(new BorderLayout(5,5));
        int s[]=new int[n]; //交通隧道数组
        int num[][]=new int[n-1][n];  //从纵坐标到横坐标+1要多长时间
        for(int i=0;i<n-1;i++)      //初始化最大
        {
            for(int j=0;j<n;j++)
                num[i][j]=INF;
            s[i]=INF;
        }
        s[n-1]=INF;
        gp.setBackground(Color.gray);
        information = new JLabel[m];
        Information = new JTextField[m];
        title = new JLabel("输入格式:   a b c  表示枢纽a和枢纽b之间可以修建一条隧道，需要的时间为c天");
        title.setForeground(Color.red);
        addComponent(in, title, 0, 0, 3, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        for(int i = 0; i < m; i++)
        {
            information[i] = new JLabel("输入第"+(i+1)+"个候选隧道信息:");
            addComponent(in, information[i], 0, (2*i+1), 3, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
            Information[i] = new JTextField();
            Information[i].setHorizontalAlignment(JTextField.CENTER);
            addComponent(in, Information[i], 0, (2*i+2), 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        }
        graphics = new JButton("画图");
        //graphics.setFont(new Font("幼圆",Font.PLAIN,13));
        addComponent(in, graphics, 0, (2*m+1), 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        clean = new JButton("清屏");
        addComponent(in, clean, 1, (2*m+1), 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        exit = new JButton("退出");
        addComponent(in, exit, 2, (2*m+1), 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.clean();
            }
        });
        graphics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = new int[m];
                finish = new int[m];
                day = new int[m];
                for(int i = 0; i < m; i++)
                {
                    String st = Information[i].getText();
                    st = st.replaceAll("　", " ");//将全角空格变成半角
                    st = st.replaceAll("\\s+", " ");//将多个连续空格变成一个
                    st = st.trim();
                    String an [] = st.split(" ");
                    if(an.length != 3)
                    {
                        JOptionPane.showMessageDialog(null, "请正确输入三个正整数并用空格分隔", "通知", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else
                    {
                        start[i] = Integer.parseInt(an[0]);
                        finish[i] = Integer.parseInt(an[1]);
                        day[i] = Integer.parseInt(an[2]);
                        num[start[i]-1][finish[i]-1] = day[i];
                    }
                }
                for(int j=1;j<n;j++)
                    if(num[0][j]<s[j])
                        s[j]=num[0][j];//
                int in_S,in_D;
                String road[] = new String[n];
                for(int i=1;i<n;i++)
                {
                    road[i] = "0 "+i;
                }
                for(int i=1;i<n;i++) //从第一个开始到（i+1）的有意义的时间
                {
                    if(s[i]!=INF)
                    {
                        in_S=s[i];//从0到i的时间
                        for(int j=i+1;j<n;j++)
                        {
                            if(num[i][j]!=INF)
                            {
                                if(in_S>num[i][j])
                                {
                                    in_D=in_S;
                                }else
                                {
                                    in_D=num[i][j];
                                }
                                if(s[j]>in_D)
                                {
                                    s[j]=in_D;
                                    road[j] = road[i]+" "+j;
                                }
                            }
                        }
                    }
                }
                gp.draw(start, finish, day, n, road[n-1]);
            }
        });
        add(in, BorderLayout.EAST);
        add(gp, BorderLayout.CENTER);
    }
    private static void addComponent(Container container, Component component, int gridx, int gridy,
                                     int gridwidth, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, 1, 1.0, 1.0,
                anchor, fill, insets, 0, 0);//建立网格包对象
        container.add(component, gbc);//添加到容器中
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
