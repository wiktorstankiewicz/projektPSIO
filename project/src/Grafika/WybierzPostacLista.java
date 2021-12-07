package Grafika;

//import Postac.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class WybierzPostacLista implements ListSelectionListener {

    String[] listaKlas = {"Wojownik", "Zabójca", "Łowca", "Mag"};
    JList<?> lista = new JList<>(listaKlas);
    JScrollPane przewijanie = new JScrollPane(lista);
    String wybranaPostac;

    public WybierzPostacLista() {
        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setVisibleRowCount(4);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
    }


    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            wybranaPostac = (String) lista.getSelectedValue();
            System.out.println(wybranaPostac);
        }

    }

    public String getWybranaPostac(){
        return wybranaPostac;
    }

    public JList<?> getLista() {
        return lista;
    }

    public JScrollPane getPrzewijanie() {
        return przewijanie;
    }
}
