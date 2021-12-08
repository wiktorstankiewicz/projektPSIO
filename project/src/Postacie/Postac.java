package Postacie;

abstract public class Postac {

    //todo Zadeklarowac intancje klasy Unik

    // Deklaracja zmiennych punktow Postaci
    private int atak;
    private int punktyZycia;
    private int pancerz;
    private int szczescie;
    private String imie;
    private String obrazek;
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
        this.atak = maksymalnyAtak;
        this.punktyZycia = maksymalnePunktyZycia;
        this.pancerz = maksymalnyPancerz;
        this.szczescie = maksymalneSzczescie;
        this.imie = "Bozydar";
        this.obrazek = "";
    }

    public Postac(int atak, int punktyZycia, int pancerz, int szczescie, String imie, String obrazek) {
        this.atak = atak;
        this.punktyZycia = punktyZycia;
        this.pancerz = pancerz;
        this.szczescie = szczescie;
        this.imie = imie;
        this.obrazek = obrazek;
    }
    //


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


    // Gettery
    public int getAtak() {
        return atak;
    }

    public String getImie() {
        return imie;
    }

    public int getPunktyZycia() {
        return punktyZycia;
    }

    public int getPancerz() {
        return pancerz;
    }

    public int getSzczescie() {
        return szczescie;
    }

    public String getObrazek() {
        return obrazek;
    }
    //


    // Settery
    public void setAtak(int atak) {
        this.atak = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalnyAtak, atak);
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setPunktyZycia(int punktyZycia) {
        this.punktyZycia = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalnePunktyZycia, punktyZycia);
    }

    public void setPancerz(int pancerz) {
        this.pancerz = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalnyPancerz, pancerz);
    }

    public void setSzczescie(int szczescie) {
        this.szczescie = getWartoscWPrzedziale(minimalnaWartoscPunktow, maksymalneSzczescie, szczescie);
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }
}
