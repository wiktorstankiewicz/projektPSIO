package gra.model.postacie.wZwarciu;

import gra.model.atakiInterfejs.WojownikSpecjalnyAtak;
import gra.model.atakiInterfejs.WojownikZwyklyAtak;
import gra.model.bron.woja.BronWoja;

import java.io.Serial;

public class Wojownik extends WZwarciu {
    @Serial
    private static final long serialVersionUID = -8453462416289839175L;

    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        zwyklyAtak = new WojownikZwyklyAtak();
        specjalnyAtak = new WojownikSpecjalnyAtak();
        pancerz = 50;
    }
}
