package testing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminRegister_ClassTest {

    @Test
    // testing class not null
    public void testConstructor() {
        AdminRegister_Class registerClass = new AdminRegister_Class();
        assertNotNull(registerClass);
    }

    @Test
    // Register inserting test pass
    public void testGetters() {
        AdminRegister_Class registerAdmin = new AdminRegister_Class("Dipesh","Siwakoti","dipeshsiwakoti112@gmail.com","dipesh__siwakoti", "dipesh111");
        String expected = "dipesh__siwakoti";
        String actual = registerAdmin.getUsername();
        assertEquals(expected,actual);
    }
}