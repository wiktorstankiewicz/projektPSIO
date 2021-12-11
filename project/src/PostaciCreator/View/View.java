package PostaciCreator.View;

import PostaciCreator.Controller.ControllerInterface;
import PostaciCreator.Model.ModelInterface;
import PostaciCreator.View.ScrollPane.MyCustomScrollPane;

import javax.swing.*;
import java.awt.*;

public class View {
	//Constants
	private final int SIZE_X = 600;
	private final int SIZE_Y = 600;

	private ControllerInterface controller;

	private JFrame mainFrame;
	private JPanel mainPanel;

	private JMenuBar mainMenuBar;
	private JMenu menuFile;
	private JMenuItem menuNowaPostac;
	private JMenuItem menuWyjscie;

	public View(ModelInterface model, ControllerInterface controller){
		this.controller = controller;

		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(new Dimension(SIZE_X, SIZE_Y));
		mainPanel = new PostaciCreatorJPanel(model, controller, mainFrame);
		mainFrame.getContentPane().add(new MyCustomScrollPane(mainPanel));
		mainMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(mainMenuBar);

		menuFile = new JMenu("File");
		menuNowaPostac = new JMenuItem("Nowa postac");
		menuWyjscie = new JMenuItem("Wyjdz");
	}

	public void showGui(){
		mainFrame.setVisible(true);
	}

	public void hideGui(){
		mainFrame.setVisible(false);
	}

}
