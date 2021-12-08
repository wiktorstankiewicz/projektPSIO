package Postacie.WZwarciu;

import AtakiInterfejs.WojownikAtak;
import Bron.Bron;
import Bron.Woja.BronWoja;
import Postacie.Postac;

public class Wojownik extends WZwarciu{
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }

    //todo
}
