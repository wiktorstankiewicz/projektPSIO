package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

import java.util.Random;

public class WojownikZwyklyAtak extends ZwyklyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();
        if (15 >= generator.nextInt(100)) {
            ZwyklyAtak.zadajMaleObrazenia(p, b);
        }
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}