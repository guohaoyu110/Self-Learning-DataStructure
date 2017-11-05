import java.util.Scanner;

public class Main
{
    static int record = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String line = null;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line.length() > 0)
            {
                char[] a = line.toCharArray();
                switch(a[0])
                {
                    case '#' :Title(a);break;
                    case '*' :Ulist(a);break;
                    default :Inline(a);
                }
            }
            else if(record == 1){
                System.out.println();
                System.out.printf("</ul>");
                record = 0;
            }

        }

    }
    public static void Inline(char[] a)
    {
        // TODO Auto-generated method stub
        System.out.println();
        System.out.printf("<p>");
        int flag = 0,flag2 = 0,j = 0;
        char[] b = new char[100];
        for(int i = 0;i < a.length;i++)
        {
            if(a[i] == '_'){
                if(flag == 0){
                    System.out.printf("<em>");
                    flag = 1;
                    continue;
                }
                if(flag == 1){
                    flag = 0;
                    System.out.printf("</em>");

                }
            }
            else if(flag2 == 1)
            {
                if(a[i] == ']'){
                    flag2 = 0;
                    continue;
                }
                b[j] = a[i];
                j++;

            }
            else if(a[i] == '[')
            {
                flag2 = 1;
            }
            else if(a[i] == '('){
                System.out.printf("<a href=\"");
            }
            else if(a[i] == ')'){
                System.out.printf("\">");
                for(int o = 0;b[o] != 0;o++)
                    System.out.print(b[o]);
                System.out.printf("</a>");
            }
            else{
                System.out.print(a[i]);
            }
        }
        System.out.printf("</p>");
    }


    public static void Ulist(char[] a) {
        // TODO Auto-generated method stub
        System.out.println();
        if(record == 0){
            System.out.println("<ul>");
        }
        System.out.printf("<li>");
        for(int j = 2;j<a.length;j++){
            System.out.print(a[j]);
        }
        System.out.printf("</li>");
        record = 1;
    }

    public static void Title(char[] a) {
        // TODO Auto-generated method stub
        System.out.println();
        int sum = 0,i;
        for(i=0;i < a.length;i++)
        {
            if(a[i] == '#')
                sum++;
        }
        System.out.printf("<h" + sum + ">");

        int flag = 0,flag2 = 0,j = 0;
        char[] b = new char[100];
        for(i = sum + 1;i < a.length;i++){
            if(a[i] == '_'){
                if(flag == 0){
                    System.out.printf("<em>");
                    flag = 1;
                    continue;
                }
                if(flag == 1){
                    flag = 0;
                    System.out.printf("</em>");

                }
            }
            else if(flag2 == 1)
            {
                if(a[i] == ']')
                {
                    flag2 = 0;
                    continue;
                }
                b[j] = a[i];
                j++;

            }
            else if(a[i] == '[')
            {
                flag2 = 1;
            }
            else if(a[i] == '(')
            {
                System.out.printf("<a href=\"");
            }
            else if(a[i] == ')')
            {
                System.out.printf(">");
                for(int o = 0;b[o] != ' ';o++)
                    System.out.print(b[o]);
            }
            else
            {
                System.out.print(a[i]);

            }
        }
        System.out.printf("</h" + sum + ">");
    }

}