package Postacie;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;

abstract public class Postac implements AtakiInterfejs_I {

    //todo Zadeklarowac instancje klasy Unik

    // Deklaracja zmiennych punktow Postaci
    private int hp=100;
    private int pancerz;
    private int szczescie;
    private String imie;
    private String obrazek;
    private Bron bron;
    protected AtakiInterfejs_I atak;
    //


    // Deklaracja finalnych wartosci minimalnych i maksymalnych dla punktow Postaci
    final private int minimalnaWartoscPunktow = 0;
    final private int maksymalnyAtak = 100;
    final private int maksymalnePunktyZycia = 100;
    final private int maksymalnyPancerz = 100;
    final private int maksymalneSzczescie = 100;
    //

    // Konstruktory
    public Postac(){

        this.imie = "Bozydar";
        this.obrazek = "";
    }

    public Postac(String imie, String obrazek, Bron bron) {
        this.imie = imie;
        this.obrazek = obrazek;
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
    public String getObrazek() {
        return obrazek;
    }

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
    /*
    public void setAtak(int atak) {
        this.atak = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalnyAtak, atak);
    }

    public void setImie(String imie) {
        this.imie = imie;
    }



    public void setSzczescie(int szczescie) {
        this.szczescie = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalneSzczescie, szczescie);
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }

     */
}
