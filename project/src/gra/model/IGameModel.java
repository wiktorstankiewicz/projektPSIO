package gra.model;

import gra.model.bron.Bron;
import gra.model.observers.Observer;
import gra.model.postacie.Postac;

public interface IGameModel {
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
    void normalAttack(int number);
    void walkUpAction();
}
