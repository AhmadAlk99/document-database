package ReadData;

import Indexes.BTree2;

import java.io.*;
import java.util.ArrayList;


public class ReadFromDataBase {
    private final static String PATH = "src/main/resources/ahmad-DataBase/";

    public ArrayList readAllData(String dataBase, String schemaName) {

        ArrayList<String>data=new ArrayList<>();
        File file = new File(PATH + dataBase + "/" + schemaName);
        if (file.isFile()){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                        data.add(line);
                }
            } catch (IOException e) {
                System.out.println("not exist");
            }
        }
        else{
            System.out.println("file not exist");
        }
        return data;
    }

    public ArrayList readIndexedData(String dataBase,String schemaName,String index) {
        ArrayList<String>indexedData = new ArrayList<>();
        BTree2<String,Integer> map = new BTree2<>();
        return indexedData;
    }
}
