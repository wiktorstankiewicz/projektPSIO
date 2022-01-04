package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

public class LowcaZwyklyAtak extends SpecjalnyAtak {
    @Serial
    private static final long serialVersionUID = 3939226802041933993L;

    @Override
    public void Atak(Postac p, Bron b) {
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}
