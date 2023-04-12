package com.sparta.room3.utils;

import com.sparta.room3.controller.EmployeeServiceCSV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCollectionTests {

    @BeforeAll
    public static void init(){
        EmployeeServiceCSV.readCSVFile("src/main/resources/EmployeeRecords.csv");
    }
    
    @Test
    @DisplayName("Check That Corrupted Collection Is Created")
    void checkThatCorruptedCollectionIsCreated() {
        Assertions.assertNotNull(CorruptedList.getCorruptList());
    }

    @Test
    @DisplayName("Check That duplicate Collection Is Created ")
    void checkThatDuplicateCollectionIsCreated() {
        Assertions.assertNotNull(DuplicateList.getDuplicateList());

    }

    @Test
    @DisplayName("Check that Unique Collection Is Created")
    void checkThatUniqueCollectionIsCreated() {
        Assertions.assertNotNull(EmployeeMap.getEmployeeMap());
    }


//    @Test
//    @DisplayName("Test To See if the Correct Number or Unique Records is shown")
//    void testToSeeIfTheCorrectNumberOfUniqueRecordsIsShow() {
//
//
//
//    }

}