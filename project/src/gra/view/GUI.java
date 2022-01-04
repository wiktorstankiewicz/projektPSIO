package gra.view;

import gra.controller.GameController;
import gra.controller.IGameController;
import gra.model.IGameModel;
import gra.model.observers.Observer;
import gra.model.postacie.Postac;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame implements Observer {

    private final IGameController kontroler;
    private final IGameModel gra;

    private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private final String backgroundImageFilePath = "project/resources/img/tlo.png";
    private int attackChoice=1;
    private boolean nextTurn=false;

    private JLabel zdjecieGracza;
    private JLabel zdjecieBroniGracza;
    private JLabel zdjeciePrzeciwnika;
    private JLabel zdjecieBroniPrzeciwnika;

    private JProgressBar healthBarGracza;
    private JProgressBar healthBarPrzeciwnika;

    private JButton normalAttackButton;
    private JButton specialAttackButton;
    private JButton walkUpButton;

    private JTextArea tura;
    private JTextArea opisGracza;
    private JTextArea opisPrzeciwnika;

    private JTextPane infKoncowa;
    private JTextArea wykonanaAkcja;
    private JTextArea dystans;

    private Color kolorTekstu = Color.WHITE;

    public GUI(IGameModel gra, GameController kontroler) {
        this.kontroler = kontroler;
        this.gra = gra;
        gra.registerObserver(this);
        inicjalizujEkranGry(gra);
    }

    public void inicjalizujEkranGry(IGameModel gra) {
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

        normalAttackButton = new JButton("Zwykły atak");
        specialAttackButton = new JButton("Specjalny atak");
        walkUpButton = new JButton("Podejdź");

        normalAttackButton.setBackground(Color.DARK_GRAY);
        specialAttackButton.setBackground(Color.DARK_GRAY);
        walkUpButton.setBackground(Color.DARK_GRAY);

        normalAttackButton.setForeground(Color.WHITE);
        specialAttackButton.setForeground(Color.WHITE);
        walkUpButton.setForeground(Color.WHITE);

        normalAttackButton.addActionListener(e -> kontroler.kliknietoGuzik(normalAttackButton));
        specialAttackButton.addActionListener(e -> kontroler.kliknietoGuzik(specialAttackButton));
        walkUpButton.addActionListener(e -> kontroler.kliknietoGuzik(walkUpButton));

        normalAttackButton.setFocusable(false);
        specialAttackButton.setFocusable(false);
        walkUpButton.setFocusable(false);

        normalAttackButton.setBounds(415,80,125,35);
        specialAttackButton.setBounds(415,115,125,35);
        walkUpButton.setBounds(415,150,125,35);

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

    public void initTura(IGameModel gra) {
        tura = new JTextArea();
        tura.setText("Tura: " + gra.getTurn());
        tura.setEditable(false);
        tura.setFont(new Font("Comic sans", Font.BOLD, 25));
        tura.setForeground(kolorTekstu);
        tura.setBounds(0, 0, 100, 40);
        tura.setBackground(null);
        this.add(tura);
        tura.setBackground(Color.black);
    }

    public void initGracz(IGameModel gra) {
        healthBarGracza = new JProgressBar(0, Postac.getMaxHp());
        healthBarGracza.setBounds(75, 55, 250, 30);
        healthBarGracza.setForeground(new Color(0, 204, 0));
        healthBarGracza.setValue(Postac.getMaxHp());
        healthBarGracza.setBackground(Color.RED);

        zdjecieGracza = new JLabel();
        opisGracza = new JTextArea();

        zdjecieGracza.setIcon(new ImageIcon(gra.getGracz().getImageFilePath()));
        zdjecieGracza.setBounds(50, 100, 300, 300);
        zdjecieGracza.setBackground(null);
        zdjecieGracza.setText(gra.getGracz().getClass().getSimpleName() + ": " + gra.getGracz().getImie());
        opisGracza.setText(gra.getGracz().getStan());
        opisGracza.setEditable(false);
        opisGracza.setBackground(null);
        opisGracza.setBounds(50, 450, 350, 110);
        opisGracza.setFont(new Font("Comic sans", Font.BOLD, 20));
        opisGracza.setForeground(kolorTekstu);

        this.add(healthBarGracza);
        this.add(zdjecieGracza);
        this.add(opisGracza);
        opisGracza.setOpaque(false);
    }

    public void initPrzeciwnik(IGameModel gra) {
        healthBarPrzeciwnika = new JProgressBar(0, Postac.getMaxHp());
        healthBarPrzeciwnika.setBounds(632, 55, 250, 30);
        healthBarPrzeciwnika.setForeground(new Color(0, 204, 0));
        healthBarPrzeciwnika.setValue(Postac.getMaxHp());
        healthBarPrzeciwnika.setBackground(Color.RED);

        opisPrzeciwnika = new JTextArea();
        zdjeciePrzeciwnika = new JLabel();

        zdjeciePrzeciwnika.setIcon(new ImageIcon(gra.getPrzeciwnik().getImageFilePath()));
        zdjeciePrzeciwnika.setBounds(600, 100, 300, 300);
        zdjeciePrzeciwnika.setBackground(null);
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        opisPrzeciwnika.setEditable(false);
        opisPrzeciwnika.setBounds(600, 450, 350, 110);
        opisPrzeciwnika.setFont(new Font("Comic sans", Font.BOLD, 20));
        opisPrzeciwnika.setBackground(null);
        opisPrzeciwnika.setForeground(kolorTekstu);

        this.add(healthBarPrzeciwnika);
        this.add(zdjeciePrzeciwnika);
        this.add(opisPrzeciwnika);
        opisPrzeciwnika.setOpaque(false);
    }

    public void initBronGracza(IGameModel gra) {
        zdjecieBroniGracza = new JLabel();

        zdjecieBroniGracza.setIcon(new ImageIcon(gra.getGracz().getBron().getImageFilePath()));
        zdjecieBroniGracza.setBounds(350, 300, 100, 100);
        zdjecieBroniGracza.setBackground(null);
        this.add(zdjecieBroniGracza);
    }

    public void initBronPrzeciwnika(IGameModel gra) {
        zdjecieBroniPrzeciwnika = new JLabel();

        zdjecieBroniPrzeciwnika.setIcon(new ImageIcon(gra.getPrzeciwnik().getBron().getImageFilePath()));
        zdjecieBroniPrzeciwnika.setBounds(500, 300, 100, 100);
        zdjecieBroniPrzeciwnika.setBackground(null);
        this.add(zdjecieBroniPrzeciwnika);
    }

    public void initDystans(IGameModel gra) {
        dystans = new JTextArea();
        dystans.setText("Dystans: " + gra.getDistance());
        dystans.setEditable(false);
        dystans.setForeground(kolorTekstu);
        dystans.setFont(new Font("Arial", Font.BOLD, 25));
        dystans.setBounds(410, 200, 140, 30);
        dystans.setBackground(null);
        dystans.setOpaque(false);
        this.add(dystans);
    }

    public void initWykonanaAkcja() {
        wykonanaAkcja = new JTextArea();
        wykonanaAkcja.setEditable(false);
        wykonanaAkcja.setForeground(kolorTekstu);
        wykonanaAkcja.setFont(new Font("Arial", Font.BOLD, 25));
        wykonanaAkcja.setBounds(200, 600, 600, 30);
        wykonanaAkcja.setBackground(Color.DARK_GRAY);
        this.add(wykonanaAkcja);
    }

    @Override
    public void update(IGameModel gra) {
        if (gra.getGRACZ_WYGRANA()) pokazKomunikatKoncowy(true);
        else if (gra.getPRZECIWNIK_WYGRANA()) pokazKomunikatKoncowy(false);
        tura.setText("Tura: " + gra.getTurn());
        opisGracza.setText(gra.getGracz().getStan());
        opisPrzeciwnika.setText(gra.getPrzeciwnik().getStan());
        dystans.setText("Dystans: " + gra.getDistance());
        wykonanaAkcja.setText(gra.getAkcja());
        healthBarGracza.setValue(gra.getGracz().getHp());
        healthBarPrzeciwnika.setValue(gra.getPrzeciwnik().getHp());

    }

    public void pokazKomunikatKoncowy(boolean czyGraczWygral) {
        infKoncowa = new JTextPane();
        StyledDocument doc = infKoncowa.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        this.add(infKoncowa);
        infKoncowa.setBounds(350, 20, 255, 55);
        infKoncowa.setFont(new Font("Comic sans", Font.PLAIN, 30));
        infKoncowa.setBackground(Color.DARK_GRAY);
        infKoncowa.setEditable(false);
        infKoncowa.setForeground(kolorTekstu);
        if (czyGraczWygral) {
            infKoncowa.setText("WYGRAŁEŚ!");
            return;
        }
        infKoncowa.setText("PRZEGRAŁEŚ!");
    }

    public JButton getNormalAttackButton() {
        return normalAttackButton;
    }

    public JButton getSpecialAttackButton() {
        return specialAttackButton;
    }

    public JButton getWalkUpButton() {
        return walkUpButton;
    }
}
