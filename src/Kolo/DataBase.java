package Kolo;

import java.sql.*;

public  class DataBase {
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

    void  addData(String winner,String player1, String player2){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO scores(id,player1,player2,winner) VALUES ((SELECT MAX(id)+1 FROM scores),'" +player1
                    +"','" +player2+"','"+ winner+"');");
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
