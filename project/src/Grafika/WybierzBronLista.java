package Grafika;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class WybierzBronLista implements ListSelectionListener {

    String[] listaBroniWojownika = {"Wojownik", "Zabójca", "Łowca", "Mag"};
    String[] listaBroniŁowcy ={"Łuk"};
    String[] listaBroniZabojcy = {"Sztylet"};
    String[] listaBroniMaga = {"Różdżka"};
    String[] listaBroni;

    public WybierzBronLista(String Postac){

        switch(Postac){
            case "Wojownik":
                listaBroni=listaBroniWojownika;
                break;
            case "Łowca":
                listaBroni=listaBroniŁowcy;
                break;
            case "Zabójca":
                listaBroni=listaBroniZabojcy;
                break;
            case "Mag":
                listaBroni=listaBroniMaga;
                break;

        }
    }

    JList<?> lista = new JList<>(listaBroni);

    JScrollPane przewijanie = new JScrollPane(lista);
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();

    String wybranaBron;

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


    }


    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            String wybor = (String) lista.getSelectedValue();
            wybranaBron = wybor;
            System.out.println(wybor);
        }

    }


}
