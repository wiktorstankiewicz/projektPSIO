package PostaciCreator.View;

import PostaciCreator.Model.ModelInterface;

import javax.swing.*;

public class View {

	private JFrame mainFrame;
	private JPanel mainPanel;

	private JMenuBar mainMenuBar;
	private JMenu menuFile;
	private JMenuItem menuNowaPostac;
	private JMenuItem menuWyjscie;

	public View(ModelInterface model){

	}

	public void setupGui(){
		mainFrame = new JFrame();
		mainPanel = new JPanel();

		mainMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(mainMenuBar);

		menuFile = new JMenu("File");
		menuNowaPostac = new JMenuItem("Nowa postac");
		menuWyjscie = new JMenuItem("Wyjdz");
	}

	public void showGui(){

	}

}
