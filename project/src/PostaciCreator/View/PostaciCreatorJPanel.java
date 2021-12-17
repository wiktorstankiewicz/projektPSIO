package PostaciCreator.View;

import PostaciCreator.Controller.Controller;
import PostaciCreator.Controller.ControllerInterface;
import PostaciCreator.Model.ModelInterface;
import PostaciCreator.Model.Observers.ModelObservable;
import PostaciCreator.Model.Observers.ModelObserver;
import Gra.Model.Postacie.Postac;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PostaciCreatorJPanel extends JPanel implements ModelObserver {
	//Constants
	private final int BUTTON_HEIGHT = 100;
	private final int BUTTONS_GAP = 20;
	private final int RECORDS_GAP = 5;
	private final String DELETE = "deleteButton.png";
	private final String EDIT = "editButton.png";
	private final Font FONT = new Font("Arial", Font.BOLD, 15);

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

		dodajButton.addActionListener(e -> new DodajPostacJFrame(controller));
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
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

			File file = new File(EDIT);
			if (file.canRead()) {
				editButton.setIcon(new ImageIcon(EDIT));
				editButton.setText("");
			}

			file = new File(DELETE);
			if (file.canRead()) {
				deleteButton.setIcon(new ImageIcon(DELETE));
				deleteButton.setText("");
			}

			editButton.addActionListener(e -> new DodajPostacJFrame(index, postac, controller));
			deleteButton.addActionListener(e -> controller.usunPostac(postac));

			editButtons.add(editButton);
			editButtons.add(Box.createRigidArea(new Dimension(H_GAP, 1)));
			editButtons.add(deleteButton);

			this.add(editButtons);
		}
	}

	private void setupJTextComponentForView(JTextComponent comp){
		comp.setEditable(false);
		comp.setBorder(BorderFactory.createEmptyBorder());
		comp.setOpaque(false);
		comp.setFont(FONT);
		if (comp instanceof JTextField){
			((JTextField) comp).setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
