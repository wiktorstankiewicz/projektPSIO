package Gra.Model.Postacie.WZwarciu;

import Gra.Model.AtakiInterfejs.ZabojcaSpecjalnyAtak;
import Gra.Model.AtakiInterfejs.ZabojcaZwyklyAtak;
import Gra.Model.Bron.Zabojcy.BronZabojcy;

public class Zabojca extends WZwarciu {
    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/zabojca.png";
        zwyklyAtak = new ZabojcaZwyklyAtak();
        specjalnyAtak = new ZabojcaSpecjalnyAtak();
        pancerz = 35;
    }
}
