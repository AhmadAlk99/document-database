package DocumenteDataBase;

public class IDGenerator {
    private int _id=0;

    public synchronized int getID(){
        return _id++;
    }
}
