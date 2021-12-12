import PostaciCreator.Controller.Controller;
import PostaciCreator.Controller.ControllerInterface;
import PostaciCreator.Model.Model;
import PostaciCreator.Model.ModelInterface;

import javax.swing.*;
import java.awt.*;

public class Launcher {
	private final int H_GAP = 20;

	private JFrame launcherFrame;
	private JPanel launcherPanel;

	public static void main(String[] args){
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
		ModelInterface model = new Model();
		ControllerInterface controller = new Controller(model);
	}

	private void launchGra(){

	}
}
