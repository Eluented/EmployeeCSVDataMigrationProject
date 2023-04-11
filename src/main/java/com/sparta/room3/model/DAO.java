package com.sparta.room3.model;
import java.sql.SQLException;
import java.util.List;
import com.sparta.room3.controller.Employee;

public interface DAO <T> {
    void createTable() throws SQLException;
    void saveAllEmployeeList() throws SQLException;
}
