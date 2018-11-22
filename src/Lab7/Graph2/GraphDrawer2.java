package Lab7.Graph2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphDrawer2 extends Application {

    private double function(double []wsp,double  arg ){
        double wynik =0.0;
        int counter = 5;
        for(double w : wsp) wynik += w * Math.pow(arg, counter--);
        return wynik;
    }

    public double modul(double x) {
        if(x<0)
            x=-x;
        return x;
    }

    @Override
    public void start(Stage stage) throws Exception{
        double[] wsp={0.0,0.0,0.0,1.0,0.0,0.0};
        int krok = 100;
        double koniec =10;
        double poczatek = -5;
        double distance =(double) modul((koniec - poczatek)/krok);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
            XYChart.Series series = new XYChart.Series();
            for(double i = poczatek; i <koniec;i+=distance){
                series.getData().add(new XYChart.Data(i, function(wsp,i)));
                System.out.println(function(wsp,i));
            }
            lineChart.setCreateSymbols(false);
            lineChart.getData().add(series);
            stage.setScene(new Scene(lineChart,800,600));
            stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            stage.setTitle("JavaFX Graph Example");
            stage.show();
        } catch (Exception e) {
            System.out.print(e);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
