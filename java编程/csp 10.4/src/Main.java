import java.util.Scanner;
public class Main {

    public static int prim(int graph[][],int n)
    {
        int lowcost[]=new int[100];//存储最小的权值
        int mst[]=new int[100];
        int i,j,min,minid,sum=0;
        for(i=2;i<=n;i++)
        {
            lowcost[i]=graph[1][i];
            mst[i]=1;
        }
        mst[1]=0;//这边是定义一个开始的初始比较值
        for (i = 2; i <= n; i++)
        {
            min = 0x7fffffff;//表示long int的最大值
            minid = 0;
            for (j = 2; j <= n; j++)
            {
                if (lowcost[j] < min && lowcost[j] != 0)
                {
                    min = lowcost[j];
                    minid = j;
                }
            }
            //cout << "V" << mst[minid] << "-V" << minid << "=" << min << endl;
            System.out.println("V"+mst[minid]+"-V"+minid+"="+min);
            sum += min;
            lowcost[minid] = 0;
            for (j = 2; j <= n; j++)
            {
                if (graph[minid][j] < lowcost[j])
                {
                    lowcost[j] = graph[minid][j];
                    mst[j] = minid;
                }
            }
        }

        return sum;
    }
    public static void main(String args[]){
        int n,m,cost;
        int graph[][]=new int[100][100];
        Scanner s=new Scanner(System.in);
        m=s.nextInt();
        n=s.nextInt();
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=m;j++)
            {
                graph[i][j]=0x7fffffff;//设置图的初始值
            }
        }
        for(int k=1;k<=n;k++){
            int x,y,z;
            x=s.nextInt();
            y=s.nextInt();
            z=s.nextInt();
            graph[x][y]=z;
            graph[y][x]=z;
        }
        cost=prim(graph,m);
        System.out.println(cost);

    }
}

