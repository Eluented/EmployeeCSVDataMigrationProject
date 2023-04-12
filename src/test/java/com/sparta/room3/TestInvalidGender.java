package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInvalidGender {

    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidGender.csv");
    }

    @Test
    @DisplayName("If Gender is invalid then employee is not added to employeeMap")
    void ifGenderIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }

    @Test
    @DisplayName("If Gender is invalid then employee should be added to corrupt list")
    void ifGenderIsInvalidThenEmployeeShouldBeAddedToCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }
}
