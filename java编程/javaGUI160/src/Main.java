import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{
    private JTextField textField1,textField2,textField3;
    private JTextArea textArea1,textArea2;
    private JPasswordField passwordField;
    private JButton copyButton;
    public Main()
    {
        super("JTextField,JPasswordField和JTextArea的使用");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        JLabel label1=new JLabel("用户名");
        container.add(label1);
        textField1=new JTextField(10);
        container.add(textField1);
        container.add(new JLabel("口令:"));
        passwordField=new JPasswordField(10);
        container.add(passwordField);
        Icon bug=new ImageIcon(getClass().getResource("czims.jpg"));
        JLabel label2=new JLabel("照片：",bug,SwingConstants.LEFT);
        label2.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setVerticalTextPosition(SwingConstants.BOTTOM);
        container.add(label2);
        textField3=new JTextField("显示用户名或口令",30);
        textField3.setEditable(false);
        container.add(textField3);
        TextFieldHandler handler=new TextFieldHandler();
        textField1.addActionListener(handler);
        passwordField.addActionListener(handler);
        Box box=Box.createHorizontalBox();
        String string="This is a demo string to\n"+"illustrates textarea programming\n";
        textArea1=new JTextArea(string,5,12);
        box.add(new JScrollPane(textArea1));
        copyButton=new JButton("拷贝>>>");
        box.add(copyButton);
        copyButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea2.setText(textArea1.getSelectedText());
                    }
                }
        );
        textArea2=new JTextArea(5,12);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));
        container.add(box);
        setSize(500,400);
        setVisible(true);
    }
    public class TextFieldHandler implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            String string="";
            if(event.getSource()==textField1)
                string="textField1:"+event.getActionCommand();
            else if (event.getSource()==passwordField){
                string="passwordField:"+new String(passwordField.getPassword());
            }
            textField3.setText(string);
        }
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
