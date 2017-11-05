import java.util.Scanner;
import java.lang.*;
//炉石传说
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s=new Scanner(System.in);
        int n;//输入操作的个数
        n=s.nextInt();
        int a[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
          String str=s.next();
          switch(str.charAt(0))
            {
                case 's'://summon
                    int position=s.nextInt();
                    int attack=s.nextInt();
                    int health=s.nextInt();
                    break;
                case 'a'://attak
                    int attacker=s.nextInt();
                    int defender=s.nextInt();
                    break;
                case 'e'://end
                    break;

            }
        }
    }
}
