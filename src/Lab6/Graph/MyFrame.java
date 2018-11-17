package Lab6.Graph;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame   {

    public MyFrame(){

        setTitle("Rysowanie wykresów wielomianów stopnia 3 :D");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(width/2,height/2);
        int frame_width = this.getSize().width;
        int frame_height = this.getSize().height;
        this.setLocation((width - frame_width)/2,(height - frame_height)/2);
        this.setDefaultCloseOperation(3);
        GraphPanel g = new GraphPanel();
        MenuPanel m = new MenuPanel();
        setLayout(new BorderLayout());

        add(m, BorderLayout.PAGE_START);
        add(g, BorderLayout.CENTER);
        MenuPanel.rysuj.addActionListener(g);

        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame f= new MyFrame();


    }
}
