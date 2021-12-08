package AtakiInterfejs;
import Postacie.*;

public class MagAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postac P) {
        int ArmorTMP = P.getPrzeciwnik().getArmor();
        int DodgeTMP = P.getPrzeciwnik().getDodgeChance();
        P.getPrzeciwnik().setArmor(0);
        P.getPrzeciwnik().setDodgeChance(-1);
        P.ZadajObrazenia();
        P.getPrzeciwnik().setArmor(ArmorTMP);
        P.getPrzeciwnik().setDodgeChance(DodgeTMP);
    }
}
