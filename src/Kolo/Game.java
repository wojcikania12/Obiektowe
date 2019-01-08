package Kolo;

public class Game {
    private String winner;
    private String player1;
    private String player2;

    public Game(String winner_, String player1_,String player2_){
        winner = winner_;
        player1 = player1_;
        player2 = player2_;
    }
    public String getWinner(){

        return winner;
    }
    public String getPlayer1()
    {
        return player1;
    }
    public String getPlayer2(){

        return player2;
    }


}
