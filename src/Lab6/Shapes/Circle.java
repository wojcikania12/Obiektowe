package Lab6.Shapes;

import java.awt.*;


public class Circle extends Shape {
    private int radius;
    private int x = 100;
    private int y = 100;
    public Circle(int radius_){
        radius = radius_;
        edges =0;
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
        return radius;
    }
    public int getSecondE(){
        return radius;
    }
    public void draw(Graphics graphic){
        graphic.setColor(new Color(219,176,239));
        graphic.fillOval(x,y,radius,radius);
    }
}
