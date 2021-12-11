package PostaciCreator.Controller;

import Postacie.Postac;

import java.util.ArrayList;

public interface ControllerInterface {
	void nowaPostac(Postac p);
	void aktualizujPostac(Postac p, int i);
	void usunPostac(Postac p);
	ArrayList<Postac> getPostacie();

}
