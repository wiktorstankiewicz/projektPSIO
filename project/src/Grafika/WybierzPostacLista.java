package Grafika;

//import Postac.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class WybierzPostacLista implements ListSelectionListener {

    private String[] listaKlas = {"Wojownik", "Zabójca", "Łowca", "Mag"};
    private JList<?> lista = new JList<>(listaKlas);
    private JScrollPane przewijanie = new JScrollPane(lista);
    private String wybranaPostac;

    public WybierzPostacLista() {
        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
        lista.setFont(new Font("Calibri",Font.BOLD,20));
    }


    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            System.out.println((String)lista.getSelectedValue());

        }

    }

    public String getWybranaPostac(){
        return ((String) lista.getSelectedValue());
    }

    public JList<?> getLista() {
        return lista;
    }

    public JScrollPane getPrzewijanie() {
        return przewijanie;
    }
}
