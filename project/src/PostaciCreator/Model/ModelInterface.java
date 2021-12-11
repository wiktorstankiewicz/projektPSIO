package PostaciCreator.Model;

import Postacie.Postac;

import java.util.ArrayList;

public interface ModelInterface {
	void nowaPostac(Postac p);
	void aktualizujPostac(Postac p, int i);
	void usunPostac(Postac p);
	ArrayList<Postac> getPostacie();
	void serializuj();
}
