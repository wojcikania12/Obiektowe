package Lab5;

public class SubtitlesMain {
    public static void main(String[] args){
       try{
        if(args.length != 4) throw new Exception("Not enough parameters");
        int delay = Integer.parseInt(args[2]);
        int fps = Integer.parseInt(args[3]);
        String from =args[0];
        String to = args[1];
            MicroDVD temp = new MicroDVD();
            temp.delay(from,to,delay,fps);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
