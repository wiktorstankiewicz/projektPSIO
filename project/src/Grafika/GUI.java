package Grafika;

import GraPackage.Gra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {

    private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private final String backgroundImageFilePath = "project/resources/img/tlo.png";
    private int attackChoice=1;
    private boolean nextTurn=false;

    private JLabel zdjecieGracza;
    private JLabel zdjecieBroniGracza;
    private JLabel zdjeciePrzeciwnika;
    private JLabel zdjecieBroniPrzeciwnika;

    private JTextArea tura;
    private JTextArea opisGracza;
    private JTextArea opisPrzeciwnika;

    private JTextArea infKoncowa;
    private JTextArea wykonanaAkcja;
    private JTextArea dystans;

    private Color kolorTekstu = Color.BLACK;

    public GUI(Gra gra) {
        inicjalizujEkranGry(gra);
    }

    public void inicjalizujEkranGry(Gra gra) {
        initBackgroundImage();
        initGracz(gra);
        initBronGracza(gra);
        initPrzeciwnik(gra);
        initBronPrzeciwnika(gra);
        initTura(gra);
        initWykonanaAkcja();
        initDystans(gra);

        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        JButton normalAttackButton = new JButton("Zwykły atak");
        JButton specialAttackButton = new JButton("Specjalny atak");
        JButton walkUpButton = new JButton("Podejdź");
        normalAttackButton.addActionListener(e -> {
            attackChoice = 1;
            nextTurn=true;
        });

        specialAttackButton.addActionListener(e -> {
            attackChoice = 2;
            nextTurn=true;
        });

        walkUpButton.addActionListener(e -> {
            attackChoice = 3;
            nextTurn=true;
        });
        normalAttackButton.setBounds(410,75,125,40);
        specialAttackButton.setBounds(410,115,125,40);
        walkUpButton.setBounds(410,155,125,40);
        normalAttackButton.setVisible(true);
        specialAttackButton.setVisible(true);
        walkUpButton.setVisible(true);

        this.add(normalAttackButton);
        this.add(specialAttackButton);
        this.add(walkUpButton);


    }

    public void initBackgroundImage(){
        class BackgroundImagePanel extends JComponent{
            private BufferedImage image;

            public BackgroundImagePanel(){
                try {
                    image = ImageIO.read(new File(backgroundImageFilePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.setVisible(true);
            }
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(image,0,0,this);
            }
        }
        this.setContentPane(new BackgroundImagePanel());

    }

    public void initTura(Gra gra) {
        tura = new JTextArea();
        tura.setText("Tura: " + gra.getTurn());
        tura.setEditable(false);
        tura.setFont(new Font("Comic sans", Font.BOLD, 25));
        tura.setForeground(kolorTekstu);
        tura.setBounds(0, 0, 150, 50);
        tura.setBackground(null);
        this.add(tura);
        tura.setOpaque(false);
    }

    public void initGracz(Gra gra) {
        zdjecieGracza = new JLabel();
        opisGracza = new JTextArea();

        zdjecieGracza.setIcon(new ImageIcon(gra.getGracz().getImageFilePath()));
        zdjecieGracza.setBounds(50, 100, 300, 300);
        zdjecieGracza.setBackground(null);
        zdjecieGracza.setText(gra.getGracz().getClass().getSimpleName() + ": " + gra.getGracz().getImie());
        opisGracza.setText(gra.getGracz().getStan());
        opisGracza.setEditable(false);
        opisGracza.setBounds(50, 450, 400, 150);
        opisGracza.setBackground(new Color(0, 100, 0));
        opisGracza.setFont(new Font("Comic sans", Font.BOLD, 20));
        opisGracza.setForeground(kolorTekstu);
        this.add(zdjecieGracza);
        this.add(opisGracza);
        opisGracza.setOpaque(false);
    }

    public void initPrzeciwnik(Gra gra) {
        opisPrzeciwnika = new JTextArea();
        zdjeciePrzeciwnika = new JLabel();

        zdjeciePrzeciwnika.setIcon(new ImageIcon(gra.getPrzeciwnik().getImageFilePath()));
        zdjeciePrzeciwnika.setBounds(600, 100, 300, 300);
        zdjeciePrzeciwnika.setBackground(null);
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        opisPrzeciwnika.setEditable(false);
        opisPrzeciwnika.setBounds(600, 450, 400, 300);
        opisPrzeciwnika.setBackground(new Color(0, 100, 0));
        opisPrzeciwnika.setFont(new Font("Comic sans", Font.BOLD, 20));
        opisPrzeciwnika.setBackground(null);
        opisPrzeciwnika.setForeground(kolorTekstu);
        this.add(zdjeciePrzeciwnika);
        this.add(opisPrzeciwnika);
        opisPrzeciwnika.setOpaque(false);
    }

    public void initBronGracza(Gra gra) {
        zdjecieBroniGracza = new JLabel();

        zdjecieBroniGracza.setIcon(new ImageIcon(gra.getGracz().getBron().getImageFilePath()));
        zdjecieBroniGracza.setBounds(350, 300, 100, 100);
        zdjecieBroniGracza.setBackground(null);
        this.add(zdjecieBroniGracza);
    }

    public void initBronPrzeciwnika(Gra gra) {
        zdjecieBroniPrzeciwnika = new JLabel();

        zdjecieBroniPrzeciwnika.setIcon(new ImageIcon(gra.getPrzeciwnik().getBron().getImageFilePath()));
        zdjecieBroniPrzeciwnika.setBounds(500, 300, 100, 100);
        zdjecieBroniPrzeciwnika.setBackground(null);
        this.add(zdjecieBroniPrzeciwnika);
    }

    public void initDystans(Gra gra) {
        dystans = new JTextArea();
        dystans.setText("Dystans: " + gra.getDistance());
        dystans.setEditable(false);
        dystans.setForeground(kolorTekstu);
        dystans.setFont(new Font("Arial", Font.BOLD, 25));
        dystans.setBounds(410, 200, 150, 200);
        dystans.setBackground(null);
        this.add(dystans);
        dystans.setOpaque(false);
    }

    public void initWykonanaAkcja() {
        wykonanaAkcja = new JTextArea();
        wykonanaAkcja.setEditable(false);
        wykonanaAkcja.setForeground(kolorTekstu);
        wykonanaAkcja.setFont(new Font("Arial", Font.BOLD, 25));
        wykonanaAkcja.setBounds(50, 600, 1000, 200);
        wykonanaAkcja.setBackground(null);
        this.add(wykonanaAkcja);
        wykonanaAkcja.setOpaque(false);
    }

    public void update(Gra gra) {
        tura.setText("Tura: " + gra.getTurn());
        opisGracza.setText(gra.getGracz().getStan());
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        dystans.setText("Dystans: " + gra.getDistance());
        wykonanaAkcja.setText(gra.getAkcja());
    }

    public void pokazKomunikatKoncowy(boolean czyGraczWygral) {
        infKoncowa = new JTextArea();
        this.add(infKoncowa);
        infKoncowa.setOpaque(false);
        infKoncowa.setBounds(400, 20, 250, 60);
        infKoncowa.setBackground(null);
        infKoncowa.setFont(new Font("Comic sans", Font.PLAIN, 30));
        infKoncowa.setEditable(false);
        infKoncowa.setForeground(kolorTekstu);
        if (czyGraczWygral) {
            infKoncowa.setText("Wygrales!");
            return;
        }
        infKoncowa.setText("Przegrałeś!");
    }

    public int getattackChoice(){
        return attackChoice;
    }
    public void setattackChoice(int attackChoice){
        this.attackChoice=attackChoice;
    }
    public boolean getnextTurn(){
        return nextTurn;
    }
    public void setNextTurn(boolean nextTurn){
        this.nextTurn=nextTurn;
    }
}
