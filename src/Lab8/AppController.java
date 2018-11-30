package Lab8;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML private TextField add_isbn;
    @FXML private TextField add_author;
    @FXML private TextField add_year;
    @FXML private TextField add_title;
    @FXML private TextField get_search;

    @FXML private RadioButton search_author;
    @FXML private RadioButton sort_up;
    @FXML private RadioButton sort_down;
    @FXML private RadioButton sort_author;
    @FXML private RadioButton sort_isbn;
    @FXML private RadioButton search_isbn;

    @FXML private TableView<Book> table;

    @FXML private TableColumn<Book,String> isbnCol;
    @FXML private TableColumn<Book,String> titleCol;
    @FXML private TableColumn<Book,String> authorCol;
    @FXML private TableColumn <Book,String>yearCol;

    private DataBase db ;
    private String sort_how = " asc ";
    private String sort_by =" isbn ";

    private  ObservableList<Book> data= FXCollections.observableArrayList();


    public AppController(){
        db = new DataBase();
    }


    private void handleSorting(){
        final ToggleGroup how = new ToggleGroup();
        final ToggleGroup by = new ToggleGroup();
        final  String [] order_by={" asc "," desc "," author ", " isbn "};

        sort_author.setToggleGroup(by);
        sort_isbn.setToggleGroup(by);

        sort_down.setToggleGroup(how);
        sort_up.setToggleGroup(how);

        boolean author_selected = sort_author.isSelected();
        if(author_selected) sort_by = order_by[2];

        boolean isbn_selected = sort_isbn.isSelected();
        if(isbn_selected) sort_by = order_by[3];

        boolean asc_selected = sort_up.isSelected();
        if(asc_selected) sort_how = order_by[0];

        boolean desc_selected = sort_down.isSelected();
        if(desc_selected) sort_how = order_by[1];
    }


    private void listBooks(){
        ArrayList<Book> books;
        table.getItems().clear();
        data.clear();
        tryToConnect();
        books = db.listBooks(sort_by,sort_how);
        data.addAll(books);
        table.setItems(data);
    }


    private void search(){
        ArrayList<Book> searched_books;
        table.getItems().clear();
        data.clear();
        final ToggleGroup search_by = new ToggleGroup();
        search_author.setToggleGroup(search_by);
        search_isbn.setToggleGroup(search_by);

        tryToConnect();

        if(search_author.isSelected())  searched_books = db.search("author",get_search.getText());
        else if(search_isbn.isSelected())searched_books = db.search("isbn",get_search.getText());
        else searched_books = new ArrayList<>();
        data.addAll(searched_books);
        table.setItems(data);

    }

    private void errorMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Ooooooops!");
        alert.setContentText("Nieudane 3 próby połączenia z bazą danych ");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Zakończ");
        alert.setOnCloseRequest(e -> System.exit(0));
        alert.showAndWait();
    }

    private void tryToConnect(){
        int counter = 3;
        while(counter > 0){
            db.connect();
            if(db.isConnected()){
                break;
            }
            else counter--;
        }
        if(!db.isConnected()) errorMessage();

    }

    @FXML
    private void handleShowButton(){
        handleSorting();
        listBooks();
    }
    @FXML
    private void handleSearchButton(){
        search();
        get_search.clear();
    }

    @FXML
    private void handleAddButton(){
        db.addBook(add_isbn.getText(),add_title.getText(),add_author.getText(),add_year.getText());
        handleSorting();
        listBooks();
        add_author.clear();
        add_isbn.clear();
        add_title.clear();
        add_year.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isbnCol.setCellValueFactory(
                new PropertyValueFactory<>("isbn"));

        authorCol.setCellValueFactory(
                new PropertyValueFactory<>("author"));

        titleCol.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        yearCol.setCellValueFactory(
                new PropertyValueFactory<>("year"));

    }
}
