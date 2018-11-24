package Lab7.Graph2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;


public class GraphDrawer2 implements Initializable {
    private int skok_;
    private double poczatek_;
    private double koniec_;
    private double [] wsp_=new double[6];

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
    XYChart.Series series = new XYChart.Series();
    @FXML public LineChart linechart;

    private double function(double []wsp,double  arg ){
        double wynik =0.0;
        int counter = 5;
        for(double w : wsp) wynik += w * Math.pow(arg, counter--);
        return wynik;
    }

    private void handleTextFieldData(){
        try{
            if (a.getText().isEmpty()) wsp_[0] = 0;
            else wsp_[0] = Double.parseDouble(a.getText());

            if (b.getText().isEmpty()) wsp_[1] = 0;
            else wsp_[1]= Double.parseDouble(b.getText());

            if (c.getText().isEmpty()) wsp_[2] = 0;
            else wsp_[2]= Double.parseDouble(c.getText());

            if (d.getText().isEmpty()) wsp_[3] = 0;
            else wsp_[3]= Double.parseDouble(d.getText());

            if (e.getText().isEmpty()) wsp_[4] = 0;
            else wsp_[4]= Double.parseDouble(e.getText());

            if (f.getText().isEmpty()) wsp_[5] = 0;
            else wsp_[5]= Double.parseDouble(f.getText());

            if (start.getText().isEmpty()) poczatek_ = 0;
            else poczatek_ = Double.parseDouble(start.getText());

            if (stop.getText().isEmpty()) koniec_ = poczatek_+1;
            else koniec_ = Double.parseDouble(stop.getText());

            if (krok.getText().isEmpty()) skok_ = 100;
            else skok_ = Integer.parseInt(krok.getText());

        }catch (NumberFormatException ex){
            System.err.println("Złe wprowadzone wartości");
        }

        if(skok_< 0) skok_=1;

        if(poczatek_>koniec_){
            double temp = koniec_;
            koniec_ = poczatek_;
            poczatek_ = temp;
        }

    }

    @FXML
    private void handleButtonAction(){
        rysuj.setOnAction((event) -> {
            series.getData().clear();
            handleTextFieldData();
            double distance =Math.abs((koniec_ - poczatek_)/(skok_ - 1));
            for(double i = poczatek_; i <=koniec_;i+=distance){
                series.getData().add(new XYChart.Data(i, function(wsp_,i)));
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        linechart.setCreateSymbols(false);
        linechart.getData().addAll(series);
    }
}



