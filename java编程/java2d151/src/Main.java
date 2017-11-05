import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        super("to paint 2d graph");
        setSize(600,200);
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(new GradientPaint(5,40,Color.blue,15,50,Color.yellow,true));
        g2d.fill(new Ellipse2D.Double(5,40,65,110));
       // g2d.setPaint(Color.red);
        //g2d.setStroke(new BasicStroke(10.0f));
       // g2d.draw(new Rectangle2D.Double(5,40,65,110));
        //g2d.fill(new Ellipse2D.Double(5,40,65,110));
        g2d.setPaint(Color.red);
        g2d.setStroke(new BasicStroke(10.0f));
        g2d.draw(new Rectangle2D.Double(80,40,65,110));
        BufferedImage bi=new BufferedImage(5,5,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D big=bi.createGraphics();
        big.setColor(Color.blue);
        big.fillRect(0,0,5,5);
        big.setColor(Color.yellow);
        big.fillOval(0,0,5,5);
        Rectangle r=new Rectangle(0,0,5,5);
        TexturePaint tp=new TexturePaint(bi,r);
        g2d.setPaint(new TexturePaint(bi,new Rectangle(0,0,5,5)));
        g2d.fill(new RoundRectangle2D.Double(155,40,75,110,50,50));
        g2d.setPaint(Color.green);
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.draw(new Arc2D.Double(240,40,75,110,0,270,Arc2D.PIE));
        g2d.setPaint(Color.yellow);
        g2d.draw(new Line2D.Double(395,30,320,150));
        float dashes[]={10,6};
        g2d.setPaint(Color.red);
        g2d.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,0));
        g2d.draw(new Line2D.Double(320,30,395,150));
        //用通用路径画四面体
        float x[]=new float[4];
        float y[]=new float[4];
        x[0]=500;y[0]=30;
        x[1]=500;y[1]=130;
        x[2]=450;y[2]=180;
        x[3]=550;y[3]=180;
        g2d.setPaint(Color.yellow);
        g2d.setStroke(new BasicStroke(4));
        GeneralPath tour=new GeneralPath();
        tour.moveTo(x[0],y[0]);
        for(int i=1;i<x.length;i++){
            tour.lineTo(x[i],y[i]);
        }
        tour.lineTo(x[1],y[1]);tour.lineTo(x[0],y[0]);
        tour.lineTo(x[3],y[3]);tour.lineTo(x[2],y[2]);
        tour.lineTo(x[0],y[0]);
        tour.closePath();
        g2d.draw(tour);
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
