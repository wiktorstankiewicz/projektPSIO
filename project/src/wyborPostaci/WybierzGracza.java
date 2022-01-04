package wyborPostaci;

import gra.model.postacie.Postac;
import kreatorPostaci.model.ICreatorModel;
import wyborPostaci.controller.IControllerWyborPostaci;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WybierzGracza extends JFrame {
    private ICreatorModel model;
    private IControllerWyborPostaci kontroler;
    private JPanel panel;
    private JList listaOpcji;

    private final static int SZEROKOSC = 500;
    private final static int WYSOKOSC = 400;

    public WybierzGracza(ICreatorModel model, IControllerWyborPostaci kontroler) {
        this.model = model;
        this.kontroler = kontroler;
        init();
    }

    public void init() {
        this.setTitle("Wybierz postać");
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel etykieta = new JLabel("Wybierz postać:", SwingConstants.CENTER);
        etykieta.setFont(new Font("Sans Serif", Font.BOLD, 20));

        listaOpcji = new JList(model.getPostacie().toArray());
        listaOpcji.setFont(new Font("Sans Serif", Font.BOLD, 17));
        listaOpcji.setBorder(new LineBorder(Color.BLACK));
        panel.add(listaOpcji);

        JButton guzik = new JButton("Kontynuuj");
        guzik.setFont(new Font("Sans Serif", Font.BOLD, 17));
        guzik.addActionListener(e -> {
            if (listaOpcji.getSelectedIndex() != -1) {
                Postac gracz = (Postac) listaOpcji.getSelectedValue();
                kontroler.usunPostacZListy(gracz);
                kontroler.wyswietlWyborPrzeciwnika(gracz);
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
