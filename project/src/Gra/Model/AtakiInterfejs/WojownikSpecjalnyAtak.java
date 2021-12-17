package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

import java.util.Random;

public class WojownikSpecjalnyAtak extends SpecjalnyAtak {
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
