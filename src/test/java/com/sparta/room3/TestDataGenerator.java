package com.sparta.room3;

import com.sparta.room3.model.EmployeeDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDataGenerator {

    private static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE IF NOT EXISTS employees ("
            + "id INT(11) NOT NULL AUTO_INCREMENT,"
            + "title VARCHAR(5),"
            + "first_name VARCHAR(50) NOT NULL,"
            + "middle_initial VARCHAR(1),"
            + "last_name VARCHAR(50) NOT NULL,"
            + "gender VARCHAR(6),"
            + "email VARCHAR(100) NOT NULL,"
            + "date_of_birth DATE,"
            + "date_of_employment DATE,"
            + "salary DECIMAL(10,2),"
            + "PRIMARY KEY (id))";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employees "
            + "(id, title, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_employment, salary) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final int EMPLOYEE_ID = 1;
    private static final String EMPLOYEE_TITLE = "Mr";
    private static final String EMPLOYEE_FIRST_NAME = "John";
    private static final String EMPLOYEE_MIDDLE_INITIAL = "D";
    private static final String EMPLOYEE_LAST_NAME = "Doe";
    private static final String EMPLOYEE_GENDER = "Male";
    private static final String EMPLOYEE_EMAIL = "john.doe@example.com";
    private static final Date EMPLOYEE_DATE_OF_BIRTH = Date.valueOf("2000-01-01");
    private static final Date EMPLOYEE_DATE_OF_EMPLOYMENT = Date.valueOf("2021-01-01");
    private static final double EMPLOYEE_SALARY = 50000.0;

    public static void createTestDatabase(Connection connection) throws SQLException {
        try (PreparedStatement createEmployeeTableStatement = connection.prepareStatement(CREATE_EMPLOYEE_TABLE)) {
            createEmployeeTableStatement.execute();
        }
        try (PreparedStatement insertEmployeeStatement = connection.prepareStatement(INSERT_EMPLOYEE)) {
            insertEmployeeStatement.setInt(1, EMPLOYEE_ID);
            insertEmployeeStatement.setString(2, EMPLOYEE_TITLE);
            insertEmployeeStatement.setString(3, EMPLOYEE_FIRST_NAME);
            insertEmployeeStatement.setString(4, EMPLOYEE_MIDDLE_INITIAL);
            insertEmployeeStatement.setString(5, EMPLOYEE_LAST_NAME);
            insertEmployeeStatement.setString(6, EMPLOYEE_GENDER);
            insertEmployeeStatement.setString(7, EMPLOYEE_EMAIL);
            insertEmployeeStatement.setDate(8, EMPLOYEE_DATE_OF_BIRTH);
            insertEmployeeStatement.setDate(9, EMPLOYEE_DATE_OF_EMPLOYMENT);
            insertEmployeeStatement.setDouble(10, EMPLOYEE_SALARY);
            insertEmployeeStatement.execute();
        }
    }

    public static void deleteTestDatabase(Connection connection) {

            try (PreparedStatement dropEmployeeTableStatement = connection.prepareStatement("DROP TABLE IF EXISTS employees")) {
                dropEmployeeTableStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }
}
