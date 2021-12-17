package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

import java.util.Random;

public class ZabojcaZwyklyAtak extends ZwyklyAtak {
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