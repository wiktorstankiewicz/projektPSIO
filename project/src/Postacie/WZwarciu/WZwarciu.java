package Postacie.WZwarciu;

import Postacie.Postac;

abstract public class WZwarciu extends Postac {
    // Konstruktor

    public WZwarciu() {
        super();
    }

    public WZwarciu(int atak, int punktyZycia, int pancerz, int szczescie, String imie, String obrazek) {
        super(atak, punktyZycia, pancerz, szczescie, imie, obrazek);
    }
    //
    //todo
}
