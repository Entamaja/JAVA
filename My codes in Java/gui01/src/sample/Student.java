package sample;

/**
 * Created by Toshiba on 6/6/2018.
 */
public class Student {

    private String ime;
    private String index;
    private Smer smer;

    public Student(String ime, String index, Smer smer) {
        this.ime = ime;
        this.index = index;
        this.smer = smer;
    }

    public String getIme() {
        return ime;
    }

    public String getIndex() {
        return index;
    }

    public Smer getSmer() {
        return smer;
    }

    public String toString(){
        return ime+" "+index+" Na smeru: "+smer;
    }

}
