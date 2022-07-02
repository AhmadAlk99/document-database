package DocumenteDataBase;

import Indexes.BTree2;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonObject {

    private HashMap<Integer,String> documents=new HashMap<>();

    public boolean  addJsonObject(String path,String SchemaName,String jsonObject) {
        synchronized (this) {
            IDGenerator id = new IDGenerator();
            int _id = id.getID();
            documents.put(_id++, jsonObject);

            try (FileWriter writer = new FileWriter((path + "/" + SchemaName + "/" + SchemaName + "-object" + ".json"), true)) {
                jsonObject = jsonObject.replace('{', ' ');
                writer.write("{" + "\"x\"" + " : " + _id + "," + jsonObject + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public boolean deleteJsonObject(String path,String SchemaName,int id) {
        synchronized (this) {
            String finalPath = path + "/" + SchemaName + "/" + SchemaName + "-object" + ".json";
            File file = new File(finalPath);
            File newFile = new File(finalPath + "Copy.txt");

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 FileWriter fileWriter = new FileWriter(newFile)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].contains(String.valueOf(id))) {
                        System.out.println("Successfully Deleted ");
                    } else {
                        fileWriter.write(line + "\n");
                    }
                }
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            handleCopyFile(newFile, file);
            return true;
        }
    }

    private void handleCopyFile(File newFile,File file) {
        synchronized (this) {
            try {
                Files.delete(file.toPath());
                newFile.renameTo(file);
            } catch (Exception e) {
                System.out.println("not found");
                ;
            }
        }
    }

    public String getDocumentWithId(int _id){
        return documents.get(_id);
    }

    public boolean addIndex(String path,String SchemaName,String index) {
        synchronized (this) {
            BTree2<String, ArrayList<String>> st = new BTree2<>();
            JSONParser parser = new JSONParser();
            JSONObject obj;
            String finalPath = path + "/" + SchemaName + "/" + SchemaName + "-object" + ".json";
            try (BufferedReader reader1 = new BufferedReader(new FileReader(finalPath))) {

                while (reader1.ready()) {
                    String line = reader1.readLine();
                    obj = (JSONObject) parser.parse(line);
                    st.put((String) obj.get("id"), line);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
