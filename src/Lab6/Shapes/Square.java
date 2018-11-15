package Lab6.Shapes;

import java.awt.*;


public class Square extends Shape {
    private int a;
    private int x = 100;
    private int y = 100;
    public Square(int a_){
        a = a_;
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
        return a;
    }
    public void draw(Graphics graphic){
        graphic.setColor(new Color(162, 208, 221));
        graphic.fillRect(x,y,a,a);
    }
}
