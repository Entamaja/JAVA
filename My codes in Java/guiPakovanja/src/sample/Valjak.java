package sample;

public class Valjak extends Paketi{

    private double a;
    private double h;
    private double pi;
    private char vrsta;

    public Valjak(double a, double h) {
        this.a = a;
        this.h = h;
        this.pi = 3.14159265;
        this.vrsta = 'V';
    }

    @Override
    char vrsta() {
        return this.vrsta;
    }

    @Override
    double zapremina() {
        return (a*a)*h*pi;
    }

    @Override
    double povrsina() {
        return (2*Math.pow(a,2)*pi)+(2*a*h*pi);
    }

    @Override
    public String toString() {
        return vrsta()+"("+a+", "+h+"), V = "+String.format("%.2f", zapremina());
    }

}
