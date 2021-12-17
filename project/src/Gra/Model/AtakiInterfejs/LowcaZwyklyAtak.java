package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

public class LowcaZwyklyAtak extends SpecjalnyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}
