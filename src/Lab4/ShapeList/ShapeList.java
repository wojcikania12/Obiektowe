package Lab4.ShapeList;
import Lab3.Shapes.*;

import java.util.Collections;
import java.util.LinkedList;

public class ShapeList {
    private LinkedList<Shape> shapes;
    public ShapeList(){
        shapes = new LinkedList<Shape>();
    }
    public void add(Shape new_shape) {
        shapes.add(new_shape);
    }

    public void show() {
        for (Shape s : shapes) {
           // s.draw();
        }
    }
    public void sort() {
        Collections.sort(shapes, new ShapesComparator());
    }
}
