import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
public class Main extends JFrame {
    JPanel pleft;
    JPanel pright;
    CardLayout card;
    public Main(){
        this.setBounds(80,60,600,300);
        Container c=this.getContentPane();
        c.setLayout(new BorderLayout());
        pleft=new JPanel();
        pleft.setBackground(Color.red);
        card=new CardLayout(10,10);
        pleft.setLayout(card);
        JButton[]b=new JButton[10];
        for(int i=0;i<10;i++)
        {
            b[i]=new JButton("第"+i+"个Button");
           // b[i]=setFont(new Font("Helvetica",Font.PLAIN,18));
            pleft.add("card"+i,b[i]);
        }
        pleft=new JPanel();
        pright.setBackground(Color.blue);
        pright.setLayout(new FlowLayout());
        JButton b1=new JButton("下一个按钮");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(pleft);
            }
        });
        pright.add(b1);
        c.add(pleft,BorderLayout.CENTER);
        c.add(pright,BorderLayout.EAST);
        setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        Main f=new Main();
       // f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
