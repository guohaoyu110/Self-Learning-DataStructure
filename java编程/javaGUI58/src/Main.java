import com.sun.tools.javah.Util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{
    private JButton plainButton,fancyButton;
    public Main(){
        super("JButton的程序设计");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        plainButton=new JButton("文本按钮");
        container.add(plainButton);
        Icon bug1=new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2=new ImageIcon(getClass().getResource("bug2.gif"));
        fancyButton=new JButton("文本图像按钮",bug1);
        fancyButton.setRolloverIcon(bug2);
        container.add(fancyButton);
        ButtonHandler handler=new ButtonHandler();
       // fancyButton.setRolloverIcon(bug2);
        fancyButton.addActionListener(handler);
        plainButton.addActionListener(handler);
        setSize(1000,1000);
        setVisible(true);
    }
    public class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(Main.this,"你按下的是："+event.getActionCommand());
        }
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
