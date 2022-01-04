package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

public class LowcaSpecjalnyAtak extends SpecjalnyAtak {
    @Serial
    private static final long serialVersionUID = -6803643948199731392L;

    @Override
    public void Atak(Postac p, Bron b) {
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
    }
}
