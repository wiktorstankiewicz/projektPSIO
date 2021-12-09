package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;

abstract public class Postac implements AtakiInterfejs_I {

    // Deklaracja zmiennych punktow Postaci
    protected int hp=100;
    protected int pancerz;
    protected String imie;
    protected String imageFilePath;
    protected Bron bron;
    protected AtakiInterfejs_I atak;

    // Konstruktory
    public Postac(){
        this.imie = "Bożydar";
    }

    public Postac(String imie, Bron bron) {
        this.imie = imie;
        this.bron=bron;
    }

    // Gettery
    public int getHp() {
        return hp;
    }
    public int getPancerz() {
        return pancerz;
    }
    public Bron getBron(){
        return bron;
    }

    public String getStan(){
        return this.getClass().getSimpleName() + ": " + imie + "\n" +
                "HP: " + hp + "\n" +
                "Pancerz: " + pancerz;
    }


    // Settery
     public void setHp(int hp) {
        this.hp=hp;
    }

    public void setPancerz(int pancerz) {
        this.pancerz = pancerz;
    }

    public String getImie(){
        return imie;
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
}
