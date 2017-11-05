import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame {
    private JLabel label1;
    private JButton button;
    private JTextField field1,field2,displayfield;
    public Main(){
        super("小程序查看器");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        label1=new JLabel("请输入两个整型数据:");
        field1=new JTextField(10);
        field2=new JTextField(10);
        displayfield=new JTextField(10);
        container.add(label1);
        container.add(field1);
        container.add(field2);
        container.add(displayfield);
        button=new JButton("比较");
        container.add(button);
        ActionEventHandler handler=new ActionEventHandler();
        button.addActionListener(handler);
        setSize(1000,600);
        setVisible(true);
    }
    public class ActionEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==button){
                int ai=Integer.parseInt(field1.getText());
                int bi=Integer.parseInt(field2.getText());
                Boolean result1= Boolean.valueOf(ai>bi);
                displayfield.setText("12>45="+result1);
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        Main applicatiion=new Main();
        applicatiion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
