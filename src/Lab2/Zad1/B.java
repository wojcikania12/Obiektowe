package Lab2.Zad1;

public class B extends A {
    protected void decrement(){
        number -= 2;
    };
    private void increment(){
        number += 2;
    };
    void changeName(){
        name = "Ala";
        System.out.println(name);
    };
    public B(int number_, String name_){
        super(number_,name_);
    };
}
