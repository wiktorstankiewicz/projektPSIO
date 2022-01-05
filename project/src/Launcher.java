import kreatorPostaci.controller.CreatorController;
import kreatorPostaci.controller.ICreatorController;
import kreatorPostaci.model.CreatorModel;
import kreatorPostaci.model.ICreatorModel;
import gra.model.Gra;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Launcher {
	private final int H_GAP = 20;

	private ICreatorModel model;

	private JLabel komunikat;
	private JFrame launcherFrame;
	private JPanel launcherPanel;

	public static void main(String[] args) {
		Launcher app = new Launcher();
		app.go();

	}

	private void go (){
		makeGui();
	}

	private void makeGui(){
		model = new CreatorModel();

		launcherFrame = new JFrame("Launcher");
		launcherPanel = new JPanel();

		launcherFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		launcherFrame.setSize(new Dimension(600, 150));
		launcherPanel.setLayout(new BoxLayout(launcherPanel, BoxLayout.X_AXIS));

		JButton postaciCreatorButton = new JButton("Kreator Postaci");
		JButton graButton = new JButton("Rozpocznij Gre");
		JButton wyjdzButton = new JButton("Wyjdz");

		postaciCreatorButton.addActionListener(e -> launchPostaciCreator());
		graButton.addActionListener(e -> launchGra());
		wyjdzButton.addActionListener(e -> System.exit(0));

		launcherPanel.add(Box.createHorizontalGlue());
		launcherPanel.add(postaciCreatorButton);
		launcherPanel.add(Box.createRigidArea(new Dimension(H_GAP, 1)));
		launcherPanel.add(graButton);
		launcherPanel.add(Box.createRigidArea(new Dimension(H_GAP, 1)));
		launcherPanel.add(wyjdzButton);
		launcherPanel.add(Box.createHorizontalGlue());

		komunikat = new JLabel("Probny rozmiar", SwingConstants.CENTER);
		komunikat.setFont(new Font("Sans serif", Font.BOLD, 15));
		komunikat.setForeground(Color.RED);
		Dimension preferredSize = komunikat.getPreferredSize();
		komunikat.setText("");

		JPanel panelKomunikatu = new JPanel();
		panelKomunikatu.setPreferredSize(preferredSize);
		panelKomunikatu.add(komunikat);

		JPanel pionowyPanel = new JPanel();
		pionowyPanel.setLayout(new BoxLayout(pionowyPanel, BoxLayout.Y_AXIS));
		pionowyPanel.add(Box.createVerticalGlue());
		pionowyPanel.add(launcherPanel);
		pionowyPanel.add(Box.createVerticalGlue());
		pionowyPanel.add(panelKomunikatu);
		pionowyPanel.add(Box.createVerticalGlue());
		launcherFrame.getContentPane().add(pionowyPanel);

		launcherFrame.setVisible(true);
	}

	private void launchPostaciCreator(){
		new CreatorController(model);
	}

	private void launchGra(){
		if (model.getPostacie().size() > 1) {
			launcherFrame.setVisible(false);
			new wyborPostaci.controller.ControllerWyborPostaci(model);
		} else {
			komunikat.setText("Zanim rozpoczniesz, stwórz przynajmniej dwie postacie");
			komunikat.setBorder(new LineBorder(Color.RED));
		}
	}
}
