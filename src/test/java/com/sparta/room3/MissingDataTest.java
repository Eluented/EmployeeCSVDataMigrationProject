package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.EmployeeMap;
import com.sparta.room3.utils.MissingFieldsList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissingDataTest {
    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestMissingData.csv");
    }


    @Test
    @DisplayName("If data is missing from an employee then the employee should be added to the corrupt list")
    void ifDataIsMissingFromAnEmployeeThenTheEmployeeShouldBeAddedToTheCorruptList() {
        Assertions.assertEquals(1, CorruptedList.getCorruptList().size());
    }
    @Test
    @DisplayName("If data is missing from an employee then the employee should be added to the missing fields list")
    void ifDataIsMissingFromAnEmployeeThenTheEmployeeShouldBeAddedToTheMissingFieldsList() {
        Assertions.assertEquals(1, MissingFieldsList.getMissingFieldsList().size());
    }

    @Test
    @DisplayName("If data is missing from an employee then the employee should not be added to EmployeeMAp")
    void ifDataIsMissingFromAnEmployeeThenEmployeeIsNotAddedToEmployeeMap() {
        Assertions.assertEquals(null, EmployeeMap.getEmployeeMap());
    }
}
