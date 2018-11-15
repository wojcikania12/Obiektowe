package Lab6.Shapes;

import java.awt.*;

public class Triangle extends Shape {
  private  Polygon poly;
    private int edges;

    public Triangle(Point p1, Point p2, Point p3){
        poly = new Polygon();
        poly.addPoint(p1.x, p1.y);
        poly.addPoint(p2.x, p2.y);
        poly.addPoint(p3.x, p3.y);
        edges = 3;
    }

    @Override
    public void setX(int x_) {

    }

    @Override
    public void setY(int y_) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getE() {
        return 0;
    }

    @Override
    public int getSecondE() {
        return 0;
    }

    public void draw(Graphics graphic){
        graphic.setColor(new Color(162, 208, 163));
        graphic.fillPolygon(poly);
    }
}
