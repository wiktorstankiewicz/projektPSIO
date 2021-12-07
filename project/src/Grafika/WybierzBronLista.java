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

    private JScrollPane przewijanie;
    private JList<?> lista;
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
        lista.setFont(new Font("Calibri",Font.BOLD,20));

        przewijanie= new JScrollPane(lista);
        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void pokazWybor() {

        JFrame wyborBroni = new JFrame();
        wyborBroni.setSize(150,200);
        wyborBroni.setLocationRelativeTo(null);


        wyborBroni.setTitle("Wybór postaci");

        JPanel panel=new JPanel();

        panel.add(przewijanie);
        panel.setVisible(true);

        wyborBroni.setResizable(false);
        wyborBroni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wyborBroni.add(panel);

        przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(this);
        lista.setFont(new Font("Calibri",Font.BOLD,20));
        wyborBroni.setVisible(true);
    }


    @Override
    public void valueChanged(ListSelectionEvent zaznaczenie) {
        if (!zaznaczenie.getValueIsAdjusting()) {
            wybranaBron=((String)lista.getSelectedValue());
        }
    }

    public JScrollPane getPrzewijanieBron() {
        return przewijanie;
    }

    public String getWybranaBron(){
        return wybranaBron;
    }



}
