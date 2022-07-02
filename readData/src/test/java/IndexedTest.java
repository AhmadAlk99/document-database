import Indexes.BTree2;
import Indexes.mappedIndexed;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IndexedTest {

        @Test
        public void BtreeTest() {
                BTree2<Integer, ArrayList<String>> bt = new BTree2<>();
                List<String> test = new ArrayList(Arrays.asList("ahmad", "mohammed", "fahed"));

                bt.put(1, "ahmad");
                bt.put(1, "mohammed");
                bt.put(1, "fahed");
                bt.put(2, "motasem");
                bt.put(3, "aseel");
                assertEquals(test, bt.get(1));
                assertEquals(new ArrayList<>(Arrays.asList("motasem")), bt.get(2));
                assertNotEquals(new ArrayList<>(Arrays.asList("motasem")), bt.get(3));
        }
        @Test
        public void mappedIndexed() {
                mappedIndexed<Integer, String> bt = new mappedIndexed<>();
                List<String> test = new ArrayList(Arrays.asList("ahmad", "mohammed", "fahed"));

                bt.put(1, "ahmad");
                bt.put(1, "mohammed");
                bt.put(1, "fahed");
                bt.put(2, "motasem");
                bt.put(3, "aseel");
                assertEquals(test, bt.get(1));
                assertEquals(new ArrayList<>(Arrays.asList("motasem")), bt.get(2));
        }
}