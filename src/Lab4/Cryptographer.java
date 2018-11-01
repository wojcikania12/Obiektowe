package Lab4;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File from, File to_, Algorithm cipher)throws FileNotFoundException{
        Scanner input = new Scanner(from);
        PrintWriter to = new PrintWriter(to_);
        while (input.hasNextLine()) {
            Scanner input2 = new Scanner(input.nextLine());
            while(input2.hasNext()){
                to.print(cipher.crypt(input2.next()));
                to.print(" ");
            }
            to.print("\n");
        }
        to.close();

    }


    public static void decryptfile(File from, File to_, Algorithm cipher)throws FileNotFoundException{
        Scanner input = new Scanner(from);
        PrintWriter to = new PrintWriter(to_);
        while (input.hasNextLine()) {
            Scanner input2 = new Scanner(input.nextLine());
            while(input2.hasNext()){
                to.print(cipher.decrypt(input2.next()));
                to.print(" ");
            }
            to.print("\n");
        }
        to.close();
    }
}