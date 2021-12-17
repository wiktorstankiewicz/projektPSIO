package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

import java.util.Random;

public class ZabojcaSpecjalnyAtak extends SpecjalnyAtak {
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
