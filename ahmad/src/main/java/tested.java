import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;

public class tested {
    public static void main(String[] args) {
        /*JSONObject jsonSchema = new JSONObject(
                new JSONTokener("/jsonschema.json"));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener("/test.json"));


        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
        System.out.println(schema.getId());*/

        JSONParser parser = new JSONParser();
        JSONObject obj;
int x=0;
        try {
            FileWriter writer=new FileWriter(new File("src/main/java/test"),true);
            String json="{\"id\": 19, \"name\": \"Ahmad\", \"price\": 1000000}";
            writer.write("\n");
            json=json.replace('{',' ');
            BufferedReader reader1=new BufferedReader(new FileReader("src/main/java/test"));
            writer.write("{"+"\"x\""+" : "+x+","+json);
            while(reader1.ready()){

            obj = (JSONObject)parser.parse(reader1.readLine());
            System.out.print(obj.get("id")+" ");
                System.out.print(obj.get("x")+" ");
            System.out.print(obj.get("name")+ " ");
            System.out.println(obj.get("price"));
writer.close();
            }

        }
        catch(ParseException | FileNotFoundException e) {e.printStackTrace();}

        catch (IOException e) {e.printStackTrace();}
    }
}
