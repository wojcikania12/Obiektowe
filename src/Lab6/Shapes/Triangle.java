package Lab6.Shapes;

import java.awt.*;

public class Triangle extends Shape {
  private int a;
  private int h;
  private int x = 100;
  private int y = 100;
  private Polygon poly;

  public Triangle(int a_, int h_){
       a = a_;
       h = h_;
    }
    public void setX(int x_) {
      x = x_;
    }
    public void setY(int y_) {
      y = y_;
    }
    public int getX() {
      return x;
    }
    public int getY() {
      return y;
    }
    public boolean contains(int dx,int dy) {
        return poly.contains(dx, dy);
  }
    public void draw(Graphics graphic){
        poly  = new Polygon();
        poly.addPoint(x,y);
        poly.addPoint(x - (int)a/2,y +h);
        poly.addPoint(x +(int)a/2,y +h);
        graphic.setColor(new Color(162, 208, 163));
        graphic.fillPolygon(poly);
    }
}
