import Doa.DaoImp.UserValidatedImp;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    String name="123";
    String password="123";

    UserValidatedImp user = new UserValidatedImp(name,password);

    @Test
    public void testValid(){
        assertEquals(true,user.isValid());
    }
    @Test
    public void testAdmin(){
        assertEquals(false,user.isAdmin());
    }
}
