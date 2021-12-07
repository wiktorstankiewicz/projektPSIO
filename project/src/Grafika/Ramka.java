package Grafika;
import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {
    private Object wybranaPostac;
    private Object przeciwnik;

    private JPanel panelWyboru;
    private JPanel panelRozgrywki;
    private JPanel panelKoncowy;

    private JScrollPane przewijanie;

    private JButton przyciskZatwierdzeniaPostaci;
    private JButton wykonajAkcje;

    private JList<Object> listaPostaci;
    private JList<Object> listaBroni;

    public Ramka(){
        wyswietlPanelWyboru();
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    public void wyswietlPanelWyboru(){
        WybierzPostacLista wybierzPostacLista = new WybierzPostacLista();
        panelWyboru = new JPanel();
        panelWyboru.setVisible(true);
        this.getContentPane().add(BorderLayout.WEST,wybierzPostacLista.getPrzewijanie());
        this.getContentPane().add(BorderLayout.NORTH, new JLabel("WYBÓR POSTACI",null,JLabel.CENTER));
        this.add(panelWyboru);
        panelWyboru.setPreferredSize(new Dimension(150,200));

        //panel.setVisible(false);
        //wyswietlanie listy mozliwych postaci, po wybraniu postaci i kliknieciu przycisku ustawia pole wybranaPostac
    }

    public void wyswietlPanelWyboruBroni(Graphics2D g2D, Object wybranaPostac){
        //wyswietlanie listy mozliwych broni, po wybraniu broni i kliknieciu przycisku ustawia pole bron
        // pola wybranaPostac

    }

    public void wyswietlPanelRozgrywki(Graphics2D g2D){
        //wyswietla postac i przeciwnika, bronie, ich stan i przycisk akcji(podejdź bądź zaatakuj)
    }

    public void wyswietlPanelKoncowy(Graphics2D g2D){
        //gdy gracz wygra, wyswietla "Wygrałeś", lub "Przegrałeś", gdy gracz przegra
    }

    public boolean czyKoniecGry(){
        //sprawdza, czy HP postaci jest wieksze od zera
        return false;
    }

    public void wyswietlPostac(Object postac, Graphics2D g2D){
        //wyswietla postac wraz z jej bronia
    }

    private void wyswietlStanPostaci(Object postac,Graphics2D g2D){
        //metoda bedzie wywolywana w metodzie wyswietl postac, wyswietla wszystkie parametry postaci(hp,pancerz...)
    }

    private void wylosujPrzeciwnika(){
        //losuje przeciwnika z listy dostepnych przeciwnikow
    }
}
