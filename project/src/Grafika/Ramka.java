package Grafika;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Ramka extends JFrame {
    public Ramka(){
        this.add(new Panel());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

}
