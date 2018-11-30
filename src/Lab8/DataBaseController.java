package Lab8;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DataBaseController implements Initializable {

    @FXML private TextField add_isbn;
    @FXML private TextField add_author;
    @FXML private TextField add_year;
    @FXML private TextField add_title;
    @FXML private TextField get_search;

    private String str_new_year;
    private String str_new_isbn;
    private String str_new_title;
    private String str_new_author;



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

    private Statement stmt = null;
    private ResultSet rs = null;
    private Connection conn =null;
    final private String login = "annawojc";
    final private String password = "Aqua2705";

    private String sort_how = " asc ";
    private String sort_by =" isbn ";

    private  ObservableList<Book> data= FXCollections.observableArrayList();

    private boolean connected ;


    private void connect(){
        connected = false;
        try { Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.setLoginTimeout(10);
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/annawojc", login,password);
            if(!conn.isClosed()|| conn!= null) {
                connected = true;}
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState()); System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void listBooks(){
        table.getItems().clear();
        data.clear();
        try {
            tryToConnect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books ORDER BY "+ sort_by +" "+ sort_how + ";");
            while(rs.next()){
                data.add(new Book(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4)));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException sqlEx) { }
            rs = null; }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { }
            stmt = null;
        }
        table.setItems(data);
    }


    private void search(){
        table.getItems().clear();
        data.clear();

        final ToggleGroup search_by = new ToggleGroup();
        search_author.setToggleGroup(search_by);
        search_isbn.setToggleGroup(search_by);


        try {
            tryToConnect();
            stmt = conn.createStatement();
            if(search_author.isSelected()){
                rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+get_search.getText()+"';" );

            }
            else if(search_isbn.isSelected()) {
                rs = stmt.executeQuery("SELECT * FROM books WHERE ISBN = '" + get_search.getText() + "';");
            }
            while (rs.next()){
                data.add(new Book(rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4)));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException sqlEx) { }
            rs = null; }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { }
            stmt = null;
        }
    }


    private void validateNewBookInfo(){

    }


    private void getBookInfo(){
        str_new_year = add_year.getText();
        str_new_author = add_author.getText();
        str_new_title = add_title.getText();
        str_new_isbn = add_isbn.getText();

    }

    private void addBook(){
        try {
            tryToConnect();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO books(isbn,title,author,year) VALUES ('"+str_new_isbn+"','" +str_new_title
                    +"','" +str_new_author+"','"+str_new_year+"');");
        } catch (SQLException ex) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }

                stmt = null;
            }
        }
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

    private void errorMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error ");
        alert.setHeaderText("Ooooooops! :c");
        alert.setContentText("Nieudane 3 próby połączenia z bazą danych ");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Zakończ");
        alert.setOnCloseRequest(e -> Platform.exit());
        alert.showAndWait();

    }
    private void tryToConnect(){
        int counter = 3;
        while(counter > 0){
            connect();
            if(connected){
                break;
            }
            else counter--;
        }
        if(!connected) errorMessage();

    }


    @FXML
    private void handleShowButton(){
        handleSorting();
        listBooks();
    }
    @FXML
    private void handleSearchButton(){
        search();

    }

    @FXML
    private void handleAddButton(){
        getBookInfo();
        addBook();
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
