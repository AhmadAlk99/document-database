package replicaObserver;
import java.util.ArrayList;
import java.util.List;

public class Master implements Subject {

    private List<Observer> readers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        readers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        readers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String tweet) {
        for (Observer observer : readers) {
            observer.update();
        }
    }

}
