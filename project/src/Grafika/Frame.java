package Grafika;
import GraPackage.Gra;
import Postacie.Postac;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Postac wybranaPostacGracza;
    private Postac przeciwnik;
    private int numerTury;

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    //private JButton wykonajAkcje;

    private JList<Object> listaPostaci;
    private JList<Object> listaBroni;

    private JLabel zdjecieGracza;
    private JLabel zdjecieBroniGracza;
    private JLabel zdjeciePrzeciwnika;

    private JTextArea tura;
    private JTextArea opisGracza;
    private JTextArea opisPrzeciwnika;

    private Gra gra;

    public Frame(Postac wybranaPostacGracza){

        this.wybranaPostacGracza = wybranaPostacGracza;
        this.przeciwnik = wybranaPostacGracza;
        inicjalizujEkranGry();


        System.out.println("done");

    }

    public void inicjalizujEkranGry(){
        String path = "project/resources/img/Creeper.png";
        String text1 = "Stan gracza \nHp: 100 \nPancerz: 200";
        String text2 = "Stan przeciwnika \nHp: 100 \nPancerz: 200";
        tura = new JTextArea();
        tura.setText("Tura: " + numerTury);
        tura.setEditable(false);
        tura.setFont(new Font("Arial",Font.BOLD,25));
        tura.setBounds(0,0,500,50);
        tura.setBackground(null);
        this.add(tura);

        zdjecieGracza = new JLabel();
        opisGracza = new JTextArea();

        opisPrzeciwnika = new JTextArea();
        zdjeciePrzeciwnika= new JLabel();

        zdjecieGracza.setIcon(new ImageIcon(path));
        zdjecieGracza.setBounds(50,100,200,200);
        zdjecieGracza.setBackground(null);
        opisGracza.setText(text1);
        opisGracza.setEditable(false);
        opisGracza.setBounds(50,300,100,50);
        opisGracza.setBackground(null);
        this.add(zdjecieGracza);
        this.add(opisGracza);

        zdjeciePrzeciwnika.setIcon(new ImageIcon(path));
        zdjeciePrzeciwnika.setBounds(350,100,200,200);
        zdjeciePrzeciwnika.setBackground(null);
        opisPrzeciwnika.setText(text2);
        opisPrzeciwnika.setEditable(false);
        opisPrzeciwnika.setBounds(350,300,100,50);
        opisPrzeciwnika.setBackground(null);
        this.add(zdjeciePrzeciwnika);
        this.add(opisPrzeciwnika);

        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numerTury ++;
            tura.setText("Tura: " + numerTury);
        }

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
