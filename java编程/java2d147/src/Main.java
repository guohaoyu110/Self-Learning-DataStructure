import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;
import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        super("Drawing lines,rectangle and ovals");
        setSize(850,170);
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.drawLine(5,33,350,33);
        g.setColor(Color.blue);
        g.drawRect(5,40,90,55);
        g.fillRect(100,40,90,55);
        g.setColor(Color.cyan);
        g.fillRoundRect(195,40,90,55,50,50);
        g.drawRoundRect(290,40,90,55,20,20);
        g.setColor(Color.yellow);
        g.draw3DRect(5,100,90,55,true);
        g.fill3DRect(100,100,90,55,false);
        g.setColor(Color.magenta);
        g.drawOval(195,100,90,55);
        g.fillOval(290,100,90,55);
        int i=400;
        g.setColor(Color.yellow);
        g.drawRect(15+i,35,80,80);
        g.setColor(Color.black);
        g.drawArc(15+i,35,80,80,0,360);
        g.setColor(Color.yellow);
        g.drawRect(100+i,35,80,80);
        g.setColor(Color.black);
        g.drawArc(100+i,35,80,80,0,110);
        g.setColor(Color.yellow);
        g.drawRect(185+i,35,80,80);
        g.setColor(Color.black);
        g.drawArc(185+i,35,80,80,0,-270);
        g.fillArc(15+i,120,80,40,0,360);
        g.fillArc(100+i,120,80,40,270,-90);
        g.fillArc(185+i,120,80,40,0,-270);
        int j=700;
        int xValues[]={20+j,40+j,50+j,30+j,20+j,15+j};
        int yValues[]={50,50,60,80,80,60};
        Polygon polygon1=new Polygon(xValues,yValues,6);
        g.drawPolygon(polygon1);
        int xValues2[]={70+j,90+j,100+j,80+j,70+j,65+j,60+j};
        int yValues2[]={100,100,110,110,130,110,90};
        g.drawPolyline(xValues2,yValues2,7);
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
