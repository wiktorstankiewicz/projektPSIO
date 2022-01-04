

import kreatorPostaci.controller.CreatorController;
import kreatorPostaci.controller.ICreatorController;
import kreatorPostaci.model.CreatorModel;
import kreatorPostaci.model.ICreatorModel;
import gra.model.Gra;

import javax.swing.*;
import java.awt.*;

public class Launcher {
	private final int H_GAP = 20;

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
		launcherFrame = new JFrame("Launcher");
		launcherPanel = new JPanel();

		launcherFrame.getContentPane().add(launcherPanel);
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

		launcherFrame.setVisible(true);
	}

	private void launchPostaciCreator(){
		ICreatorModel model = new CreatorModel();
		ICreatorController controller = new CreatorController(model);
	}

	private void launchGra(){
		launcherFrame.setVisible(false);
		(new Thread(new Gra())).start();
	}
}
