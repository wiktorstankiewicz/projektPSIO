package wyborPostaci;

import gra.model.postacie.Postac;
import kreatorPostaci.model.ICreatorModel;
import wyborPostaci.controller.IControllerWyborPostaci;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class WybierzPrzeciwnika extends JFrame {
    private ICreatorModel model;
    private IControllerWyborPostaci kontroler;
    private Postac gracz;
    private JPanel panel;
    private JList listaOpcji;

    private final static int SZEROKOSC = 500;
    private final static int WYSOKOSC = 400;

    public WybierzPrzeciwnika(ICreatorModel model, IControllerWyborPostaci kontroler, Postac gracz) {
        this.model = model;
        this.kontroler = kontroler;
        this.gracz = gracz;
        init();
    }

    public void init() {
        this.setTitle("Wybierz przeciwnika");
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel etykieta = new JLabel("Wybierz przeciwnika:", SwingConstants.CENTER);
        etykieta.setFont(new Font("Sans Serif", Font.BOLD, 20));

        ArrayList<Object> lista = new ArrayList<>();
        lista.add("Generuj nowego przeciwnika");
        lista.addAll(model.getPostacie());

        listaOpcji = new JList(lista.toArray());
        listaOpcji.setFont(new Font("Sans Serif", Font.BOLD, 17));
        listaOpcji.setBorder(new LineBorder(Color.BLACK));
        panel.add(listaOpcji);

        JButton guzik = new JButton("Kontynuuj");
        guzik.setFont(new Font("Sans Serif", Font.BOLD, 17));
        guzik.addActionListener(e -> {
            if (listaOpcji.getSelectedIndex() != -1) {
                Postac przeciwnik = kontroler.stworzPrzeciwnika(listaOpcji, listaOpcji.getSelectedIndex());
                kontroler.dodajPostacDoListy(gracz);
                kontroler.rozpocznijGre(gracz, przeciwnik);
            }
        });

        this.getContentPane().add(etykieta, BorderLayout.NORTH);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(guzik, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
