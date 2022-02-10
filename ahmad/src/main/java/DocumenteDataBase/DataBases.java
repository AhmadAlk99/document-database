package DocumenteDataBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class DataBases {

    private ArrayList<String> dataBasesList = new ArrayList<>();

    public boolean createDatabase(String path, String databaseName) {
        synchronized (this){
        if (dataBasesList.contains(databaseName)) {
            System.out.println("database already exist");
            return false;
        }
        else {
            new File(path+"/" + databaseName).mkdirs();
            dataBasesList.add(databaseName);
            // Files.createDirectory(Paths.get(("DataBases/" + databaseName)));
            return true;
        }

        }
    }

    public boolean deleteDatabase(String path, String databaseName) {
        synchronized (this){
        try {
            Files.deleteIfExists(Paths.get(databaseName));
            if (dataBasesList.contains(databaseName)) {
                dataBasesList.remove(databaseName);
                System.out.println("database is deleted");
                return true;
            }
        } catch (IOException e) {
            System.out.println("database is not exist");
            return false;
        }

        return false;
        }
    }

    public ArrayList showDataBases(String databaseName) {
        return dataBasesList;
    }

}
