import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static core.PageFactory.open;

public class SimpleLoginTest {

    @Test
    public void testSimpleLogin(){
        open(LoginPage.class)
                .login("test","test");
    }
}
