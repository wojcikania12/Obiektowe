package Lab8;



import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private Statement stmt = null;
    private ResultSet rs = null;
    private Connection conn =null;
    private boolean connected ;

    boolean isConnected(){
        return connected;
    }

    void connect(){
        connected = false;
        try { Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.setLoginTimeout(10);
            String login = "annawojc";
            String password = "Aqua2705";
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/annawojc", login, password);
            if(!conn.isClosed()|| conn!= null) {
                connected = true;}
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage()); System.out.println("SQLState: " + ex.getSQLState()); System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    ArrayList<Book> listBooks(String sort_by, String sort_how){
        ArrayList<Book> books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books ORDER BY "+ sort_by +" "+ sort_how + ";");
            while(rs.next()){
                books.add(new Book(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4)));
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
        return books;
    }


    ArrayList<Book> search(String search_by, String textFieldData){
        ArrayList<Book> searched_books = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            if(search_by.equals("author")){
                rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+textFieldData+"';" );
            }
            else if(search_by.equals("isbn")) {
                rs = stmt.executeQuery("SELECT * FROM books WHERE ISBN = '" + textFieldData + "';");
            }
            while (rs.next()){
                searched_books.add(new Book(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4)));
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
        return searched_books;
    }

    void  addBook(String isbn, String title, String author, String year){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO books(isbn,title,author,year) VALUES ('"+isbn+"','" +title
                    +"','" +author+"','"+year+"');");
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
}
