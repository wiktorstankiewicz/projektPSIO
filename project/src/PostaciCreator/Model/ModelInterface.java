package PostaciCreator.Model;

import Gra.Model.Postacie.Postac;

import java.io.File;
import java.util.ArrayList;

public interface ModelInterface {
	void nowaPostac(Postac p);
	void aktualizujPostac(Postac p, int i);
	void usunPostac(Postac p);
	ArrayList<Postac> getPostacie();
	void serializuj();
	void wczytajNadpisz(File f);
	void wczytajDopisz(File f);
}
