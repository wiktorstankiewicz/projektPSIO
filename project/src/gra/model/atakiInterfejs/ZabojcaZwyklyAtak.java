package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.util.Random;

public class ZabojcaZwyklyAtak extends ZwyklyAtak {
    @Serial
    private static final long serialVersionUID = 450188599072076354L;

    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();

        if (7 >= generator.nextInt(100)) {
            p.setHp(0);
        } else {
            ZwyklyAtak.zadajMaleObrazenia(p, b);
        }
    }
}