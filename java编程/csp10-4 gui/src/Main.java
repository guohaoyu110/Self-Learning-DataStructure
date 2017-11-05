
/**
 * Created by haoyuguo on 07/05/2017.
 */

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{

    public static JLabel label[];
    public static JLabel label2[];
    public static final int MAXN = 100;
    public static final int INF = 100000;
    public static int[][] map = new int[MAXN][MAXN];
    public static int[] lowcost = new int[MAXN];
    public static int[] nearvex = new int[MAXN];
    public static int count=0;


    public static int n, m=10;
    public static int x[][];
    public static int y[][]=new int[n][2];
    public Main()
    {
        super("交通枢纽问题");

        this.setSize(800,800);

        this.setVisible(true);

    }

    public void paint(Graphics g)
    {
        super.paint(g);

        x=new int [n][2];


        for(int i=0;i<n;i++)
        {

            g.setColor(Color.BLACK);
            if(i%2==1)
            {	g.fillOval(400+i*50,400-20*i*(i-3), 10, 10);
                x[i][0]=400+i*50+5;
                x[i][1]=400-20*i*(i-3)+5;
            }
            else
            {	g.fillOval(400+i*50,400+20*i*(i-3), 10, 10);
                x[i][0]=400+i*50+5;
                x[i][1]=400+20*i*(i-3)+5;
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(map[i][j]!=INF)
                {
                    g.drawLine(x[i][0],x[i][1], x[j][0], x[j][1]);
                }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                    if(lowcost[i]==map[j][k])
                    {
                        g.setColor(Color.RED);
                        g.drawLine(x[j][0], x[j][1], x[k][0], x[k][1]);
                    }
        }
    }



    public static void main(String[] args)
    {
        test t1=new test();

/*	Scanner scan = new Scanner(System.in);*/
        t1.button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String a;test t1=new test();
                a=t1.j1.getText();
                n=Integer.parseInt(a);
                a=t1.j2.getText();
                m=Integer.parseInt(a);

            }
        });


        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    map[i][j] = 0;
                }
                else
                {
                    map[i][j] = INF;
                    map[j][i] = INF;
                }
            }
        }

        t1.button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String a;test t1=new test();
                a=t1.j3.getText();
                int u=Integer.parseInt(a);
                a=t1.j4.getText();
                int v=Integer.parseInt(a);
                a=t1.j5.getText();
                int w=Integer.parseInt(a);
                Main.map[u-1][v-1]=w;
                Main.map[v-1][u-1]=w;
                t1.j3.setText("");
                t1.j4.setText("");
                t1.j5.setText("");
                Main.count++;
            }
        });
/*	for (int i = 0; i < m; i++)
	{
	int u = scan.nextInt();
	int v = scan.nextInt();
	int w = scan.nextInt();
	map[u - 1][v - 1] = w;
	map[v - 1][u - 1] = w;
	}*/

        t1.button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(Main.count==Main.m)
                {

                    prim(0);
                    new Main();

                }
            }
        });
    }


    static void prim(int u)
    {

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                if(map[i][j]==0&&i!=j)
                {
                    map[i][j]=INF;
                }
        }

        int sum = 0;
        int min = 0;
        for (int i = 0; i < n; i++)
        {
            lowcost[i] = map[u][i];

            nearvex[i] = u;
        }
        nearvex[u] = -1;
        for (int i = 0; i < n - 1; i++)
        {
            int u0 = -1;
            min = 1000000;
            for (int j = 0; j < n; j++)
            {
                if(lowcost[j] < min && nearvex[j] != -1)
                {
                    u0 = j;
                    min = lowcost[j];
                }
            }

            if (u0 != -1)
            {
                sum += lowcost[u0];
                nearvex[u0] = -1;
                for (int k = 0; k < n; k++)
                {
                    if (nearvex[k] != -1 && map[u0][k] < lowcost[k])
                    {
                        lowcost[k] = map[u0][k];
                        nearvex[k] = u0;
                    }
                }

            }
        }



    }


}

