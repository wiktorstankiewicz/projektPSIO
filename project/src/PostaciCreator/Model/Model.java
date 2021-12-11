package PostaciCreator.Model;

import PostaciCreator.Model.Observers.ModelObservable;
import PostaciCreator.Model.Observers.ModelObserver;

import java.util.ArrayList;

public class Model implements ModelInterface, ModelObservable {
	private ArrayList<ModelObserver> observers;

	public Model(){
		observers = new ArrayList<>();
	}



	//Observable methods
	@Override
	public void registerObserver(ModelObserver o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(ModelObserver o) {
		if (observers.contains(o)){
			observers.remove(o);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}
}
