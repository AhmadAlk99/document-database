package replicaObserver;

public interface Subject {

        public void addObserver(Observer observer);

        public void removeObserver(Observer observer);

        public void notifyAllObservers(String tweet);

    }

