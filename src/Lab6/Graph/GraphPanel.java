package Lab6.Graph;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class GraphPanel extends JPanel implements ActionListener {
    private int []wsp= new int[]{0,0,0,0};
    private int skok = 1;
    private double koniec=2;
    private double poczatek =1;
    private  double skala_y=0;
    private  double skala_x=0;
    private final int margin =100;


    public GraphPanel(){
        setLayout(new FlowLayout());

    }

    private double function(int []wsp,double  arg ){
        double wynik =0.0;
        int counter = 3;
        for(int w : wsp){
            wynik+= w*Math.pow(arg, counter--);
        }
        return wynik;
    }

    private double coord_x(double x){
        double result = x*skala_x+getWidth()/2;
        return result;
    }

    private double coord_y(double y) {
        double result = (-y)*skala_y+getHeight()/2;
        return result;
    }

    public double modul(double x) {
        if(x<0)
            x=-x;
        return x;
    }

    public void drawGraph(Graphics2D g2){
        g2.setColor(Color.PINK);

        double distance =(double) modul((koniec - poczatek)/skok);


        double [] x =new double[skok+1];
        double [] y =new double[skok+1];

        double max = function(wsp, x[0]);
        for(int k = 0;k<skok+1;k++){
            x[k] = poczatek;
            y[k] = function(wsp, x[k]);
            if(modul(y[k])>max) max = modul(y[k]);
            poczatek += distance;
        }

        skala_y = ((getHeight()/2 - margin)/max);
        if(modul(x[(int)distance])> modul(x[0]))
            skala_x = modul((getWidth()/2 - margin)/x[(int)distance]);
        else
            skala_x = modul((getWidth()/2 - margin)/x[0]);


        for(int j =0; j<skok-1; j++){
            g2.draw(new Line2D.Double((int)coord_x(x[j]), (int)coord_y(y[j]), (int)coord_x(x[j+1]), (int)coord_y(y[j+1])) );

        }
    }

    public void drawAxis(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawLine(0 , getHeight()/2 , getWidth() , getHeight()/2);
        g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.WHITE);
        drawAxis(g2);
        drawGraph(g2);

}

    public void actionPerformed(ActionEvent e) {
        String a_s=MenuPanel.a.getText();
        String b_s=MenuPanel.b.getText();
        String c_s=MenuPanel.c.getText();
        String d_s=MenuPanel.d.getText();
        String krok_s =MenuPanel.krok.getText();
        String poczatek_s=MenuPanel.poczatek_p.getText();
        String koniec_s =MenuPanel.koniec_p.getText();
        if(a_s.isEmpty()||b_s.isEmpty()||c_s.isEmpty()||d_s.isEmpty()||krok_s.isEmpty()||poczatek_s.isEmpty()||koniec_s.isEmpty()){
          return;
        }

        try {
            int a_i = Integer.parseInt(a_s);
            int b_i = Integer.parseInt(b_s);
            int c_i = Integer.parseInt(c_s);
            int d_i = Integer.parseInt(d_s);
            poczatek = Double.parseDouble(poczatek_s);
            koniec = Double.parseDouble(koniec_s);
            if(poczatek>koniec) {
                throw new Exception("Nieprawidlowy zakres");
            }

            skok = Integer.parseInt(krok_s);
            wsp = new int[]{a_i, b_i, c_i, d_i};
        }catch (Exception er){
            er.getMessage();
            return;
        }
        if (e.getSource() == MenuPanel.rysuj){
            repaint();
        }
    }

}
