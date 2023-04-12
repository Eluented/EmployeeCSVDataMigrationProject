package com.sparta.room3;

import com.sparta.room3.model.ConnectionProvider;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionProviderTest {

    @BeforeAll
    public static void setup() {
        // Create a new database and populate it with some test data
        // This is only needed if there is no existing database with the same name and structure
        // Alternatively, you can use a separate test database for your tests
        try (Connection connection = ConnectionProvider.getConnection()) {
            TestDataGenerator testDataGenerator = new TestDataGenerator();
            testDataGenerator.createTestDatabase(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to set up test database");
        }
    }

    @AfterAll
    public static void cleanup() {
        ConnectionProvider.closeConnection();
    }


    @Test
    public void testGetConnection() {
        // Verify that getConnection returns a non-null connection object
        Connection connection = ConnectionProvider.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testGetConnectionTwiceReturnsSameConnection() {
        // Verify that getConnection returns the same connection object when called multiple times
        Connection connection1 = ConnectionProvider.getConnection();
        Connection connection2 = ConnectionProvider.getConnection();
        assertSame(connection1, connection2);
    }

    @Test
    public void testCloseConnection() {
        // Verify that closeConnection closes the connection and sets it to null
        Connection connection = ConnectionProvider.getConnection();
        assertNotNull(connection);
        ConnectionProvider.closeConnection();
        try {
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to close connection");
        }
        connection = ConnectionProvider.getConnection(); // re-open connection for further testing
        assertNotNull(connection);
    }

}
