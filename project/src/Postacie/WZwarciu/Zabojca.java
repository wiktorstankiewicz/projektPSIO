package Postacie.WZwarciu;

import AtakiInterfejs.ZabojcaSpecjalnyAtak;
import AtakiInterfejs.ZabojcaZwyklyAtak;
import Bron.Zabojcy.BronZabojcy;

public class Zabojca extends WZwarciu {
    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/zabojca.png";
        zwyklyAtak = new ZabojcaZwyklyAtak();
        specjalnyAtak = new ZabojcaSpecjalnyAtak();
        pancerz = 35;
    }
}
