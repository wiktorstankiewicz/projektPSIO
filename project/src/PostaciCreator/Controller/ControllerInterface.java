package PostaciCreator.Controller;

import Postacie.Postac;

import java.io.File;
import java.util.ArrayList;

public interface ControllerInterface {
	int OVERWRITE = 0;
	int APPEND = 1;
	void nowaPostac(Postac p);
	void aktualizujPostac(Postac p, int i);
	void usunPostac(Postac p);
	ArrayList<Postac> getPostacie();

	void wczytajPostacie(File f, int o);
}
