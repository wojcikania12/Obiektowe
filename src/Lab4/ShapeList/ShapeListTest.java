package Lab4.ShapeList;
import Lab3.Shapes.*;


public class ShapeListTest {
    public static void main(String[] argv) {
        ShapeList shapes = new ShapeList();
        shapes.add(new Circle(10));
        shapes.add(new Rectangle(5,10));
        shapes.add(new Square(8));
        shapes.show();
        System.out.println();
        shapes.sort();
        shapes.show();

    }
}
