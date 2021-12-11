package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;

import java.io.Serial;
import java.io.Serializable;

abstract public class Postac implements AtakiInterfejs_I, Serializable {
    //Version as of 11.12.2021 16:45
    @Serial
    private static final long serialVersionUID = 1900397209056382825L;

    // Deklaracja zmiennych punktow Postaci
    protected int hp = 150;
    protected int pancerz;
    protected String imie;
    protected String imageFilePath;
    protected Bron bron;
    protected AtakiInterfejs_I atak;

    // Konstruktory
    public Postac() {
        this.imie = "Bożydar";
    }

    public Postac(String imie, Bron bron) {
        this.imie = imie;
        this.bron = bron;
    }

    public String getStan() {
        return this.getClass().getSimpleName() + ": " + imie + "\n" +
                "HP: " + hp + "\n" +
                "Pancerz: " + pancerz;
    }

    public String toString(){
        return this.getClass().getSimpleName() + ": " + imie + ", HP: " + hp + ", Pancerz: " + pancerz;
    }

    @Override
    public void Atak(Postac p, Bron b) {
        atak.Atak(p, this.getBron());
    }

    // Settery
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPancerz(int pancerz) {
        this.pancerz = pancerz;
    }

    public void setAtak(AtakiInterfejs_I atak){
        this.atak = atak;
    }

    // Gettery
    public String getImie() {
        return imie;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public int getHp() {
        return hp;
    }

    public int getPancerz() {
        return pancerz;
    }

    public Bron getBron() {
        return bron;
    }

    public AtakiInterfejs_I getAtak(){
        return atak;
    }

    //this == p jesli
    //this.imie == p.imie
    //this.bron == p.bron
    public boolean equals(Object p){
        if (!(p instanceof Postac)) return false;

        Postac postac = (Postac) p;

        if (!imie.equals(postac.imie)) return false;
        if (!bron.equals(postac.bron)) return false;

        return true;
    }
}
