package Lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CryptoTest {
    public static void main(String[] args) throws FileNotFoundException{

        int decision,algorithm;
        Scanner reading;

        File from = new File(args[0]);
        File to_ = new File(args[1]);

        while (true) {
            System.out.println("1. Zaszyfruj. \n" + "2. Odszyfruj. \n");
            reading = new Scanner(System.in);
            decision = reading.nextInt();
            if (decision == 1 || decision == 2) {
                break;
            }
            else System.out.println("Nie ma takiej opcji.");
        }

        while (true) {
            System.out.println("Wybierz szyfr:\n"+"1. ROT11. \n" + "2. Szyfr Polibiusza. \n");
            algorithm = reading.nextInt();
            if (algorithm == 1 || algorithm == 2) {
                break;
            }
            else System.out.println("Nie ma takiej opcji.");
        }

        if(decision == 1){
            if(algorithm == 1)Cryptographer.cryptfile(from, to_, new ROT11());
            else Cryptographer.cryptfile(from, to_, new Polibiusz());

        }
        else if(decision == 2){
            if(algorithm == 1)Cryptographer.decryptfile(from, to_, new ROT11());
            else Cryptographer.decryptfile(from, to_, new Polibiusz());
        }
        System.out.println("Done");

       /* String slowo = "anja";
        ROT11 r = new ROT11();
        Polibiusz p = new Polibiusz();

        String s1= p.crypt(slowo);
        String s2= p.decrypt(s1);
        System.out.println(s1);
        System.out.println(s2);

        String s3= r.crypt(slowo);
        String s4= r.decrypt(s3);
        System.out.println(s3);
        System.out.println(s4);


        File from = new File("/Users/aniii/IdeaProjects/Obiektowe/src/Lab4/plik2.txt");
        File to_ = new File("/Users/aniii/IdeaProjects/Obiektowe/src/Lab4/plik1.txt");
        File to_2= new File("/Users/aniii/IdeaProjects/Obiektowe/src/Lab4/plik3.txt");

        Cryptographer c1= new Cryptographer();
        c1.cryptfile(from ,to_ ,p);
        c1.decryptfile(to_,to_2,p);
         */

    }
}
