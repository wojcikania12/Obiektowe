package Lab6.Graph;

import javax.swing.*;
import java.awt.*;


public class MenuPanel extends JPanel {
    public static  JTextField a;
    public static JTextField b;
    public static JTextField c;
    public static JTextField d;
    public static JTextField poczatek_p;
    public static JTextField koniec_p;
    public static  JTextField krok;
    public static JButton rysuj;

    public MenuPanel(){
        setPreferredSize(new Dimension(getWidth(), 70));
        setLayout(new FlowLayout());
        a = new JTextField(2);
        b = new JTextField(2);
        c = new JTextField(2);
        d = new JTextField(2);
        rysuj = new JButton("Rysuj");
        poczatek_p = new JTextField(3);
        koniec_p = new JTextField(3);
        krok = new JTextField(3);
        add(a);
        add(new JLabel("x^3+"));
        add(b);
        add(new JLabel("x^2+ "));
        add(c);
        add(new JLabel("x+ "));
        add(d);
        add(new JLabel("Krok: "));
        add(krok);
        add(new JLabel("Początek: "));
        add(poczatek_p);
        add(new JLabel("Koniec: "));
        add(koniec_p);
        add(rysuj);

    }

}
