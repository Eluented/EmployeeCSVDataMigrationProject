package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InvalidEmailTest {

    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestInvalidEmail.csv");
    }


    @Test
    @DisplayName("If email is invalid then Employee is not added to employee map")
    void ifEmailIsInvalidThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }

    @Test
    @DisplayName("If email is invalid then Employee should be added to corrupt list")
    void ifEmailIsInvalidThenEmployeeShouldBeAddedToCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }
}
