package DocumenteDataBase;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonObjectSchema {
    ArrayList<String> jsonSchema=new ArrayList<>();

    public boolean addSchema(String path,String schemaName) {
        synchronized (this) {
            try {
                File file = new File(path + "/" + schemaName);
                if (!file.exists()) {
                    Files.createDirectory(Paths.get((path + "/" + schemaName)));
                    System.out.println("scheme added successful");
                    return true;
                }
            } catch (IOException e) {
                System.out.println("file is already exist");
            }
            return false;
        }
    }

    public boolean deleteSchema(String path,String schemaName) {
        synchronized (this) {
            try {
                File file = new File(path + "/" + schemaName);
                if (file.exists()) {
                    jsonSchema.remove(schemaName);
                    FileUtils.deleteDirectory(file);
                    return true;
                }

            } catch (IOException e) {
                System.out.println("file is already not exist");
            }
            return false;
        }
    }

    public boolean createJsonSchema(String path,String SchemaName,String jasonschema) {
        synchronized (this) {
            FileWriter writer = null;
            try {
                writer = new FileWriter((path + "/" + SchemaName + "/" + SchemaName + "-schema" + ".json"));
                writer.write("{\n" +
                        "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                        "  \"title\": \"" + SchemaName + "\",\n" +
                        "  \"type\": \"object\",\n" +
                        "  \"properties\": {");
                writer.write(jasonschema + "\n }");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }


}
