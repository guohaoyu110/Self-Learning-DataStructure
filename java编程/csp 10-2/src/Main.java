import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	// write your code here
      int n,m,p,q,i,w;
      Scanner s=new Scanner(System.in);
      int a[]=new int[1001];
      //int b[]=new int[1000];
      //int c[]=new int[1000];
       n=s.nextInt();//输入中学生人数
       m=s.nextInt(); //输入调整的次数
      for(i=1;i<=n;i++){
          a[i]=i;
      }
      for(int j=1;j<=m;j++)//一共有m次调整
      {
          p=s.nextInt();
          q=s.nextInt();
          for(i=1;i<=n;i++)
          {
              if(a[i]!=p) continue;
              else {
                  if (q > 0) {
                      for (w = i; w < i + q; w++) {
                          a[w] = a[w + 1];
                      }
                      a[w] = p;
                  }
                  else if (q < 0)
                  {
                      for (w = i; w > i + q; w--) {
                          a[w] = a[w - 1];
                      }
                      a[w] = p;
                  }
                  break;
              }
          }
      }
        for(i=1;i<=n;i++)
            System.out.print(a[i]+" ");
    }
}
