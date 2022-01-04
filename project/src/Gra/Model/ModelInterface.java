package Gra.Model;

import Gra.Model.Bron.Bron;
import Gra.Model.Observers.Observer;
import Gra.Model.Postacie.Postac;

public interface ModelInterface {
    Postac getPrzeciwnik();
    Postac getGracz();
    int getDistance();
    String getAkcja();
    void setAkcja(String akcja);
    int getTurn();
    boolean getGRACZ_WYGRANA();
    boolean getPRZECIWNIK_WYGRANA();
    void zmianaAtaku(Postac x, Postac y, Bron b, int rodzajAtaku);
    void registerObserver(Observer o);
    void normalAttackButton(int number);
    void walkUpAction();
}
