package mypackage;
//将一个数通过位操作进行扩大100倍的运算
import java.util.Scanner;

public class Bitcode{
	public static void main(String args[])
	{
		int a,b;
		Scanner s1=new Scanner(System.in);
		System.out.println("please input an integer:");
		a=s1.nextInt();
		b=(a<<5)+(a<<6)+(a<<2);
		System.out.printf("将输入的数字用位运算扩大一百倍:%d",b);
	}
}