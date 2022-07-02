import DocumenteDataBase.JsonObjectSchema;
import org.junit.Test;
import static org.junit.Assert.*;

public class testingSchema {
    JsonObjectSchema test = new JsonObjectSchema();

    @Test
    public void addSchema(){
        String path = "src/main/resources/DataBases/ahmad-DataBase";

        assertEquals(false,test.addSchema(path,"my-schema2"));
        assertEquals(false,test.addSchema(path,"my-schema4"));
    }

    @Test
    public void createSchema(){
        String path = "src/main/resources/DataBases/ahmad-DataBase";
        String json=
                "    \"_id\": {\n" +
                        "      \"type\": \"integer\"\n" +
                        "    },\n" +
                        "    \"name\": {\n" +
                        "      \"type\": \"string\"\n" +
                        "    },\n" +
                        "    \"price\": {\n" +
                        "      \"type\": \"number\",\n" +
                        "      \"minimum\": 0\n" +
                        "    }\n" +
                        "  }\n" ;
        assertEquals(false,test.createJsonSchema(path,"my-schema2",json));
    }
}
