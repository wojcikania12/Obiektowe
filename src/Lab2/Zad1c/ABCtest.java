package Lab2.Zad1c;
import Lab2.Zad1.*;

public class ABCtest {
    public static void main(String[] args){
        A a = new A(5,"Ola");
        B b = new B(10,"Kasia");
        a.callChangeName();
        a.callDecrement();
        a.callIncrement();

        b.callChangeName();
        b.callIncrement();
        b.callDecrement();

    }
}
