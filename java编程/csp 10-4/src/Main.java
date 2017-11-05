import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int i,n,m,k=0,r=0,min,minl=0;
        n=input.nextInt();
        m=input.nextInt();
        int[][]s=new int[n][2];
        int[][]d=new int[m][3];
        for(i=0;i<m;i++)
            for(int j=0;j<3;j++)
                d[i][j]=input.nextInt();

        for(int j=0;j<m;j++){
            min=d[0][2];
            minl=0;
            for(i=0;i<m;i++){//找最小权重的边
                if(d[i][2]<min){
                    min=d[i][2];
                    minl=i;
                }
            }
            boolean flaga=true,flagb=true;//向s中插入新的节点
            for(i=0;i<r;i++){
                if(s[i][0]==d[minl][0])flaga=false;
                if(s[i][0]==d[minl][1])flagb=false;
            }
            if(flaga==true){s[r++][0]=d[minl][0];d[minl][2]=10000;}
            if(flagb==true){s[r++][0]=d[minl][1];d[minl][2]=10000;}
        }
       // for(i=0;i<r;i++)
       //     System.out.printf("%d ", s[i][0]);
        int max=s[0][0];
        for(i=1;i<s.length;i++)
        {
            if(s[i][0]>max)
                max=s[i][0];

        }
        System.out.print(max);
    }
}