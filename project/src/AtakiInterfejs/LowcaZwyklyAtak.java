package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class LowcaZwyklyAtak extends SpecjalnyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}
