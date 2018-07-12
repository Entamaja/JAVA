package com.ena;
public class Fruit implements Comparable<Fruit>{

    private String fruitName;
    private String fruitDesc;
    private int kolicina;

    public Fruit(String fruitName, String fruitDesc, int quantity) {
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.kolicina = quantity;
    }


    public int compareTo(Fruit zaPoredjenjeVocka) {

        int kolicinaZaPoredjenje = ((Fruit) zaPoredjenjeVocka).getKolicina();

        //ascending order
//        return this.quantity - compareQuantity;

        //descending order
        return kolicinaZaPoredjenje - this.kolicina;

    }


















    public String getFruitName() {
        return fruitName;
    }

    public int getKolicina() {
        return kolicina;
    }


}