package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInvalidPrefix {

    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidPrefix.csv");
    }

    @Test
    @DisplayName("If name prefix is incorrect then Employee is not added to employee map")
    void IfNamePrefixIsIncorrectThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }

    @Test
    @DisplayName("If name Prefix is incorrect then Employee should be added to corrupt list")
    void ifNamePrefixIsIncorrectThenEmployeeShouldBeAddedToCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }
}
