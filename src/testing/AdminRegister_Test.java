package testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminRegister_Test {

    @BeforeEach
    void setUp() {
        AdminRegister_Class registerAdmin = new AdminRegister_Class("Dipesh","Siwakoti","dipeshsiwakoti112@gmail.com","dipesh__siwakoti", "dipesh111");
    }

    @Test
    // Register inserting test fail
    public void testGettersEmail() {
        AdminRegister_Class registerAdmin = new AdminRegister_Class("Dipesh","Siwakoti","dipeshsiwakoti112@gmail.com","dipesh__siwakoti", "dipesh111");
        String expected = "dipeshsiwakoti112@gmail.com";
        String actual = registerAdmin.getEmail();
        assertEquals(expected,actual);
    }



}