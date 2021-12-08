package Postacie.WZwarciu;

import AtakiInterfejs.AtakiInterfejs_I;
import Bron.Bron;
import Postacie.Postac;

abstract public class WZwarciu extends Postac implements AtakiInterfejs_I {
    public WZwarciu(String imie, Bron bron) {
        super(imie, bron);
    }
    //todo
}
