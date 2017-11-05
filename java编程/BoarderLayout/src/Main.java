import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame implements ActionListener{
    private JButton buttons[];
    private final String names[]={"North","South","East","West","Center"};
    private BorderLayout layout;
    private Container container;
    public Main()
    {
        super("BorderLayout布局管理");
        layout=new BorderLayout(5,5);
        container=getContentPane();
        container.setLayout(layout);
        buttons=new JButton[names.length];
        for(int count=0;count<names.length;count++)
        {
            buttons[count]=new JButton(names[count]);
            buttons[count].addActionListener(this);
        }
        container.add(buttons[0],BorderLayout.NORTH);
        container.add(buttons[1],BorderLayout.SOUTH);
        container.add(buttons[2],BorderLayout.EAST);
        container.add(buttons[3],BorderLayout.WEST);
        container.add(buttons[4],BorderLayout.CENTER);
        setSize(300,200);setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        for(int count=0;count<buttons.length;count++)
        {
            if(event.getSource()==buttons[count])
                buttons[count].setVisible(false);
            else
                buttons[count].setVisible(true);
            layout.layoutContainer(container);
        }
    }


    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
