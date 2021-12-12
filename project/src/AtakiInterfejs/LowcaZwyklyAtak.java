package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class LowcaZwyklyAtak extends SpecjalnyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}
