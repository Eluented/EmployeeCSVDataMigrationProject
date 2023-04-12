package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NegativeSalaryTest {

    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestNegativeSalary.csv");
    }


    @Test
    @DisplayName("If salary is negative then Employee is not added to employee map")
    void ifSalaryIsNegativeThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }

    @Test
    @DisplayName("If salary is negative then Employee should be added to corrupt list")
    void ifSalaryIsNegativeThenEmployeeShouldBeAddedToCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }
}
