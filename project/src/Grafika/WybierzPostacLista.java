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
    String wybranaPostac;

    public void pokazWybor() {

        JFrame wyborPostaci = new JFrame();
        wyborPostaci.setSize(150,200);
        wyborPostaci.setLocationRelativeTo(null);


        wyborPostaci.setTitle("Wybór postaci");

        JPanel panel=new JPanel();

        panel.add(przewijanie);
        panel.setVisible(true);

        wyborPostaci.setResizable(false);
        wyborPostaci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wyborPostaci.add(panel);

        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
        lista.setFont(new Font("Calibri",Font.BOLD,20));
        wyborPostaci.setVisible(true);
    }


    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            wybranaPostac = (lista.getSelectedValue().toString());
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
