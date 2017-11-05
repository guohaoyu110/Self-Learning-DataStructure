import java.util.*;
public class Main {
    static int m;
    public static void main(String[] args) {
	// write your code here
        Scanner s=new Scanner(System.in);
        m=s.nextInt();double sum=0;
        int num[]=new int[m];
        for(int i=0;i<m;i++){
            num[i]=s.nextInt();
            sum+=num[i];
        }
        double average=sum/m;
        System.out.printf("%.3f",average);
        System.out.println();
        double count=2;int j=0;
        for(int i=0;i<m;i++){
            double k=Math.abs((double)num[i]-average);
            if(k<count)
            {
                count=k;
                j=i;
            }
        }
        System.out.print(num[j]+" ");
        for(int k=0;k<m;k++)
        {
            if(num[j]==num[k])
                System.out.print(k+" ");
        }

    }
}
