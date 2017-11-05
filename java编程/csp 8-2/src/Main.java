import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
        int n;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();//购票指令的数量
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }

        int b[]=new int[20];//标注一共有20行
        int c[][]=new int[20][5];
        for(int i=0;i<n;i++)
        {
            int flag=0;int t=a[i];
            for(int j=0;j<20;j++)
            {
                if((5-b[j])>=a[i])
                {
                    flag=1;
                    b[j]=a[i]+b[j];
                    for(int k=0;k<5;k++)
                    {
                        if((t>0)&&(c[j][k]==0))
                        {
                            t--;
                            c[j][k]=i+1;
                        }
                    }
                    break;
                }
                if(flag==1)
                    break;
            }
            if(flag==0)
            {
                t=a[i];
                for(int m=0;m<20;m++)
                {
                    for(n=0;n<5;n++)
                    {
                        if((t>0)&&c[m][n]==0)
                        {
                            t--;
                            c[m][n]=i+1;
                        }
                        if(t==0)
                            break;
                    }
                    if(t==0)
                        break;
                }

            }
        }
        for(int i=0;i<n;i++)//输出
        {
            int t=a[i];
            for(int m=0;m<20;m++)
            {
                for( n=0;n<5;n++)
                {
                    if((t>0)&&(c[m][n]==i+1))
                    {
                        t--;
                        System.out.print(m*5+n+1+" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
