package Lab6;

import Lab6.Shapes.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener  {
    private int x = 0;
    private int y  = 0;
    private int d_x = 0;
    private int d_y = 0 ;
    private LinkedList<Shape> shapes;
    boolean dragging = false;
    boolean clicked = false;

    public MyPanel(){
        shapes = new LinkedList<Shape>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public MyPanel(LinkedList<Shape> s){
        shapes = new LinkedList<Shape>(s);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void add(Shape s){
        shapes.add(s);
    }
    public void paint(Graphics graphic){
        for(Shape s : shapes){
            s.draw(graphic);
        }
        repaint();
    }
    public void mousePressed(MouseEvent evt){
        x = evt.getX();
        y = evt.getY();

    }
    public void mouseDragged(MouseEvent evt){
        d_x = evt.getX() - x;
        d_y = evt.getY() - y;
        for(Shape s : shapes){
            if(s.contains(x,y)){
                s.setX(s.getX()+d_x);
                s.setY(s.getY()+d_y);
                break;
            }
        }
        x += d_x;
        y += d_y;

    }
    public void mouseReleased(MouseEvent evt){}
    public void mouseClicked(MouseEvent evt) { }
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
    public void mouseMoved(MouseEvent evt) { }
}
