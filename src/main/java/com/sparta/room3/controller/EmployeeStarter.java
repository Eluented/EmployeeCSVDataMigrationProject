package com.sparta.room3.controller;

import com.sparta.room3.lists.EmployeeMap;
import com.sparta.room3.model.ConnectionProvider;
import com.sparta.room3.model.EmployeeDAO;
import com.sparta.room3.model.EmployeeDTO;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;

public class EmployeeStarter {
    private static final Logger logger = LogManager.getLogger(EmployeeStarter.class);

    public static void start(String fileName) {
        List<EmployeeDTO> employeeList = new ArrayList<>();
        EmployeeServiceCSV.readCSVFile(fileName);

        HashMap<Integer, Employee> employeeMap = EmployeeMap.getEmployeeMap();
        for (Employee employee : employeeMap.values()) {
            employeeList.add(new EmployeeDTO(
                    employee.getEmpID(),
                    employee.getNamePrefix(),
                    employee.getFirstName(),
                    employee.getMiddleInitial(),
                    employee.getLastName(),
                    employee.getGender(),
                    employee.getEmail(),
                    employee.getDateOfBirth(),
                    employee.getDateOfJoining(),
                    employee.getSalary()
            ));
        }

        try (Connection connection = ConnectionProvider.getConnection()) {

            EmployeeDAO employeeDAO = new EmployeeDAO(connection, employeeList);

            employeeDAO.createTable();
            employeeDAO.saveAllEmployeeList();
        } catch (SQLException e) {
            logger.error("Error accessing database", e);
        }
    }


    }



