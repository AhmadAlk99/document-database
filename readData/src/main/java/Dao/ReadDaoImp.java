package Dao;

import Cashe.LRUCache;
import ReadData.ReadFromDataBase;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ReadDaoImp implements ReadDao{
    ReadFromDataBase reader = new ReadFromDataBase();
    LRUCache<String,ArrayList<String>>cache=new LRUCache<>(50);
    @Override
    public void readDocument(String[] path, PrintWriter out) {
        ArrayList<String> data;
        if(cache.get(path[0] + " " + path[1]) == null) {
            data = reader.readAllData(path[0], path[1]);
            cache.put(path[0]+" "+path[1],data);
        }
        else{
            data=cache.get(path[0]+" "+path[1]);
        }
        if (data.size()>0){
            out.println(String.valueOf(data.size()));
            for (String document : data) {
                out.println(document);
            }
        }
        else{
            out.println("1");
            out.println("> not valid input");
        }
    }

    @Override
    public void readIndexedDocument(String[] path, PrintWriter out) {
        ArrayList<String> data;
        if(cache.get(path[0] + " " + path[1]) == null) {
            data = reader.readIndexedData(path[0],path[1],path[2]);
            cache.put(path[0]+" "+path[1]+""+path[2],data);
        }
        else{
            data=cache.get(path[0]+" "+path[1]+""+path[2]);
        }
        if (data.size()>0){
            out.println(String.valueOf(data.size()));
            for (String document : data) {
                out.println(document);
            }
        }
        else{
            out.println("1");
            out.println("> not valid input");
        }
    }
}
