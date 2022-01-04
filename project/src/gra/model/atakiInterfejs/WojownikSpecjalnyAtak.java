package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.util.Random;

public class WojownikSpecjalnyAtak extends SpecjalnyAtak {
    @Serial
    private static final long serialVersionUID = 4611322185387868558L;

    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();
        if (30 >= generator.nextInt(100))
        {
            SpecjalnyAtak.zadajDuzeObrazenia(p, b);
        }
        SpecjalnyAtak.zadajDuzeObrazenia(p, b);
    }
}
