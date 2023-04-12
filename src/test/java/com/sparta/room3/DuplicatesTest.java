package com.sparta.room3;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DuplicatesTest {
    @BeforeAll
    static void setup(){
        EmployeeServiceCSV.readCSVFile("src/test/testResources/TestDuplicateEmployee.csv");
    }

    @Test
    @DisplayName("If there is duplicate data only one employee should be added to EmployeeMap")
    void ifThereIsDuplicateDataOnlyOneEmployeeShouldBeAddedToEmployeeMap() {
        Assertions.assertEquals(1, EmployeeMap.getEmployeeMap().size());
    }
    @Test
    @DisplayName("If there is duplicate data then an employee should be added to duplicates list")
    void ifThereIsDuplicateDataThenAnEmployeeShouldBeAddedToDuplicatesList() {
        Assertions.assertEquals(1, DuplicateList.getDuplicateList().size());
    }


}
