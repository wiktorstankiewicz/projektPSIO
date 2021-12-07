package AtakiInterfejs;
import Postacie.*;

public class LowcaAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postacie P) {
        P.getPrzeciwnik().setDodgeChance(P.getDodgeChance()+10);
        P.ZadajObrazenia();
        P.getPrzeciwnik().setDodgeChance(P.getDodgeChance()-10); // :DD
    }
}
