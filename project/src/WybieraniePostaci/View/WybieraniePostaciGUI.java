package WybieraniePostaci.View;

import Postacie.Postac;
import WybieraniePostaci.Model.WybieraniePostaciModel;

import javax.swing.*;
import java.awt.*;

public class WybieraniePostaciGUI extends JFrame {
    private final static int WIDTH = 600;
    private final static int HEIGHT = 300;

    private JList<Postac> JListaPostaciGracza;

    private String tytul;

    public WybieraniePostaciGUI(String tytul){
        this.tytul = tytul;
    }

    public void inicjalizuj(WybieraniePostaciModel model){
        JListaPostaciGracza = new JList<Postac>(model.getPostacieGracza());
        JListaPostaciGracza.setSize(new Dimension(100,50));
        //listaPrzeciwnikow = new JList<>((ListModel<Postac>) model.getPostacie());
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setTitle(tytul);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(true);
        this.setAlwaysOnTop(true);

        this.add(BorderLayout.WEST,JListaPostaciGracza);


    }

    public void update(WybieraniePostaciModel model){

    }
}
