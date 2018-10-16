package Lab2;

public class Prostokat extends Kwadrat{
    protected double b;

    public Prostokat(double a_, double b_){
        super(a_);
        b = b_;
    }

    public void setB(double b_){
        b = b_;
    }

    public double getB(){
        return b;
    }

    public double area(){
        return a * b;
    }

    public boolean isBigger(Prostokat other){
        if(other.area() > this.area()) return true;
        else return false;
    }

}
