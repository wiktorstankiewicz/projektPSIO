package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import AtakiInterfejs.SpecjalnyAtak;
import AtakiInterfejs.ZwyklyAtak;
import Bron.Bron;

import java.io.Serial;
import java.io.Serializable;

abstract public class Postac implements Serializable {
    //Version as of 11.12.2021 16:45
    @Serial
    private static final long serialVersionUID = 1900397209056382825L;

    // Deklaracja zmiennych punktow Postaci
    protected int hp = 150;
    protected int pancerz;
    protected String imie;
    protected String imageFilePath;
    protected Bron bron;
    protected AtakiInterfejs_I specjalnyAtak;
    protected AtakiInterfejs_I zwyklyAtak;
    private boolean czyPodpalony;

    // Konstruktory
    public Postac() {
        this.imie = "Bożydar";
    }

    public Postac(String imie, Bron bron)
    {
        this.imie = imie;
        this.bron = bron;
    }

    public void wykonajZwyklyAtak(Postac p, Bron b)
    {
        zwyklyAtak.Atak(p, b);
    }

    public void wykonajSpecjalnyAtak(Postac p, Bron b)
    {
        specjalnyAtak.Atak(p, b);
    }

    public String getStan()
    {
        return this.getClass().getSimpleName() + ": " + imie + "\n" +
                "HP: " + hp + "\n" +
                "Pancerz: " + pancerz;
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
