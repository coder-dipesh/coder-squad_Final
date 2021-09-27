package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRegister_ClassTest {

    @Test
    // testing class not null
    public void testConstructor() {
        ClientRegister_Class registerClass = new ClientRegister_Class();
        assertNotNull(registerClass);
    }

    @Test
    // Register inserting test pass
    public void testGetters() {
        ClientRegister_Class registerClient = new ClientRegister_Class("Roswon","Kc","kcrowson7323@gmail.com","kcrowson", "7323");
        String expected = "kcrowson";
        String actual = registerClient.getUsername();
        assertEquals(expected,actual);
    }

    @Test
    // Register inserting test fail
    public void testGettersEmail() {
        ClientRegister_Class registerClient = new ClientRegister_Class("Roswon","Kc","kcrowson7323@gmail.com","kcrowson", "7323");
        String expected = "kcrowson7323@gmail.com";
        String actual = registerClient.getEmail();
        assertEquals(expected,actual);
    }

}