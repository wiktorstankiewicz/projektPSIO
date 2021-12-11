package PostaciCreator.View;

import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.BronWoja;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import GraPackage.WyborKlasy;
import PostaciCreator.Controller.Controller;
import PostaciCreator.Controller.ControllerInterface;
import PostaciCreator.Model.ModelInterface;
import PostaciCreator.Model.Observers.ModelObservable;
import PostaciCreator.Model.Observers.ModelObserver;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;

public class PostaciCreatorJPanel extends JPanel implements ModelObserver {
	//Constants
	private final int BUTTON_HEIGHT = 100;
	private final int BUTTONS_GAP = 20;
	private final int RECORDS_GAP = 20;

	private ModelInterface model;
	private ControllerInterface controller;
	private JFrame parent;

	public PostaciCreatorJPanel(ModelInterface model, ControllerInterface controller, JFrame frame){
		ModelObservable modelObservable = (ModelObservable) model;
		modelObservable.registerObserver(this);

		this.model = model;
		this.controller = controller;
		this.parent = frame;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.add(Box.createRigidArea(new Dimension(1, RECORDS_GAP/2)));
		makeRecords();
		this.add(Box.createRigidArea(new Dimension(1, RECORDS_GAP/2)));
		makeButtons();
		this.add(Box.createRigidArea(new Dimension(1, RECORDS_GAP/2)));
	}

	private void makeRecords(){
		this.removeAll();
		ArrayList<Postac> postacie = model.getPostacie();

		for (int i=0; i<postacie.size(); i++) {
			this.add(new PostacRecordJPanel(postacie.get(i), i));
			this.add(Box.createRigidArea(new Dimension(1, RECORDS_GAP)));
		}

	}

	private void makeButtons(){
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.setMaximumSize(new Dimension(Short.MAX_VALUE, BUTTON_HEIGHT));

		JButton dodajButton = new JButton("Dodaj");
		JButton zapiszButton = new JButton("Zapisz");
		JButton wyjdzButton = new JButton("Wyjdz");

		dodajButton.addActionListener(e -> new DodajPostacJFrame());
		zapiszButton.addActionListener(new Controller.ZapiszZmianyListener(model));
		wyjdzButton.addActionListener(e -> parent.setVisible(false));

		buttons.add(Box.createHorizontalGlue());
		buttons.add(dodajButton);
		buttons.add(Box.createRigidArea(new Dimension(BUTTONS_GAP, 1)));
		buttons.add(zapiszButton);
		buttons.add(Box.createRigidArea(new Dimension(BUTTONS_GAP, 1)));
		buttons.add(wyjdzButton);
		buttons.add(Box.createHorizontalGlue());

		this.add(buttons);
	}

	@Override
	public void update() {
		makeRecords();
		makeButtons();

		revalidate();
		repaint();
	}

	private class PostacRecordJPanel extends JPanel {
		private final int H_GAP = 10;
		private final int MAX_HEIGHT = 50;
		private Postac postac;
		private String klasa;
		private String imie;
		private String bron;
		private int hp;
		private int index;

		public PostacRecordJPanel(Postac p, int index){
			this.postac = p;
			this.index = index;
			imie = p.getImie();
			klasa = p.getClass().getSimpleName();
			hp = p.getHp();
			bron = p.getBron().getClass().getSimpleName();

			this.setLayout(new GridLayout(1, 5, H_GAP, 1));
			this.setMaximumSize(new Dimension(Short.MAX_VALUE, MAX_HEIGHT));

			JTextField klasaField = new JTextField(klasa);
			JTextField imieField = new JTextField(imie);
			JTextField bronField = new JTextField(bron);
			JTextField hpField = new JTextField(Integer.toString(hp));

			setupJTextComponentForView(klasaField);
			setupJTextComponentForView(imieField);
			setupJTextComponentForView(bronField);
			setupJTextComponentForView(hpField);

			this.add(klasaField);
			this.add(imieField);
			this.add(bronField);
			this.add(hpField);
			makeEditButtons();
		}

		private void makeEditButtons(){
			JPanel editButtons = new JPanel();
			editButtons.setLayout(new BoxLayout(editButtons, BoxLayout.X_AXIS));

			JButton editButton = new JButton("\\\\\\");
			JButton deleteButton = new JButton("///");

			editButton.addActionListener(e -> new DodajPostacJFrame(index, postac));
			deleteButton.addActionListener(e -> controller.usunPostac(postac));

			editButtons.add(editButton);
			editButtons.add(deleteButton);

			this.add(editButtons);
		}
	}

	private class DodajPostacJFrame extends JFrame {
		private final DefaultComboBoxModel<String> modelWoj = new DefaultComboBoxModel<>( WyborKlasy.listaBroniWojownika );
		private final DefaultComboBoxModel<String> modelZab = new DefaultComboBoxModel<>( WyborKlasy.listaBroniZabojcy );
		private final DefaultComboBoxModel<String> modelLow = new DefaultComboBoxModel<>( WyborKlasy.listaBroniLowcy );
		private final DefaultComboBoxModel<String> modelMag = new DefaultComboBoxModel<>( WyborKlasy.listaBroniMaga );

		private final int H_GAP = 5;
		private final int V_GAP = 10;

		private JPanel panel;
		private JTextField imieField;
		private JComboBox<String> klasaCB;
		private JComboBox<String> bronCB;
		private JButton zatwierdzButton;

		private boolean editting;
		private int index;

		public DodajPostacJFrame(){
			panel = new JPanel();
			this.getContentPane().add(panel);
			this.setSize(new Dimension(200, 200));
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

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

		public DodajPostacJFrame(int index, Postac p){
			this();
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

	}

	private void setupJTextComponentForView(JTextComponent comp){
		comp.setEditable(false);
		comp.setBorder(BorderFactory.createEmptyBorder());
		comp.setOpaque(false);
		if (comp instanceof JTextField){
			((JTextField) comp).setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
