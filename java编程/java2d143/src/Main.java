import java.awt.*;
import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        super("颜色的使用");
        setSize(400,130);
        setVisible(true);
    }
public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(255,0,0));
        g.fillRect(25,25,100,20);
        g.drawString("Current RGB:"+g.getColor(),130,45);
        g.setColor(new Color(0.0f,1.0f,0.0f));
        g.fillRect(25,50,100,20);
        g.drawString("Current RGB:"+g.getColor(),130,65);
        g.setColor(Color.blue);
        g.fillRect(25,75,100,20);
        g.drawString("Current RGB"+g.getColor(),130,90);
}
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
