package Postacie.WZwarciu;

import AtakiInterfejs.ZabojcaAtak;
import Bron.Zabojcy.BronZabojcy;

public class Zabojca extends WZwarciu {
    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/zabojca.png";
        atak = new ZabojcaAtak();
        pancerz = 10;
    }
}
