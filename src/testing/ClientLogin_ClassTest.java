package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientLogin_ClassTest {

    @Test
    public void test_case_first() {
        String username ="client";
        String pass = "client111";

        ClientLogin_Class login_test = new ClientLogin_Class();
        boolean result = login_test.userLogin(username,pass);

        assertEquals(true,result);
    }

    @Test
    public void test_case_second() {
        String username ="client";
        String pass = "admin111";
        ClientLogin_Class login_test = new ClientLogin_Class();
        boolean result = login_test.userLogin(username,pass);

        assertNotEquals(true,result);

    }


}