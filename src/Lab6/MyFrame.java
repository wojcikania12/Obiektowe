package Lab6;
import java.awt.Toolkit;
import java.awt.Point;
import javax.swing.*;
import Lab6.Shapes.*;

public class MyFrame extends JFrame {
    public MyFrame(){

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(width/2,height/2);
        int frame_width = this.getSize().width;
        int frame_height = this.getSize().height;
        this.setLocation((width - frame_width)/2,(height - frame_height)/2);
        this.setDefaultCloseOperation(3);

    }
    public static void main(String[] args) {
        MyFrame f= new MyFrame();
        MyPanel p = new MyPanel();

        Circle c = new Circle(200);
        c.setY(100);
        c.setX(50);
        Circle c2= new Circle(50);
        c2.setY(100);
        c2.setX(300);
        Square s = new Square(100);
        s.setY(150);
        s.setX(300);
        Rectangle r = new Rectangle(60,80);
        r.setX(300);
        r.setY(250);
        Triangle t = new Triangle(200,100);
        t.setX(500);
        t.setY(200);

        p.add(s);
        p.add(c);
        p.add(t);
        p.add(r);
        p.add(c2);

        f.getContentPane().add(p);
        f.setVisible(true);

    }
}
