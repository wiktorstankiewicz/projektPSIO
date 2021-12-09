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
    private JTextArea wykonanaAkcja;
    private JTextArea dystans;


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
        initWykonanaAkcja();
        initDystans(gra);

        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);


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
        zdjecieGracza.setText(gra.getGracz().getClass().getSimpleName() + ": " + gra.getGracz().getImie());
        opisGracza.setText(gra.getGracz().getStan());
        opisGracza.setEditable(false);
        opisGracza.setBounds(50,450,400,300);
        opisGracza.setBackground(new Color(0,100,0));
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
        opisPrzeciwnika.setBounds(600,450,400,300);
        opisPrzeciwnika.setBackground(new Color(0,100,0));
        opisPrzeciwnika.setFont(new Font("Comic sans",Font.BOLD,20));
        opisPrzeciwnika.setBackground(null);
        this.add(zdjeciePrzeciwnika);
        this.add(opisPrzeciwnika);
    }

    public void initDystans(Gra gra){
        dystans = new JTextArea();
        dystans.setText("Dystans: " + gra.getDistance());
        dystans.setEditable(false);
        dystans.setFont(new Font("Arial",Font.BOLD,25));
        dystans.setBounds(375,200,200,200);
        dystans.setBackground(null);
        this.add(dystans);
    }

    public void initWykonanaAkcja(){
        wykonanaAkcja = new JTextArea();
        wykonanaAkcja.setText("Akcja: \n");
        wykonanaAkcja.setEditable(false);
        wykonanaAkcja.setFont(new Font("Arial",Font.BOLD,25));
        wykonanaAkcja.setBounds(50,600,500,200);
        wykonanaAkcja.setBackground(null);
        this.add(wykonanaAkcja);
    }

    public void update(Gra gra){
        tura.setText("Tura: " + gra.getTurn());
        opisGracza.setText(gra.getGracz().getStan());
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        dystans.setText("Dystans: " + gra.getDistance());
        wykonanaAkcja.setText(gra.getAkcja());

    }

    public void pokazKomunikatKoncowy(boolean czyGraczWygral){
        infKoncowa = new JTextArea();
        this.add(infKoncowa);
        infKoncowa.setBounds(400,20,250,60);
        infKoncowa.setBackground(null);
        infKoncowa.setFont(new Font("Comic sans", Font.PLAIN,30));
        infKoncowa.setEditable(false);
        if(czyGraczWygral){
            infKoncowa.setText("Wygrales!");

            return;
        }
        infKoncowa.setText("Przegrałeś!");
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
