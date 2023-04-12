package com.sparta.room3.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sparta.room3.controller.Employee;
import com.sparta.room3.model.EmployeeDTO;

public class EmployeeDAO implements DAO<EmployeeDTO> {
    private final Connection connection;
    private List<EmployeeDTO> employees;

    public EmployeeDAO(Connection connection, List<EmployeeDTO> employeeList) {
        this.connection = connection;
        employees = new ArrayList<>(employeeList);
    }

    @Override
    public void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS employees");
            statement.executeUpdate(
                    "CREATE TABLE employees (" +
                            "id INT PRIMARY KEY AUTO_INCREMENT," +
                            "name_prefix VARCHAR(5) NOT NULL," +
                            "first_name VARCHAR(50) NOT NULL," +
                            "middle_initial VARCHAR(1)," +
                            "last_name VARCHAR(50) NOT NULL," +
                            "gender VARCHAR(1)," +
                            "email VARCHAR(50) NOT NULL UNIQUE," +
                            "date_of_birth DATE NOT NULL," +
                            "hire_date DATE NOT NULL," +
                            "salary DOUBLE NOT NULL" +
                            ")"
            );
        }
    }

    @Override
    public void saveAllEmployeeList() throws SQLException {
        String sql = "INSERT INTO employees (first_name, last_name, email, hire_date, salary) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (EmployeeDTO employee : employees) {
                statement.setString(1, employee.getFirstName());
                statement.setString(2, employee.getLastName());
                statement.setString(3, employee.getEmail());
                statement.setDate(4, new java.sql.Date(employee.getHireDate().getTime()));
                statement.setDouble(5, employee.getSalary());
                statement.executeUpdate();
            }
        }
    }

    @Override
    public EmployeeDTO findEmployeeById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createEmployee(resultSet);
            }
            return null;
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employee) throws SQLException {
        String sql = "UPDATE employees SET name_prefix=?, first_name=?, middle_initial=?, last_name=?, gender=?, email=?, date_of_birth=?, hire_date=?, salary=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getNamePrefix());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getMiddleInitial());
            statement.setString(4, employee.getLastName());
            statement.setString(5, employee.getGender());
            statement.setString(6, employee.getEmail());
            statement.setDate(7, new java.sql.Date(employee.getDateOfBirth().getTime()));
            statement.setDate(8, new java.sql.Date(employee.getHireDate().getTime()));
            statement.setDouble(9, employee.getSalary());
            statement.setInt(10, employee.getID());
            statement.executeUpdate();
        }
    }


    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() throws SQLException {
        String getEmployeesSQL = "SELECT * FROM employees";
        List<EmployeeDTO> employees = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(getEmployeesSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeDTO employee = createEmployee(resultSet);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }


    private EmployeeDTO createEmployee(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String namePrefix = resultSet.getString("name_prefix");
        String firstName = resultSet.getString("first_name");
        String middleInitial = resultSet.getString("middle_initial");
        String lastName = resultSet.getString("last_name");
        String gender = resultSet.getString("gender");
        String email = resultSet.getString("email");
        Date dateOfBirth = Date.valueOf(resultSet.getDate("date_of_birth").toLocalDate());
        Date hireDate = Date.valueOf(resultSet.getDate("hire_date").toLocalDate());
        double salary = resultSet.getDouble("salary");
        return new EmployeeDTO(id, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, hireDate, salary);
    }



}

