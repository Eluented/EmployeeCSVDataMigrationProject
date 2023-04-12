package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInvalidMiddleInitial {

    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestIncorrectMiddleInitial.csv");
    }
    @Test
    @DisplayName("if middle initial is invalid then employee is not added to employee map")
    void ifMiddleInitialIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }

    @Test
    @DisplayName("if middle initial is invalid the employee should be added to corrupt list")
    void ifMiddleInitialIsInvalidTheEmployeeShouldBeAddedToCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }

}
