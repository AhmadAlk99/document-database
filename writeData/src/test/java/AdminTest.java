import Doa.DaoImp.DefaultAdminImp;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminTest {
    @Test
    public void TestUpdated(){
        String name="1234567";
        String pass="123";
        DefaultAdminImp admin = new DefaultAdminImp(name,pass);

        assertEquals(false,admin.updateAdminName("123"));
    }
    @Test
    public void TestCreate(){
        String name="ahmdoosh99";
        String pass="ahmad&ahmad";
        DefaultAdminImp admin = new DefaultAdminImp(name,pass);

        assertEquals(false,admin.createAdmin());
    }

}
