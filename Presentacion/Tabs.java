package Presentacion;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Tabs extends JFrame
{
    public Tabs()
    {
        setBounds(100, 100, 500, 200);
        setLayout(null);
        
        JTabbedPane tabulador = new JTabbedPane();
        tabulador.setBounds(0, 0, 480, 180);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(50, 50, 400, 150);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(50, 50, 400, 150);
        
        JLabel lbl1 = new JLabel("ESTE ES EL PANEL 1");
        lbl1.setBounds(10, 10, 200, 30);
        panel1.add(lbl1);
        
        tabulador.addTab("Tab1", panel1);
        tabulador.addTab("Tab2", panel2);
        add(tabulador);
        
        setVisible(true);
    }
    
}
