package Grafika;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class WybierzBronLista implements ListSelectionListener {

    private String[] listaBroniWojownika = {"Miecz", "Młot"};
    private String[] listaBroniLowcy ={"Łuk"};
    private String[] listaBroniZabojcy = {"Sztylet"};
    private String[] listaBroniMaga = {"Różdżka"};
    private String[] listaBroni;

    private JList<?> lista;

    private JScrollPane przewijanie;
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();

    private String wybranaBron;




    public WybierzBronLista(String Postac){
        switch(Postac){
            case "Wojownik":
                listaBroni=listaBroniWojownika;
                break;
            case "Łowca":
                listaBroni=listaBroniLowcy;
                break;
            case "Zabójca":
                listaBroni=listaBroniZabojcy;
                break;
            case "Mag":
                listaBroni=listaBroniMaga;
                break;

        }

        lista = new JList<>(listaBroni);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);

        przewijanie= new JScrollPane(lista);
        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setFont(new Font("Calibri",Font.BOLD,20));



    }






    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            String wybor = (String) lista.getSelectedValue();
            wybranaBron = wybor;
            System.out.println(wybor);
        }

    }

    public JScrollPane getPrzewijanieBron() {
        return przewijanie;
    }



}
