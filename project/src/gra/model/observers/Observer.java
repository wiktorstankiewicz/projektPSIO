package gra.model.observers;

import gra.model.postacie.Postac;

public interface Observer {
    void update(boolean GRACZ_WYGRANA, boolean PRZECIWNIK_WYGRANA, int distance, int turn, String akcja, Postac gracz, Postac przeciwnik);
}
