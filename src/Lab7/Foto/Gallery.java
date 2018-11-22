package Lab7.Foto;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.ScrollPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Screen;
import java.io.File;
import java.io.FileInputStream;
import javafx.geometry.Insets;




public class Gallery extends Application {
    private Stage main;

    private boolean isPicture(File f){
        String[] ext= {"jpg","png","tiff","gif","jpeg","bmp"};
        int index = f.getName().lastIndexOf(".");
        String f_ext = f.getName().substring(index +1);
        f_ext = f_ext.toLowerCase();
        for(String s : ext){
            if(s.equals(f_ext)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void start(Stage stage) throws Exception{
        main = stage;
        String path;

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File dir = directoryChooser.showDialog(stage);

        TilePane tile = new TilePane();
        ScrollPane sp = new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        tile.setPadding(new Insets(20, 20, 20, 20));
        tile.setHgap(20);
        File[] all_files = dir.listFiles();
        for(File f : all_files) {
            if(f.isFile()){
                if(isPicture(f)){
                    ImageView iv= new ImageView();
                    Image image = new Image(new FileInputStream(f));
                    iv.setImage(image);
                    iv.setFitWidth(200);
                    iv.setPreserveRatio(true);
                    iv.setSmooth(true);
                    iv.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent event) {

                            ImageView iv2= new ImageView(image);
                            BorderPane pane = new BorderPane();
                            pane.setPrefSize(main.getWidth()/2, main.getWidth()/2);
                            iv2.setPreserveRatio(true);
                            iv2.setFitWidth(main.getWidth()/1.2-50);
                            iv2.setFitHeight(main.getHeight()/1.2-50);
                            pane.setCenter(iv2);
                            Stage new_stage = new Stage();
                            new_stage.setScene(new Scene(pane));
                            new_stage.setWidth(main.getWidth()/1.2);
                            new_stage.setHeight(main.getHeight()/1.2);
                            new_stage.show();
                        }
                    });
                    tile.getChildren().addAll(iv);

                }
            }
        }
        sp.setFitToWidth(true);
        sp.setContent(tile);
        stage.setTitle("Gallery");
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        stage.setScene(new Scene(sp));
        stage.show();
    }


    public static void main(String[] args)
    {try {
        launch(args);
    }catch (Exception e){
        System.err.println(e.getMessage());
    }
    }
}
