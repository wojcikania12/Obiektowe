package Lab6.Shapes;
import java.awt.*;


public abstract class Shape{
    public String name;
    public int edges;
    public abstract void setX(int x_);
    public abstract void setY(int y_);
    public abstract int getX();
    public abstract int getY();
    public abstract int getE();
    public abstract int getSecondE();
    public abstract void draw(Graphics graphic);

}