package gra.model.bron.woja;

import java.io.Serial;

public class Mlot extends BronWoja {
    @Serial
    private static final long serialVersionUID = 537654983181819801L;

    public Mlot() {
        nazwa = "Mlot";
        obrazeniaMin = 12;
        obrazeniaMax = 36;
        imageFilePath = "project/resources/img/mlot.png";
    }
}
