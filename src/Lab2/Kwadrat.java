package Lab2;
import java.lang.Math;

public class Kwadrat {
    protected double a;

    public Kwadrat(double a_){
        a = a_;
    }

    public void setA(double a_){
        a = a_;
    }

    public double getA(){
        return a;
    }

    public double area(){
        return Math.pow(a,2);
    }

    public boolean isBigger(Kwadrat other){
        if(other.area() > this.area()) return true;
        else return false;
    }
}
