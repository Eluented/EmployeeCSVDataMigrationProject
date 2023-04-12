package com.sparta.room3;

import com.sparta.room3.model.EmployeeDTO;

import java.util.Random;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDataGenerator {
    Random rand = new Random();

    private static final String CREATE_EMPLOYEE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS employees ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name_prefix VARCHAR(5),"
                    + "first_name VARCHAR(50) NOT NULL,"
                    + "middle_initial VARCHAR(1),"
                    + "last_name VARCHAR(50) NOT NULL,"
                    + "gender VARCHAR(1),"
                    + "email VARCHAR(50) NOT NULL,"
                    + "date_of_birth DATE,"
                    + "hire_date DATE NOT NULL,"
                    + "salary DOUBLE NOT NULL"
                    + ")";

    private static final String INSERT_EMPLOYEE_SQL =
            "INSERT INTO employees "
                    + "(id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, hire_date, salary) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final int EMPLOYEE_ID = (int) (Math.random() * 90000) + 10000;;
    private static final String EMPLOYEE_NAME_PREFIX = "Mr";
    private static final String EMPLOYEE_FIRST_NAME = "John";
    private static final String EMPLOYEE_MIDDLE_INITIAL = "D";
    private static final String EMPLOYEE_LAST_NAME = "Doe";
    private static final String EMPLOYEE_GENDER = "M";
    private static final String EMPLOYEE_EMAIL = "john.doe@example.com";
    private static final String EMPLOYEE_DATE_OF_BIRTH = "2000-01-01";
    private static final String EMPLOYEE_DATE_OF_EMPLOYMENT = "2021-01-01";
    private static final double EMPLOYEE_SALARY = 50000.0;

    public static void createTestDatabase(Connection connection) throws SQLException {
        try (PreparedStatement createEmployeeTableStatement = connection.prepareStatement(CREATE_EMPLOYEE_TABLE_SQL)) {
            createEmployeeTableStatement.execute();
        }
        try (PreparedStatement insertEmployeeStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            insertEmployeeStatement.setInt(1, EMPLOYEE_ID);
            insertEmployeeStatement.setString(2, EMPLOYEE_NAME_PREFIX);
            insertEmployeeStatement.setString(3, EMPLOYEE_FIRST_NAME);
            insertEmployeeStatement.setString(4, EMPLOYEE_MIDDLE_INITIAL);
            insertEmployeeStatement.setString(5, EMPLOYEE_LAST_NAME);
            insertEmployeeStatement.setString(6, EMPLOYEE_GENDER);
            insertEmployeeStatement.setString(7, EMPLOYEE_EMAIL);
            insertEmployeeStatement.setString(8, EMPLOYEE_DATE_OF_BIRTH);
            insertEmployeeStatement.setString(9, EMPLOYEE_DATE_OF_EMPLOYMENT);
            insertEmployeeStatement.setDouble(10, EMPLOYEE_SALARY);
            insertEmployeeStatement.execute();
        }
    }

    public static void deleteTestDatabase(Connection connection) throws SQLException {
        try (PreparedStatement dropEmployeeTableStatement = connection.prepareStatement("DROP TABLE IF EXISTS employees")) {
            dropEmployeeTableStatement.execute();
        }
    }

}
