package Lab6.Shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape {
    private int a;
    private int x = 100;
    private int y = 100;
    private Rectangle2D.Float s;
    public Square(int a_){
        a = a_;
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
        return s.contains(dx,dy);
    }
    public void draw(Graphics graphic){
        Graphics2D g2 = (Graphics2D) graphic;
        s= new Rectangle2D.Float(x,y,a,a);
        g2.setColor(new Color(162, 208, 221));
        g2.fill(s);
    }
}
