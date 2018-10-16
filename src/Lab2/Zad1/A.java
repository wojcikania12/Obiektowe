package Lab2.Zad1;

public class A {
    protected int number;
    String name;
    public A(int number_, String name_){
        number  = number_;
        name = name_;
    };
    public void callDecrement(){
        decrement();
        System.out.println(number);
    };
    public void callChangeName(){
        changeName();
        System.out.println(name);
    };
    public void callIncrement(){
        increment();
        System.out.println(number);
    };
    private void increment(){
        number ++;
    };
    protected void decrement(){
        number--;
    };
    void changeName(){
        name = "Ania";

    };
}
