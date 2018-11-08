package Lab5;

public class WrongSequenceException extends Exception {
     WrongSequenceException(String sub, int line){
         super("Subtitle end before start in line " + line + " : "+sub);
     }
}
