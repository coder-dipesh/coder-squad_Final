package testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Statement;



class DbConnectTest_Test {
    DbConnectTest dbObj;

    @BeforeEach
    void setUp() throws Exception {
        dbObj = new DbConnectTest();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void connectionTest() {
        Statement actual = (Statement) dbObj.connection();
        assertNotEquals(null, actual);
    }

    private void assertNotEquals(Object o, Statement actual) {
    }


}