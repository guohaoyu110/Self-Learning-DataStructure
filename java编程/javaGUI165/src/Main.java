import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{
    private JTextField field;
    private JRadioButton maleButton,womenButton;
    private ButtonGroup radioGroup;
    public Main()
    {
        super("RadioButton Test");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        JLabel label1=new JLabel("性别：");
        container.add(label1);
        maleButton=new JRadioButton("男",true);
        container.add(maleButton);
        womenButton=new JRadioButton("女",false);
        container.add(womenButton);
        radioGroup=new ButtonGroup();
        radioGroup.add(maleButton);
        radioGroup.add(womenButton);
        maleButton.addItemListener(new RadioButtonHandler());
        womenButton.addItemListener(new RadioButtonHandler());
        field=new JTextField("性别初值是：男");
        container.add(field);
        setSize(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class RadioButtonHandler implements ItemListener{
        public void itemStateChanged(ItemEvent event)
        {
            if(event.getItem()==maleButton)
            {
                field.setText("性别值是：男");
            }
            else if(event.getItem()==womenButton)
                field.setText("性别值是：女");
        }
    }
}
