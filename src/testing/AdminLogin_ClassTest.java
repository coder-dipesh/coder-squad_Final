package testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminLogin_ClassTest {

    @Test
    public void test_case_first() {
        String username ="dipesh__siwakoti";
        String pass = "dipesh111";

        AdminLogin_Class login_test = new AdminLogin_Class();
        boolean result = login_test.userLogin(username,pass);

        assertEquals(true,result);
    }

	@Test
		public void test_case_second() {
		String username ="dipesh__siwakoti";
		String pass = "123123";
		AdminLogin_Class login_test = new AdminLogin_Class();
		boolean result = login_test.userLogin(username,pass);

		assertNotEquals(true,result);

	}

}