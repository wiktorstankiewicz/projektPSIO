package PostaciCreator.Model.Observers;

public interface ModelObservable {
	void registerObserver(ModelObserver o);
	void removeObserver(ModelObserver o);
	void notifyObservers();
}
