package mypackage;
import java.util.Scanner;
public class Textcmp{
			public static void main(String[] args) {
					String a,b;
					int i1=0,i2=0;
					Scanner s1=new Scanner(System.in);
					System.out.println("请输入字符串a:");
					a=s1.next();
					System.out.println("请输入字符串b：");
					b=s1.next();
					int length1=a.length();//计算第一个字符串的长度
					int length2=b.length();//计算第二个字符串的长度
					for(int i=0;i<length1;i++)
						for(int j=0;j<length2;j++)
						{	
							if(a.charAt(i)==b.charAt(j))//将字符串的字符逐个按行输出
								{
									i1++;
									break;
						}
					
						}//1中的字在2中多少次重复出现
						for(int j=0;j<length2;j++)
							for(int i=0;(i<length1);i++)
							{	
								if(b.charAt(j)==a.charAt(i))
									{
										i2++;
										break;
									}	
							}
						float count1=(float)i1/(float)length2;
						float count2=(float)i2/(float)length1;
						System.out.printf("两行字符串的字符雷同的百分率:");
						float dp=(count1+count2)/(float)2.0;
						System.out.println(dp*100+"%");
					}
}
