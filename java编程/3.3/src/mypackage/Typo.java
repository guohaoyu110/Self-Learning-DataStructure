package mypackage;
import javax.swing.JOptionPane;
public class Typo {
    public static void main(String args[])
    {
    	int R,number=0;
    	String s=JOptionPane.showInputDialog(null,"Enter an input","请输入一个二进制数",JOptionPane.QUESTION_MESSAGE);
    	R=Integer.valueOf(JOptionPane.showInputDialog(null,"Enter an input","转换成的目标进位置",JOptionPane.QUESTION_MESSAGE));
    	int len=s.trim().length();
    	for(int i=0;i<len;i++)
    	{
    		number=number*2+(s.charAt(i)-'0');
    	}
    	JOptionPane.showMessageDialog(null,"二进制数："+s+"\n对应"+R+"进制数："+convert(number,R),"结果",JOptionPane.PLAIN_MESSAGE);
        
    }
	public static String convert(int number,int R)
	{
		String s="";
		int c;
		char s1[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		while(number>0)
		{
			s=s1[number%R]+s;
			number=number/R;
			
		}
		return s;
	}
}
