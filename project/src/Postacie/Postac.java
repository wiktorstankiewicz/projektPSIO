package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;

abstract public class Postac implements AtakiInterfejs_I {
    // Deklaracja zmiennych punktow Postaci
    protected int hp = 150;
    protected int pancerz;
    protected String imie;
    protected String imageFilePath;
    protected Bron bron;
    protected AtakiInterfejs_I atak;
    private boolean czyPodpalony;

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

    public void setCzyPodpalony(boolean czyPodpalony) {
        this.czyPodpalony = czyPodpalony;
    }

    public boolean getCzyPodpalony() {
        return czyPodpalony;
    }
}
