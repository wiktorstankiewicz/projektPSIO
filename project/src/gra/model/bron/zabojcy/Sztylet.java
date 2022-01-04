package gra.model.bron.zabojcy;

import java.io.Serial;

public class Sztylet extends BronZabojcy {
    @Serial
    private static final long serialVersionUID = 7353090641190129827L;

    public Sztylet() {
        nazwa = "Sztylet";
        obrazeniaMin = 12;
        obrazeniaMax = 20;
        imageFilePath = "project/resources/img/sztylet.png";
    }
}
