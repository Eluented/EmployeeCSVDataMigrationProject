package com.sparta.room3.model;

// Methods
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.sparta.room3.controller.Employee;

public class EmployeeDAO implements DAO<Employee>{
    private final Connection connection;
    private List<Employee> employees;

    public EmployeeDAO(Connection connection, List<Employee> employeeList) {
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
                            "first_name VARCHAR(50) NOT NULL," +
                            "last_name VARCHAR(50) NOT NULL," +
                            "email VARCHAR(50) NOT NULL UNIQUE," +
                            "hire_date DATE NOT NULL," +
                            "salary DOUBLE NOT NULL," +
                            "department VARCHAR(50) NOT NULL" +
                            ")"
            );
        }
    }

    @Override
    public void saveAllEmployeeList() throws SQLException {
        String sql = "INSERT INTO employees (first_name, last_name, email, hire_date, salary, department) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Employee employee : employees) {
                statement.setString(1, employee.getFirstName());
                statement.setString(2, employee.getLastName());
                statement.setString(3, employee.getEmail());
                statement.setDate(4, new java.sql.Date(employee.getDateOfJoining().getTime()));
                statement.setDouble(5, employee.getSalary());
                statement.executeUpdate();
            }
        }
    }

//    public Employee findById(int id) throws SQLException {
//        String sql = "SELECT * FROM employees WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                return createEmployee(resultSet);
//            }
//            return null;
//        }
//    }

//    private Employee createEmployee(ResultSet resultSet) throws SQLException {
//        int id = resultSet.getInt("id");
//        String firstName = resultSet.getString("first_name");
//        String lastName = resultSet.getString("last_name");
//        String email = resultSet.getString("email");
//        Date hireDate = Date.valueOf(resultSet.getDate("hire_date").toLocalDate());
//        double salary = resultSet.getDouble("salary");
//        String department = resultSet.getString("department");
//        return new Employee(id, firstName, lastName, email, hireDate, salary, department);
//    }
}

