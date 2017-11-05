import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;
public class Main extends JFrame {
    private JLabel aLabel1,bLabel1;
    private JTextField aField,bField,displayField;
    private JButton computeButton1,computeButton2,exitButton;
    public Main()
    {
        super("求两数的和");
        Container container=getContentPane();//这一句是必须要写的
        container.setLayout(new FlowLayout());//设置布局形式为流式布局
        aLabel1=new JLabel("A:");
        aLabel1.setForeground(Color.red);
        //aLabel1.setFont(BOLD);
        aField=new JTextField(10);
        container.add(aLabel1);
        container.add(aField);
        bLabel1=new JLabel("B:");
        bLabel1.setForeground(Color.red);
        bField=new JTextField(10);
        container.add(bLabel1);
        container.add(bField);
        displayField=new JTextField(30);
        displayField.setEditable(false);
        container.add(displayField);
        computeButton1=new JButton("计算和");
        container.add(computeButton1);
        computeButton2=new JButton("计算差");
        container.add(computeButton2);
        exitButton=new JButton("退出");
        container.add(exitButton);
        ActionEventHandler handler=new ActionEventHandler();
        computeButton1.addActionListener(handler);
        computeButton2.addActionListener(handler);
        exitButton.addActionListener(handler);
        setSize(400,140);
        setVisible(true);
    }
    public class ActionEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            int ai=Integer.parseInt(aField.getText());
            int bi=Integer.parseInt(bField.getText());
            if(event.getSource()==exitButton){
                System.exit(0);
            }
            else if(event.getSource()==computeButton1){

                String result=String.valueOf(ai+bi);
                //String result1=String.valueOf(ai-bi);
               // displayField.setText("a-b="+result1);
                displayField.setText("a+b="+result);
                //displayField.setBackground(Color.red);
            }
            else if(event.getSource()==computeButton2)
            {
                String result1=String.valueOf(ai-bi);
                displayField.setText("a-b="+result1);
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
