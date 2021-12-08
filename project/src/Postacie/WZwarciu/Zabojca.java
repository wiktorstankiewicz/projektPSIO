package Postacie.WZwarciu;

import AtakiInterfejs.AtakiInterfejs_I;

import AtakiInterfejs.ZabojcaAtak;
import Bron.Bron;
import Postacie.Postac;

public class Zabojca extends WZwarciu{

    private int punktyZycia=100;
    private int pancerz = 10;
    private int szczescie = 10;

    public Zabojca(String imie, String obrazek, Bron bron) {
        super(imie, obrazek, bron);
        atak = new ZabojcaAtak();
    }

    @Override
    public void Atak(Postac p,Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }


    //todo
    

    


}
