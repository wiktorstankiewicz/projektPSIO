package gra.model.postacie.dystansowe;

import gra.model.atakiInterfejs.LowcaSpecjalnyAtak;
import gra.model.atakiInterfejs.LowcaZwyklyAtak;
import gra.model.bron.lowcy.BronLowcy;

import java.io.Serial;

public class Lowca extends Dystansowe {
    @Serial
    private static final long serialVersionUID = 8170214498469689186L;

    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/lowca.png";
        zwyklyAtak = new LowcaZwyklyAtak();
        specjalnyAtak = new LowcaSpecjalnyAtak();
        pancerz = 30;
    }
}
