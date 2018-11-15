package Lab6;

import Lab6.Shapes.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.LinkedList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener  {
    private int dragFromX =0;
    private int dragFromY =0;
    private int x,y;
    private Shape tmp;
    private LinkedList<Shape> shapes;
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
    private void paintShape(Graphics graphic){
        super.paintComponent(graphic);
        for(Shape s : shapes){
            s.draw(graphic);
        }
    }

    public void paint(Graphics g){
        this.paintShape(g);
        repaint();
    }
    public void mousePressed(MouseEvent evt){
        x= evt.getX();
        y= evt.getY();

    }
    public void mouseDragged(MouseEvent evt){
        int dx = evt.getX() - x;
        int dy = evt.getY() - y;
        for(Shape s : shapes){
            if(x>=s.getX()&& x<=(s.getX()+s.getE())&& y>= s.getY() && y<=(s.getY()+s.getSecondE())) {
                s.setX(s.getX() +dx);
                s.setY(s.getY() +dy);
                break;
            }
            else{
                
            }
        }
        x += dx;
        y += dy;
    }
    public void mouseReleased(MouseEvent evt){}
    public void mouseClicked(MouseEvent evt) { }
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
    public void mouseMoved(MouseEvent evt) { }
}
