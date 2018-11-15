package Lab6.Shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Circle extends Shape {
    private int radius;
    private int x = 100;
    private int y = 100;
    private Ellipse2D.Float c;
    public Circle(int radius_){
        radius = radius_;
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

    public boolean contains(int dx,int dy) {
        return c.contains(dx, dy);
    }

    public void draw(Graphics graphic){
        Graphics2D g2 = (Graphics2D) graphic;
        c = new Ellipse2D.Float(x, y, radius, radius);
        g2.setColor(new Color(219,176,239));
        g2.fill(c);
    }
}
