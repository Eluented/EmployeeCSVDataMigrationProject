package com.sparta.room3;

import com.sparta.room3.model.ConnectionProvider;
import com.sparta.room3.model.EmployeeDAO;
import com.sparta.room3.model.EmployeeDTO;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOTest {
    private static Connection connection;
    private static List<EmployeeDTO> employeeList;
    private static EmployeeDAO employeeDAO;

    @BeforeAll
    static void setup() throws SQLException {
        connection = ConnectionProvider.getConnection();
        employeeList = new ArrayList<>(Arrays.asList(
                new EmployeeDTO(1, "Mr.", "John", null, "Doe", "M", "johndoe@example.com",
                        Date.valueOf(LocalDate.of(1990, 1, 1)), Date.valueOf(LocalDate.now()), 50000.0),
                new EmployeeDTO(2, "Ms.", "Jane", null, "Doe", "F", "janedoe@example.com",
                        Date.valueOf(LocalDate.of(1995, 1, 1)), Date.valueOf(LocalDate.now()), 60000.0),
                new EmployeeDTO(3, "Mrs.", "Samantha", null, "Smith", "F", "samanthasmith@example.com",
                        Date.valueOf(LocalDate.of(1985, 1, 1)), Date.valueOf(LocalDate.now()), 70000.0)
        ));
        employeeDAO = new EmployeeDAO(connection, employeeList);
    }

    @AfterAll
    static void teardown() throws SQLException {
        connection.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create Table Test")
    void createTableTest() {
        Assertions.assertDoesNotThrow(() -> employeeDAO.createTable());
    }

    @Test
    @Order(2)
    @DisplayName("Save All Employee List Test")
    void saveAllEmployeeListTest() {
        Assertions.assertDoesNotThrow(() -> employeeDAO.saveAllEmployeeList());
    }

    @Test
    @Order(3)
    @DisplayName("Find Employee By Id Test")
    void findEmployeeByIdTest() throws SQLException {
        EmployeeDTO employee = employeeDAO.findEmployeeById(1);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Mr.", employee.getNamePrefix());
        Assertions.assertEquals("John", employee.getFirstName());
        Assertions.assertNull(employee.getMiddleInitial());
        Assertions.assertEquals("Doe", employee.getLastName());
        Assertions.assertEquals("M", employee.getGender());
        Assertions.assertEquals("johndoe@example.com", employee.getEmail());
        Assertions.assertEquals(Date.valueOf(LocalDate.of(1990, 1, 1)), employee.getDateOfBirth());
        Assertions.assertEquals(Date.valueOf(LocalDate.now()), employee.getHireDate());
        Assertions.assertEquals(50000.0, employee.getSalary());
    }

    @Test
    @Order(4)
    @DisplayName("Update Employee Test")
    void updateEmployeeTest() throws SQLException {
        EmployeeDTO employee = employeeDAO.findEmployeeById(1);
        employee.setNamePrefix("Dr.");
        employee.setMiddleInitial("H");
        employee.setSalary(60000.0);
        Assertions.assertDoesNotThrow(() -> employeeDAO.updateEmployee(employee));

        EmployeeDTO updatedEmployee = employeeDAO.findEmployeeById(1);
        Assertions.assertNotNull(updatedEmployee);
        Assertions.assertEquals("Dr.", updatedEmployee.getNamePrefix());
        Assertions.assertEquals("H", updatedEmployee.getMiddleInitial());
        Assertions.assertEquals(60000.0, updatedEmployee.getSalary());
    }
}