package Lab6;

import Lab6.Shapes.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener  {
    private int x = 0;
    private int y  = 0;
    private int d_x = 0;
    private int d_y = 0 ;
    private ArrayList<Shape> shapes;
    private Shape clicked = null;

    public MyPanel(){
        shapes = new ArrayList<Shape>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public MyPanel(ArrayList<Shape> s){
        shapes = new ArrayList<Shape>(s);
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
    }
    public void mousePressed(MouseEvent evt){
        x = evt.getX();
        y = evt.getY();
        for(int i =0; i<shapes.size();i++){
            if(shapes.get(i).contains(x,y)){
                clicked = shapes.get(i);
                shapes.remove(shapes.get(i));
                shapes.add(shapes.size(), clicked);
            }
        }
    }
    public void mouseDragged(MouseEvent evt){
        if(clicked != null){
        d_x = evt.getX() - x;
        d_y = evt.getY() - y;
        clicked.setX(clicked.getX()+d_x);
        clicked.setY(clicked.getY()+d_y);
        x += d_x;
        y += d_y;
    }
    repaint();
    }
    public void mouseReleased(MouseEvent evt){
        clicked = null;
    }
    public void mouseClicked(MouseEvent evt) { }
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
    public void mouseMoved(MouseEvent evt) { }
}
