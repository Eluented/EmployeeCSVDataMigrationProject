package com.sparta.room3;
import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.*;


public class ReadCSVMethodTest {

    @Test
    @DisplayName("employee object should be created from correct employee data")
    void employeeObjectShouldBeCreatedFromCorrectEmployeeData() {
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestCorrectEmployee.csv");
        Assertions.assertEquals(1, EmployeeMap.getEmployeeMap().size());
    }

    @Test
    @DisplayName("If employee data is correct then employee should not be added to corrupt data")
    void ifEmployeeDataIsCorrectThenEmployeeShouldNotBeAddedToCorruptData() {
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestCorrectEmployee.csv");
        Assertions.assertEquals(null, CorruptedList.getCorruptList());
    }
    



}
