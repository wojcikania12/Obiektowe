package Lab2;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    static LinkedList<Prostokat> figury ;

    public static void main(String[] args){
        figury = new LinkedList();
        boolean uruchom = true;
        int odp;
        Scanner odczyt = new Scanner(System.in);

        while(uruchom){
            System.out.println("1. Wczytaj prostokat. \n" + "2. Wyswietl wszytskie prostokaty. \n" +
                    "3. Oblicz sume pol wszystkich prostokatow. \n" + "4. Zakoncz. \n");
            odp = odczyt.nextInt();
            switch(odp){
                case(1):
                    double a,b;
                    System.out.println("Podaj bok a");
                    a = odczyt.nextDouble();
                    System.out.println("Podaj bok b");
                    b = odczyt.nextDouble();
                    Prostokat prostokat = new Prostokat(a, b);
                    figury.add(prostokat);
                    System.out.println("Dodano prostokat. \n");
                    break;
                case(2):
                    int i = 1;
                    for(Prostokat it : figury){
                        System.out.println("Prostokat " + (i++) + " : " + it.getA() + " x " +
                                it.getB() +'\n');
                    }
                    break;
                case(3):
                    double suma = 0;
                    for(Prostokat it : figury){
                        suma += it.area();
                    }
                    System.out.println("Suma pol prostokatow: " + suma + '\n');
                    break;
                case(4):
                    uruchom = false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji :C. \n");
                    break;
            }

        }
    }
}
