package Lab5;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MicroDVD{

    private  int change_frames(int delay, int fps, int actual_frame){
        return actual_frame + delay * fps / 1000;
    }

    public  void delay(String input,String output ,int delay, int fps) throws InvalidFormatException,WrongSequenceException
    , FileNotFoundException{
        int line =0;
            File from = new File(input);
            File to = new File(output);
            Scanner from_ = new Scanner(from);
            PrintWriter to_ = new PrintWriter(to);
        while (from_.hasNextLine()) {
            String temp = from_.nextLine();
            line++;
            StringBuilder result = new StringBuilder();
            String regex_pattern = ("\\{(\\d+)\\}\\{(\\d+)\\}(.+)");
            Pattern r = Pattern.compile(regex_pattern);
            Matcher m = r.matcher(temp);
            if(m.find()){
                int frame_start = change_frames(delay,fps,Integer.parseInt(m.group(1)));
                int frame_end = change_frames(delay,fps,Integer.parseInt(m.group(2)));
                if(frame_start > frame_end) throw new WrongSequenceException(temp,line);
                if (0 > frame_start) frame_start =0;
                if (0 > frame_end) frame_end =0;
                result.append("{").append(Integer.toString(frame_start)).append("}{").
                        append(Integer.toString(frame_end)).append("}"+m.group(3)+"\n");
                to_.print(result);
            }
            else throw new InvalidFormatException(temp,line);
        }
        to_.close();
    }

}
