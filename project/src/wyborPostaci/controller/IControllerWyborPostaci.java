package wyborPostaci.controller;


import gra.model.postacie.Postac;

import javax.swing.*;

public interface IControllerWyborPostaci {
    void usunPostacZListy(Postac postac);
    void dodajPostacDoListy(Postac postac);
    void wyswietlWyborPrzeciwnika(Postac gracz);
    Postac stworzPrzeciwnika(JList lista, int wybor);
    void rozpocznijGre(Postac gracz, Postac przeciwnik);
}
