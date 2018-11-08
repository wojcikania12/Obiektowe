package Lab5;

import java.io.FileNotFoundException;

public class SubtitlesMain {
    public static void main(String[] args){
       try {
           int delay = Integer.parseInt(args[2]);
           int fps = Integer.parseInt(args[3]);
           String from = args[0];
           String to = args[1];
           MicroDVD temp = new MicroDVD();
           temp.delay(from,to,delay,fps);
       }catch(InvalidFormatException | WrongSequenceException e){
           System.err.println(e.getMessage());
        }
        catch (Throwable e){
           e.printStackTrace();
        }
    }
}
