package Postacie.WZwarciu;

import AtakiInterfejs.AtakiInterfejs_I;

import AtakiInterfejs.ZabojcaAtak;
import Bron.Bron;
import Bron.Zabojcy.BronZabojcy;
import Postacie.Postac;

public class Zabojca extends WZwarciu{

    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        atak = new ZabojcaAtak();
    }




    //todo
    

    


}
