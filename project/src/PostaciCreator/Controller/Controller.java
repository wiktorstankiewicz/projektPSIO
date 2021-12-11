package PostaciCreator.Controller;

import PostaciCreator.Model.ModelInterface;
import PostaciCreator.View.View;
import Postacie.Postac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ControllerInterface{
	ModelInterface model;
	View view;

	public Controller(ModelInterface model){
		this.model = model;
		view = new View(model, this);

		view.showGui();
	}

	public void nowaPostac(Postac p) {
		model.nowaPostac(p);
	}

	public void aktualizujPostac(Postac p, int i) {
		model.aktualizujPostac(p, i);
	}

	public void usunPostac(Postac p) {
		model.usunPostac(p);
	}

	public ArrayList<Postac> getPostacie() {
		return model.getPostacie();
	}

	public static class ZapiszZmianyListener implements ActionListener{

		private ModelInterface model;

		public ZapiszZmianyListener(ModelInterface model){
			this.model = model;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			model.serializuj();
		}
	}

}
