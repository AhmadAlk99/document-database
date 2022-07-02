package Dao;

import java.io.PrintWriter;

public interface ReadDao {

    public void readDocument(String [] path, PrintWriter out);

    public void readIndexedDocument(String [] path, PrintWriter out);
}
