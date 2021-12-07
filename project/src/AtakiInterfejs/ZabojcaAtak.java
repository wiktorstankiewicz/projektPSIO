package AtakiInterfejs;
import Postacie.*;
import java.util.*;

public class ZabojcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postacie P) {
        Random los = new Random();
        if (10 < los.nextInt(100)) {
            P.getPrzeciwnik().setHp(0);
        } else {
            P.ZadajObrazenia();
        }
    }
}