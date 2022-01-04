package gra.model.bron.maga;

import java.io.Serial;

public class Rozdzka extends BronMaga {
    @Serial
    private static final long serialVersionUID = 3345721276270136122L;

    public Rozdzka() {
        nazwa = "Rozdzka";
        obrazeniaMin = 12;
        obrazeniaMax = 22;
        imageFilePath = "project/resources/img/rozdzka.png";
    }
}
