package Grafika;

import Postac.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class WybierzPostacLista implements ListSelectionListener {

    String[] listaKlas = {"Wojownik", "Zabójca", "Łowca", "Mag"};

    JList<?> lista = new JList<>(listaKlas);

    JScrollPane przewijanie = new JScrollPane(lista);
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    String wybranaPostac;

    public void dzialaj() {

        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.setSize(300, 300);
        frame.add(panel);
        frame.setVisible(true);
        panel.setVisible(true);
        panel.add(przewijanie);
        lista.setVisibleRowCount(4);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
        //panel.setVisible(false);

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
}
