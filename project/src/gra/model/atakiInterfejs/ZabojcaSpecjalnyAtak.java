package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.util.Random;

public class ZabojcaSpecjalnyAtak extends SpecjalnyAtak {
    @Serial
    private static final long serialVersionUID = -7482188352669524182L;

    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();

        if (25 >= generator.nextInt(100)) {
            p.setHp(0);
        } else {
            SpecjalnyAtak.zadajDuzeObrazenia(p, b);
        }
    }
}
