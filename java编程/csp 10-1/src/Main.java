import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
      int n,k;
      Scanner s=new Scanner(System.in);
      n=s.nextInt();//输入一共有多少块蛋糕
      k=s.nextInt();//重量至少是多少
      int a[]=new int[1000];
      int sum=0,count=0;
      for(int i=0;i<n;i++){
          a[i]=s.nextInt();
          sum+=a[i];
          if(sum>=k){
              count++;
              sum=0;
          }
          else {
             if(i==n-1)
                 count++;
          }
      }
      System.out.println(count);
    }
}
