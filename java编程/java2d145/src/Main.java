import java.awt.*;
import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        super("设置字体");
        setSize(420,225);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("楷体",Font.BOLD,12));
        g.drawString("楷体 12 bold .",20,50);
        g.setFont(new Font("宋体",Font.PLAIN,14));
        g.drawString("宋体 14 plain.",20,100);
        g.setColor(Color.red);
        g.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,18));
        g.drawString(g.getFont().getName()+g.getFont().getSize()+"bold italic.",20,120);
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
