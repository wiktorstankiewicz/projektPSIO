package gra.model.postacie.wZwarciu;

import gra.model.atakiInterfejs.ZabojcaSpecjalnyAtak;
import gra.model.atakiInterfejs.ZabojcaZwyklyAtak;
import gra.model.bron.zabojcy.BronZabojcy;

import java.io.Serial;

public class Zabojca extends WZwarciu {
    @Serial
    private static final long serialVersionUID = 5789042692024310671L;

    public Zabojca(String imie, BronZabojcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/zabojca.png";
        zwyklyAtak = new ZabojcaZwyklyAtak();
        specjalnyAtak = new ZabojcaSpecjalnyAtak();
        pancerz = 35;
    }
}
