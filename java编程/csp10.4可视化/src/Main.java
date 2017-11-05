import java.awt.*;
import javax.smartcardio.Card;
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener{
    private JButton buttons[];
    private BorderLayout layout;
    private final String names[]={"运算","画图","退出","清屏"};
    private Container container;
    private JTextField field1,field2,fields[];
    private JLabel label1,label2,labels[];
    public Main() {
        super("交通枢纽可视化");
        layout = new BorderLayout(5, 5);
        container = getContentPane();
        label1=new JLabel("枢纽数量：");
        label2=new JLabel("隧道数量：");
        field1=new JTextField(5);
        field2=new JTextField(5);
        container.add(label1,BorderLayout.NORTH);
        container.add(label2,BorderLayout.NORTH);
        container.add(field1,BorderLayout.NORTH);
        container.add(field2,BorderLayout.NORTH);

        
        buttons = new JButton[4];//设计4个按钮
        for (int count = 0; count < 4; count++) {
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
        }
        container.add(buttons[0], BorderLayout.SOUTH);
        container.add(buttons[1], BorderLayout.SOUTH);
        container.add(buttons[2], BorderLayout.SOUTH);
        container.add(buttons[3], BorderLayout.SOUTH);
        setSize(300,200);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent event) {
        if(event.getSource()==buttons[0]) {
            int s=Integer.parseInt(field1.getText());
            int w=Integer.parseInt(field2.getText());
            for(int i=0;i<w;i++)
            {

            }

        }
        else if(event.getSource()==buttons[1]) {

        }
        else if(event.getSource()==buttons[2]){

        }
        else if(event.getSource()==buttons[3]){

        }
    }

    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
