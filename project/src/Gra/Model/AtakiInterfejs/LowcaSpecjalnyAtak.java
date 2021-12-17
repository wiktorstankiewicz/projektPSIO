package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

public class LowcaSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
    }
}
