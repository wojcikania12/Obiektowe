package Lab4.ShapeList;
import Lab3.Shapes.*;

import java.util.Comparator;

public class ShapesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2){
        return s1.edges - s2.edges;
    }
}
