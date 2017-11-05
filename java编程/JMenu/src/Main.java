import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.event.*;
public class Main extends JFrame{
    private final Color colorValues[]={Color.black,Color.blue,Color.red,Color.green};
    private JRadioButtonMenuItem colorItems[],fonts[];
    private JCheckBoxMenuItem styleItems[];
    private JLabel displayLabel;
    private ButtonGroup fontGroup,colorGroup;
    private int style;
    public Main(){
        super("使用Swing中的菜单");
        JMenuBar bar=new JMenuBar();
        setJMenuBar(bar);
        JMenu fileMenu=new JMenu("File");
        fileMenu.setMnemonic('F');//设置快捷键
        JMenuItem aboutItem=new JMenuItem("About....");
        aboutItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Main.this,"这是菜单应用的例子","About",JOptionPane.PLAIN_MESSAGE);

                    }
                }
        );
        JMenuItem exitItem=new JMenuItem("Exit",(int)'x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                }
        );
        bar.add(fileMenu);
        JMenuItem formatMenu=new JMenu("Format");
        formatMenu.setMnemonic('r');
        String colors[]={"Black","Blue","Red","Green"};
        JMenu colorMenu=new JMenu("Color");
        colorMenu.setMnemonic('C');
        colorItems=new JRadioButtonMenuItem[colors.length];
        colorGroup=new ButtonGroup();
        ItemHandler itemHandler=new ItemHandler();
        for(int count=0;count<colors.length;count++){
            colorItems[count]=new JRadioButtonMenuItem(colors[count]);
            colorMenu.add(colorItems[count]);
            colorGroup.add(colorItems[count]);
            colorItems[count].addActionListener(itemHandler);
        }
        colorItems[0].setSelected(true);
        formatMenu.add(colorMenu);
        formatMenu.addSeparator();
        String fontNames[]={"Self","Monospaced","SansSerif"};
        JMenu fontMenu=new JMenu("Font");
        fontMenu.setMnemonic('n');
        fonts=new JRadioButtonMenuItem[fontNames.length];
        fontGroup=new ButtonGroup();
        for(int count=0;count<fonts.length;count++){
            fonts[count]=new JRadioButtonMenuItem(fontNames[count]);
            fontMenu.add(fonts[count]);
            fonts[count].addActionListener(itemHandler);
        }
        fonts[0].setSelected(true);
        fontMenu.addSeparator();
        String styleNames[]={"Bold","Italic"};
        styleItems=new JCheckBoxMenuItem[styleNames.length];
        StyleHandler styleHandler=new StyleHandler();
        for(int count=0;count<styleNames.length;count++){
            styleItems[count]=new JCheckBoxMenuItem(styleNames[count]);
            fontMenu.add(styleItems[count]);
            styleItems[count].addActionListener(styleHandler);
        }
        formatMenu.add(fontMenu);
        bar.add(formatMenu);
        displayLabel=new JLabel("Demonstrate JMenu",SwingConstants.CENTER);
        displayLabel.setForeground(colorValues[0]);
        displayLabel.setFont(new Font("Serif",Font.PLAIN,50));
        getContentPane().setBackground(Color.cyan);
        getContentPane().add(displayLabel, BorderLayout.CENTER);
        setSize(500,150);
        setVisible(true);
    }
    public static void main(String[] args) {
	// write your code here
        Main application=new Main();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private class ItemHandler implements ActionListener {
        public void actionperformed(ActionEvent event) {
            for (int count = 0; count < colorItems.length; count++)
                if (colorItems[count].isSelected()) {
                    displayLabel.setForeground(colorValues[count]);
                    break;
                }
            for (int count = 0; count < fonts.length; count++)
                if (event.getSource() == fonts[count]) {
                    displayLabel.setFont(new Font(fonts[count].getText(), style, 50));
                    break;
                }
            }
    }
    private class StyleHandler implements ItemHandler{
        public void itemStateChanged(ItemEvent e){
            style=0;
            if(styleItems[0].isSelected())
                style+=Font.BOLD;
            if(styleItems[1].isSelected())
                style+=Font.ITALIC;
            displayLabel.setFont(
                    new Font(displayLabel.getFont().getName(),style,50);
        }
    }
}
