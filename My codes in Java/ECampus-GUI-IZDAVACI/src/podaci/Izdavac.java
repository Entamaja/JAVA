package podaci;

public class Izdavac {

    private String imeIzdavaca;
    private double popust;

    public Izdavac(String imeIzdavaca, double popust) {
        this.imeIzdavaca = imeIzdavaca;
        this.popust = popust;
    }

    public String getImeIzdavaca() {
        return imeIzdavaca;
    }

    public void setImeIzdavaca(String imeIzdavaca) {
        this.imeIzdavaca = imeIzdavaca;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return imeIzdavaca;
    }
}
