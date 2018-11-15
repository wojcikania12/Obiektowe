package Lab6.Shapes;

import java.awt.*;

public class Rectangle extends Shape {
    private int a;
    private int b;
    private int x = 100;
    private int y = 100;
    public Rectangle(int a_, int b_){
        a = a_;
        b = b_;
        edges = 4;
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
    public int getE(){
        return a;
    }
    public int getSecondE(){
        return b;
    }


    public void draw(Graphics graphic){
        Graphics2D graphic2d = (Graphics2D) graphic;
        graphic2d.setColor(new Color(255,	192	,203));
        graphic2d.fillRect(x,y,a,b);
    }
}
