package Postacie.WZwarciu;

import AtakiInterfejs.ZabojcaZwyklyAtak;
import Bron.Zabojcy.BronZabojcy;

public class Zabojca extends WZwarciu {
    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/zabojca.png";
        atak = new ZabojcaZwyklyAtak();
        pancerz = 35;
    }
}
