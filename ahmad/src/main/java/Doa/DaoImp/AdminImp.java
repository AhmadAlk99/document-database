package Doa.DaoImp;

import Doa.AdminDao;
import DocumenteDataBase.*;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;

public class AdminImp implements AdminDao {

    DataBases dataBase=new DataBases();
    JsonObjectSchema schema = new JsonObjectSchema();
    JsonObject jsonObject=new JsonObject();
    final static String path = "src/main/resources/DataBases";

    HashMap<String,String> adminMap=new HashMap<>();

    String adminPath;
    private String AdminName;

    public AdminImp(String adminName) {
        this.AdminName = adminName;
        this.adminPath = path+"/"+AdminName+"-DataBase";
    }

    @Override
    public boolean addUser(String name, String password) {
        String toString=name+","+password+","+"USER";
        adminMap.put(name,AdminName);
        try(FileWriter fileWriter= new FileWriter("src/main/resources/users", true)) {

            fileWriter.write(toString);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeUser(String name) {
        adminMap.remove(name);
        String userPath="src/main/resources/users";
        deleteUser(userPath,name);
        return true;
    }

    private void deleteUser(String path , String name){
        File file = new File(path);
        File newFile = new File(path + "Copy.txt");

        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
             FileWriter fileWriter=new FileWriter(newFile) ){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (name.equals(data[0])) {
                    System.out.println("Successfully Deleted ");
                } else {
                    fileWriter.write(line + "\n");
                }
            }
            fileWriter.flush();
        }
        catch (IOException e) {e.printStackTrace();}
        handleCopyFile(newFile,file);
    }

    private void handleCopyFile(File newFile,File file)  {
        try {
            Files.delete(file.toPath());
            newFile.renameTo(file);
        } catch (Exception e){
            System.out.println("not found");;
        }
    }

    @Override
    public boolean addDataBase(String dataBaseName) {

        boolean isCreated = dataBase.createDatabase(adminPath,dataBaseName);
        return isCreated;
    }

    @Override
    public boolean deleteDataBase(String dataBaseName) {
        boolean isDeleted = dataBase.deleteDatabase(adminPath,dataBaseName);
        return false;
    }

    @Override
    public boolean addSchema(String dataBaseName , String schemaName) {
        String databasePath = adminPath+"/"+dataBaseName;
        boolean created=schema.addSchema(databasePath,schemaName);
        return created;
    }

    @Override
    public boolean deleteSchema(String dataBaseName , String schemaName) {
        String databasePath = adminPath+"/"+dataBaseName;
        boolean deleted=schema.deleteSchema(databasePath,schemaName);
        return deleted;
    }

    @Override
    public boolean addSchemaJson(String dataBaseName, String schemaName,String schemaJson) {
        String databasePath = adminPath+"/"+dataBaseName;
        boolean created=schema.createJsonSchema(databasePath,schemaName,schemaJson);
        return created;
    }

    @Override
    public boolean addDocument(String dataBaseName, String schemaName,String jsonObj) {
        String databasePath = adminPath+"/"+dataBaseName;
        boolean objAdded=jsonObject.addJsonObject(databasePath,schemaName,jsonObj);

        return objAdded;
    }

    @Override
    public boolean deleteDocument(String dataBaseName,String schemaName,int id) {
        String databasePath = adminPath+"/"+dataBaseName;
        boolean isDeleted = jsonObject.deleteJsonObject(databasePath,schemaName,id);
        return isDeleted;
    }
    @Override
    public boolean  addIndex(String dataBaseName,String SchemaName,String index){
        String databasePath = adminPath+"/"+dataBaseName;
        boolean added=jsonObject.addIndex(path,SchemaName,index);
        return added;
    }

}
