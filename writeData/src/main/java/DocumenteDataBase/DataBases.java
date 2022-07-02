package DocumenteDataBase;

import org.apache.commons.io.FileUtils;

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
            boolean deleted=false;
        try {
            File file = new File(path + "/" + databaseName);
            if (file.exists()) {
                FileUtils.deleteDirectory(file);
                return true;
            }
        } catch (IOException e) {
            System.out.println("database is not exist");
            return false;
        }

        return deleted;
        }
    }

    public ArrayList showDataBases(String databaseName) {
        return dataBasesList;
    }

}
