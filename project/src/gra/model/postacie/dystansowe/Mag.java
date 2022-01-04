package gra.model.postacie.dystansowe;

import gra.model.atakiInterfejs.MagSpecjalnyAtak;
import gra.model.atakiInterfejs.MagZwyklyAtak;
import gra.model.bron.maga.BronMaga;

import java.io.Serial;

public class Mag extends Dystansowe {
    @Serial
    private static final long serialVersionUID = 2646324586833761642L;

    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/mag.png";
        zwyklyAtak = new MagZwyklyAtak();
        specjalnyAtak = new MagSpecjalnyAtak();
        pancerz = 15;
    }
}
