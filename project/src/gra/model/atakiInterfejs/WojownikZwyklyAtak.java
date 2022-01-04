package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.util.Random;

public class WojownikZwyklyAtak extends ZwyklyAtak {
    @Serial
    private static final long serialVersionUID = -1284579421598233880L;

    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();
        if (15 >= generator.nextInt(100)) {
            ZwyklyAtak.zadajMaleObrazenia(p, b);
        }
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}