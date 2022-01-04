package kreatorPostaci.model;

import kreatorPostaci.model.observers.ModelObservable;
import kreatorPostaci.model.observers.ModelObserver;
import gra.model.postacie.Postac;
import utilities.Utils;

import java.io.*;
import java.util.ArrayList;

public class CreatorModel implements ICreatorModel, ModelObservable {
	private ArrayList<ModelObserver> observers;
	private ArrayList<Postac> postacie;


	public CreatorModel(){
		observers = new ArrayList<>();
		postacie = new ArrayList<>();
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("postacie.ser"))){
			Object out = is.readObject();
			if (out instanceof ArrayList)
				postacie = (ArrayList<Postac>) out;
		} catch (IOException | ClassNotFoundException ignored) {
		}
	}

 	//Interface methods
	public void nowaPostac(Postac p) {
		postacie.add(p);
		notifyObservers();
	}

	public void aktualizujPostac(Postac p, int index) {
		postacie.set(index, p);
		notifyObservers();
	}

	public void usunPostac(Postac p) {
		postacie.remove(p);
		notifyObservers();
	}

	public ArrayList<Postac> getPostacie() {
		return postacie;
	}

	public void serializuj(){
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("postacie.ser"))){
			os.writeObject(postacie);
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("Nie udalo sie zapisac postaci");
		}
	}

	public void wczytajNadpisz(File f) {
		postacie = new ArrayList<>();

		postacie = Utils.readArrayListFromTXTFile(f);
		notifyObservers();
	}

	public void wczytajDopisz(File f) {
		ArrayList<Postac> arr = Utils.readArrayListFromTXTFile(f);
		if (arr.size() <= 0 || arr.get(0) == null) return;

		postacie.addAll(arr);
		notifyObservers();
	}

	//Gettery


	//Observable methods

	@Override
	public void registerObserver(ModelObserver o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(ModelObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}
}
