package kreatorPostaci.model.observers;

public interface ModelObservable {
	void registerObserver(ModelObserver o);
	void removeObserver(ModelObserver o);
	void notifyObservers();
}
