import ReadData.ReadFromDataBase;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadTest {
    @Test
    public void readTesting(){
        ReadFromDataBase read = new ReadFromDataBase();

        List<String> list =read.readAllData("my-schema2","my-schema2-object.json");

        List<String> list2 = Arrays.asList("{\"_id\": 1,\"name\": \"ahmad\", \"price\": 25}",
                "{\"_id\": 2,\"name\": \"ahmad\", \"price\": 25}",
                "{\"_id\": 3,\"name\": \"ahmad\", \"price\": 25}");

        assertEquals(list2, list);
    }
}
