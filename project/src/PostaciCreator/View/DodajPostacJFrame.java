package PostaciCreator.View;

import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.BronWoja;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import GraPackage.WyborKlasy;
import PostaciCreator.Controller.ControllerInterface;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DodajPostacJFrame extends JFrame {
	private final DefaultComboBoxModel<String> modelWoj = new DefaultComboBoxModel<>( WyborKlasy.listaBroniWojownika );
	private final DefaultComboBoxModel<String> modelZab = new DefaultComboBoxModel<>( WyborKlasy.listaBroniZabojcy );
	private final DefaultComboBoxModel<String> modelLow = new DefaultComboBoxModel<>( WyborKlasy.listaBroniLowcy );
	private final DefaultComboBoxModel<String> modelMag = new DefaultComboBoxModel<>( WyborKlasy.listaBroniMaga );

	private final int H_GAP = 5;
	private final int V_GAP = 10;

	private ControllerInterface controller;

	private JPanel panel;
	private JTextField imieField;
	private JComboBox<String> klasaCB;
	private JComboBox<String> bronCB;
	private JButton zatwierdzButton;

	private boolean editting;
	private int index;

	public DodajPostacJFrame(ControllerInterface controller){
		this.controller = controller;

		panel = new JPanel();
		this.getContentPane().add(panel);
		this.setSize(new Dimension(200, 175));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				hideFrame();
			}
		});

		imieField = new JTextField("Imie");

		bronCB = new JComboBox<>(WyborKlasy.listaBroniWojownika);
		bronCB.setSelectedIndex(0);

		klasaCB = new JComboBox<>(WyborKlasy.listaKlas);
		klasaCB.addActionListener(e -> {
			switch (klasaCB.getSelectedIndex()){
				case 0 -> bronCB.setModel(modelWoj);
				case 1 -> bronCB.setModel(modelZab);
				case 2 -> bronCB.setModel(modelLow);
				case 3 -> bronCB.setModel(modelMag);
			}
		});
		klasaCB.setSelectedIndex(0);


		zatwierdzButton = new JButton("OK");
		zatwierdzButton.addActionListener(e -> {
			if (editting) controller.aktualizujPostac(stworzPostac(), index);
			else controller.nowaPostac(stworzPostac());

			this.setVisible(false);
		});

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(imieField);
		panel.add(Box.createRigidArea(new Dimension(H_GAP, V_GAP)));
		panel.add(klasaCB);
		panel.add(Box.createRigidArea(new Dimension(H_GAP, V_GAP)));
		panel.add(bronCB);
		panel.add(zatwierdzButton);
		this.setVisible(true);
	}

	public DodajPostacJFrame(int index, Postac p, ControllerInterface controller){
		this(controller);
		this.index = index;
		editting = true;
		imieField.setText(p.getImie());

		int klasaIndex = 0;
		switch (p.getClass().getSimpleName()){
			case "Wojownik" -> klasaIndex = 0;
			case "Zabojca" -> klasaIndex = 1;
			case "Lowca" -> klasaIndex = 2;
			case "Mag" -> klasaIndex = 3;
		}
		klasaCB.setSelectedIndex(klasaIndex);

		int bronIndex = 0;
		if (klasaIndex == 0 && p.getBron().getClass().getSimpleName().equals("Mlot")){
			bronIndex = 1;
		}
		bronCB.setSelectedIndex(bronIndex);
	}

	private Postac stworzPostac(){
		Postac p = null;
		String imie = imieField.getText();

		int index = (int)(Math.random() * WyborKlasy.listaImionBota.length);
		if (imie.equals("")) imie += WyborKlasy.listaImionBota[index];

		switch (klasaCB.getSelectedIndex()) {
			case 0 -> {
				BronWoja bronW;
				if (bronCB.getSelectedIndex() == 0)
					bronW = new Miecz();
				else bronW = new Mlot();
				p = new Wojownik(imie, bronW);
			}
			case 1 -> p = new Zabojca(imie, new Sztylet());
			case 2 -> p = new Lowca(imie, new Luk());
			case 3 -> p = new Mag(imie, new Rozdzka());
		}
		return p;
	}

	private void hideFrame(){
		this.setVisible(false);
	}

}

