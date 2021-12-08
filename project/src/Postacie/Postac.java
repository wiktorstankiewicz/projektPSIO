package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;

abstract public class Postac implements AtakiInterfejs_I {


    // Deklaracja zmiennych punktow Postaci
    protected int hp=100;
    protected int pancerz;
    protected int szczescie;
    protected String imie;
    protected String imageFilePath;
    protected Bron bron;
    protected AtakiInterfejs_I atak;
    //


    // Deklaracja finalnych wartosci minimalnych i maksymalnych dla punktow Postaci
    final protected int minimalnaWartoscPunktow = 0;
    final protected int maksymalnyAtak = 100;
    final protected int maksymalnePunktyZycia = 100;
    final protected int maksymalnyPancerz = 100;
    final protected int maksymalneSzczescie = 100;
    //

    // Konstruktory
    public Postac(){
        this.imie = "Bozydar";
    }

    public Postac(String imie, Bron bron) {
        this.imie = imie;
        this.bron=bron;
    }
    //


    /*
    // Funkcja sprawdzajaca czy wartosc punktow zawiera sie w przedziale min-max
    private int getWartoscWPrzedziale(int minimalnaWartoscPunktow, int maksymalnaWartoscPunktow, int wartoscPunktow) {
        int nowaWartoscPunktow = wartoscPunktow;

        if (wartoscPunktow < minimalnaWartoscPunktow) {
            nowaWartoscPunktow = minimalnaWartoscPunktow;
        } else if (wartoscPunktow > maksymalnaWartoscPunktow) {
            nowaWartoscPunktow = maksymalnaWartoscPunktow;
        }
        return nowaWartoscPunktow;
    }
    //
    */


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

    /*
    public int getAtak() {
        return atak;
    }

    public String getImie() {
        return imie;
    }



    public int getSzczescie() {
        return szczescie;
    }
    */

    public String getStan(){
        return "Stan\n Hp: "+hp+"\nPancerz:"+pancerz;
    }
    //


    // Settery
     public void setHp(int hp) {
        this.hp=hp;
    }

    public void setPancerz(int pancerz) {
        this.pancerz = pancerz;
    }

    public void setImie(String imie){
        this.imie = imie;
    };

    public String getImie(){
        return imie;
    }
//todo
//    public void setAtak(int atak) {
//        this.atak = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalnyAtak, atak);
//    }
//
//    public void setSzczescie(int szczescie) {
//        this.szczescie = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalneSzczescie, szczescie);
//    }
//
//    public void setObrazek(String obrazek) {
//        this.obrazek = obrazek;
//    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }
}
