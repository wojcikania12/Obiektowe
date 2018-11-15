package Lab6.Shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {
    private int a;
    private int b;
    private int x = 100;
    private int y = 100;
    private Rectangle2D.Float r;

    public Rectangle(int a_, int b_){
        a = a_;
        b = b_;
    }
    public void setX(int x_){
        x = x_;
    }
    public void setY(int y_){
        y = y_;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean contains(int dx, int dy) {
        return r.contains(dx, dy);
    }

    public void draw(Graphics graphic){
        Graphics2D g2 = (Graphics2D) graphic;
        r = new Rectangle2D.Float(x,y,a,b);
        g2.setColor(new Color(255,	192	,203));
        g2.fill(r);
    }
}
