package Postacie.WZwarciu;

import AtakiInterfejs.WojownikAtak;
import Bron.Bron;
import Postacie.Postac;

public class Wojownik extends WZwarciu{
    public Wojownik(String imie, String obrazek, Bron bron) {
        super(imie, obrazek, bron);
        atak = new WojownikAtak();
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }

    //todo
}
