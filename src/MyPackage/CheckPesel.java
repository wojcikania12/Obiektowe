package MyPackage;

import java.util.Scanner;

public class CheckPesel {
    public CheckPesel() {
    }

    public static void main(String[] argv) {
        System.out.println("Podaj numer PESEL: ");
        Scanner in = new Scanner(System.in);
        Pesel.Check(in.nextLine());
    }
}
