package kreatorPostaci.view;

import kreatorPostaci.controller.ICreatorController;
import kreatorPostaci.model.ICreatorModel;
import kreatorPostaci.view.scrollPane.MyCustomScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class View {
	//Constants
	private final int SIZE_X = 750;
	private final int SIZE_Y = 600;

	private ICreatorController controller;

	private JFrame mainFrame;
	private JPanel mainPanel;

	private JMenuBar mainMenuBar;
	private JMenu menuFile;
	private JMenuItem menuNowaPostac;
	private JMenu menuWczytaj;
	private JMenuItem wczytajNadpisz;
	private JMenuItem wczytajDopisz;
	private JMenuItem menuWyjscie;

	public View(ICreatorModel model, ICreatorController controller){
		this.controller = controller;

		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				mainFrame.setVisible(false);
			}
		});

		mainFrame.setSize(new Dimension(SIZE_X, SIZE_Y));
		mainFrame.setResizable(false);
		mainPanel = new PostaciCreatorJPanel(model, controller, mainFrame);
		mainFrame.getContentPane().add(new MyCustomScrollPane(mainPanel));
		mainMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(mainMenuBar);

		menuFile = new JMenu("File");
		menuNowaPostac = new JMenuItem("Nowa postac");

		menuWczytaj = new JMenu("Wczytaj z pliku .txt");
		wczytajDopisz = new JMenuItem("Dopisz");
		wczytajNadpisz = new JMenuItem("Nadpisz");

		menuWyjscie = new JMenuItem("Wyjdz");

		menuNowaPostac.addActionListener(e -> new DodajPostacJFrame(controller));
		wczytajDopisz.addActionListener(e -> wczytajDopisz());
		wczytajNadpisz.addActionListener(e -> wczytajNadpisz());

		mainMenuBar.add(menuFile);
		menuFile.add(menuNowaPostac);
		menuFile.add(menuWczytaj);
		menuFile.add(menuWyjscie);
		menuWczytaj.add(wczytajDopisz);
		menuWczytaj.add(wczytajNadpisz);
	}

	private void wczytajDopisz() {
		controller.wczytajPostacie(getFile(), ICreatorController.APPEND);
	}

	private void wczytajNadpisz() {
		controller.wczytajPostacie(getFile(), ICreatorController.OVERWRITE);
	}

	private File getFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		fileChooser.setFileFilter(new TextFilter());
		fileChooser.showOpenDialog(mainFrame);
		return fileChooser.getSelectedFile();
	}

	public void showGui(){
		mainFrame.setVisible(true);
	}

	public void hideGui(){
		mainFrame.setVisible(false);
	}

}
