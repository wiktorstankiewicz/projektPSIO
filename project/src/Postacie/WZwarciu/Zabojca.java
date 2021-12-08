package Postacie.WZwarciu;

import AtakiInterfejs.AtakiInterfejs_I;

import AtakiInterfejs.ZabojcaAtak;
import Bron.Bron;
import Bron.Zabojcy.BronZabojcy;
import Postacie.Postac;

public class Zabojca extends WZwarciu{

    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
    }

    @Override
    public void Atak(Postac p,Bron b) {
        b=this.getBron();
        atak.Atak(p,b);
    }


    //todo
    

    


}
