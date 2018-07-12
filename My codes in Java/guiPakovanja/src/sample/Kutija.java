package sample;



public class Kutija extends Paketi{


    private double a;
    private double b;
    private double c;
    private char vrsta;

    public Kutija(double a, double b,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.vrsta = 'K';
    }


    @Override
    char vrsta() {
        return this.vrsta;
    }


    @Override
    double zapremina() {
        return a*b*c;
    }

    @Override
    double povrsina() {
        return 2*((a*b)+(a*c)+(b*c));
    }


    @Override
    public String toString() {
        return vrsta()+"("+a+", "+b+", "+c+"), V = "+String.format("%.2f", zapremina());
    }


}
