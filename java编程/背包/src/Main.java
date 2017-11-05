import java.util.*;
public class Main
{
    public static double evaluate(String abs) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        char arr[]=abs.toCharArray();
        for(char c:arr){
            String s=c+"";
           if(s.equals(""));
           else if(s.equals("("));
           else if (s.equals("+")) ops.push(s);
           else if (s.equals("-")) ops.push(s);
           else if (s.equals("*")) ops.push(s);
           else if (s.equals("/")) ops.push(s);
           else if (s.equals(")"))
           {
               String op=ops.pop();
               double v=vals.pop();
               if(op.equals("*")) v=vals.pop()*v;
               else if(op.equals("+")) v=vals.pop()+v;
               else if(op.equals("-")) v=vals.pop()-v;
               else if(op.equals("/")) v=vals.pop()/v;
               vals.push(v);
           }
           else vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        System.out.print(evaluate(s1));
    }
}