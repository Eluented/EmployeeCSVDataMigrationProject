package com.sparta.room3;
import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.lists.EmployeeMap;
import org.junit.jupiter.api.*;


public class ReadCSVMethodTest {

    @Test
    @DisplayName("employee object should be created from correct employee data")
    void employeeObjectShouldBeCreatedFromCorrectEmployeeData() {
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestCorrectEmployee.csv");
        Assertions.assertEquals(1, EmployeeMap.getEmployeeMap().size());
    }
    
    @Test
    @DisplayName("If name prefix is incorrect then Employee is not added to employee map")
    void IfNamePrefixIsIncorrectThenEmployeeIsNotAddedToEmployeeMap() {
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidPrefix.csv");
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());

    }

    @Test
    @DisplayName("if middle initial is invalid then employee is not added to employee map")
    void ifMiddleInitialIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
            EmployeeServiceCSV.readCSVFile("src/test/testResources/TestIncorrectMiddleInitial.csv");
            Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }
    
    @Test
    @DisplayName("If Gender is invalid then employee is not added to employeeMap")
    void ifGenderIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidGender.csv");
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }
    

    @Test
    @DisplayName("If email is invalid then Employee is not added to employee map")
    void ifEmailIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
            EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidEmail.csv");
            Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }
    
    @Test
    @DisplayName("If salary is negative then Employee is not added to employee map")
    void ifSalaryIsNegativeThenEmployeeIsNotAddedToEmployeeMap() {
            EmployeeServiceCSV.readCSVFile("src/test/testResources/TestNegativeSalary.csv");
            Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }



}
