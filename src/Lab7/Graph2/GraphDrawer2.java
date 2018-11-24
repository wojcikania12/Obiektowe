package Lab7.Graph2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class GraphDrawer2 implements Initializable {
    private int krok_i;
    private double poczatek_d;
    private double koniec_d;
    private double [] wsp_d=new double[6];

    @FXML public Button rysuj;
    @FXML public TextField a;
    @FXML public TextField b;
    @FXML public TextField c;
    @FXML public TextField d;
    @FXML public TextField e;
    @FXML public TextField f;
    @FXML public TextField start;
    @FXML public TextField stop;
    @FXML public TextField krok;
    XYChart.Series seria = new XYChart.Series();
    @FXML public LineChart wykres;

    private double function(double []wsp,double  arg ){
        double wynik =0.0;
        int counter = 5;
        for(double w : wsp) wynik += w * Math.pow(arg, counter--);
        return wynik;
    }

    private void handleTextFieldData(){
        try{
            if (a.getText().isEmpty()) wsp_d[0] = 0;
            else wsp_d[0] = Double.parseDouble(a.getText());

            if (b.getText().isEmpty()) wsp_d[1] = 0;
            else wsp_d[1]= Double.parseDouble(b.getText());

            if (c.getText().isEmpty()) wsp_d[2] = 0;
            else wsp_d[2]= Double.parseDouble(c.getText());

            if (d.getText().isEmpty()) wsp_d[3] = 0;
            else wsp_d[3]= Double.parseDouble(d.getText());

            if (e.getText().isEmpty()) wsp_d[4] = 0;
            else wsp_d[4]= Double.parseDouble(e.getText());

            if (f.getText().isEmpty()) wsp_d[5] = 0;
            else wsp_d[5]= Double.parseDouble(f.getText());

            if (start.getText().isEmpty()) poczatek_d = 0;
            else poczatek_d = Double.parseDouble(start.getText());

            if (stop.getText().isEmpty()) koniec_d = poczatek_d+1;
            else koniec_d = Double.parseDouble(stop.getText());

            if (krok.getText().isEmpty()) krok_i= 50;
            else krok_i = Integer.parseInt(krok.getText());

        }catch (NumberFormatException ex){
            System.err.println("Złe wprowadzone wartości");
        }

        if(krok_i< 3) krok_i=3;

        if(poczatek_d>koniec_d){
            double temp = koniec_d;
            koniec_d = poczatek_d;
            poczatek_d= temp;
        }

    }

    @FXML
    private void handleButtonAction(){
        rysuj.setOnAction((event) -> {
            seria.getData().clear();
            handleTextFieldData();
            double distance =Math.abs((koniec_d - poczatek_d)/(krok_i - 1));
            for(double i = poczatek_d; i <=koniec_d;i+=distance){
                seria.getData().add(new XYChart.Data(i, function(wsp_d,i)));
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wykres.setTitle("Wykres");
        wykres.setCreateSymbols(false);
        wykres.getData().addAll(seria);
    }
}



