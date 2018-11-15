package Lab6.Shapes;
import java.awt.*;


public abstract class Shape{
    public abstract void setX(int x_);
    public abstract void setY(int y_);
    public abstract int getX();
    public abstract int getY();
    public abstract boolean contains(int dx,int dy);
    public abstract void draw(Graphics graphic);

}