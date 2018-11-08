package Lab5;

public class InvalidFormatException extends Exception {
    InvalidFormatException(String sub, int line){
        super("Invalid frame format in line " + line + " : "+sub);
    }
}
