package gra.model.bron.woja;

import java.io.Serial;

public class Miecz extends BronWoja {
    @Serial
    private static final long serialVersionUID = -8488392604069015406L;

    public Miecz() {
        nazwa = "Miecz";
        obrazeniaMin = 20;
        obrazeniaMax = 26;
        imageFilePath = "project/resources/img/miecz.png";
    }
}
