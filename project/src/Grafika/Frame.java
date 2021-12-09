package Grafika;
import GraPackage.Gra;
import Postacie.Postac;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Postac wybranaPostacGracza;
    private Postac przeciwnik;
   private int numerTury;

    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    //private JButton wykonajAkcje;

    private JList<Object> listaPostaci;
    private JList<Object> listaBroni;

    private JLabel zdjecieGracza;
    private JLabel zdjecieBroniGracza;
    private JLabel zdjeciePrzeciwnika;

    private JTextArea tura;
    private JTextArea opisGracza;
    private JTextArea opisPrzeciwnika;

    private JTextArea infKoncowa;


    public Frame(Gra gra){

        wybranaPostacGracza = gra.getGracz();
        przeciwnik = gra.getPrzeciwnik();
        inicjalizujEkranGry(gra);


        System.out.println("done");

    }

    public void inicjalizujEkranGry(Gra gra){
       /* String path = "project/resources/img/Creeper.png";
        String text1 = "Stan gracza \nHp: 100 \nPancerz: 200";
        String text2 = "Stan przeciwnika \nHp: 100 \nPancerz: 200";*/


        initGracz(gra);
        initPrzeciwnik(gra);
        initTura(gra);


        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);


    }

    public void initTura(Gra gra){
        tura = new JTextArea();
        tura.setText("Tura: " + gra.getTurn());
        tura.setEditable(false);
        tura.setFont(new Font("Arial",Font.BOLD,25));
        tura.setBounds(0,0,500,50);
        tura.setBackground(null);
        this.add(tura);
    }

    public void initGracz(Gra gra){
        zdjecieGracza = new JLabel();
        opisGracza = new JTextArea();

        zdjecieGracza.setIcon(new ImageIcon(gra.getGracz().getImageFilePath()));
        zdjecieGracza.setBounds(50,100,300,300);
        zdjecieGracza.setBackground(null);
        opisGracza.setText(gra.getGracz().getStan());
        opisGracza.setEditable(false);
        opisGracza.setBounds(50,400,100,300);
        opisGracza.setFont(new Font("Comic sans",Font.BOLD,20));
        opisGracza.setBackground(null);
        this.add(zdjecieGracza);
        this.add(opisGracza);
    }

    public void initPrzeciwnik(Gra gra){
        opisPrzeciwnika = new JTextArea();
        zdjeciePrzeciwnika= new JLabel();

        zdjeciePrzeciwnika.setIcon(new ImageIcon(gra.getPrzeciwnik().getImageFilePath()));
        zdjeciePrzeciwnika.setBounds(600,100,300,300);
        zdjeciePrzeciwnika.setBackground(null);
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        opisPrzeciwnika.setEditable(false);
        opisPrzeciwnika.setBounds(600,400,100,300);
        opisPrzeciwnika.setFont(new Font("Comic sans",Font.BOLD,20));
        opisPrzeciwnika.setBackground(null);
        this.add(zdjeciePrzeciwnika);
        this.add(opisPrzeciwnika);
    }

    public void update(Gra gra){
        tura.setText("Tura: " + gra.getTurn());
        opisGracza.setText(gra.getGracz().getStan());
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
    }

    public void pokazKomunikatKoncowy(boolean czyGraczWygral){
        infKoncowa = new JTextArea();
        infKoncowa.setBounds(300,0,300,100);
        infKoncowa.setFont(new Font("Comic sans", Font.PLAIN,30));
        infKoncowa.setEditable(false);
        if(czyGraczWygral){
            infKoncowa.setText("Wygrales!");
            this.add(infKoncowa);
            return;
        }
        infKoncowa.setText("Przegrałeś!");
        this.add(infKoncowa);
    }

    public void pokazKomunikatOPorazce() {

    }

    public void wyswietlPanelRozgrywki(Gra gra){

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
