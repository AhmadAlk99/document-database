import DocumenteDataBase.JsonObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class testJsonObj {

    @Test
    public void tesObj(){
        String path = "src/main/resources/DataBases/ahmad-DataBase";
        JsonObject jsonObject=new JsonObject();
        System.out.println(jsonObject.addJsonObject(path,"my-schema2","{\"id\": 1, \"name\": \"Lampshade\", \"price\": 0}"));

        assertEquals(true,jsonObject.deleteJsonObject(path,"my-schema2",1));
    }
}
