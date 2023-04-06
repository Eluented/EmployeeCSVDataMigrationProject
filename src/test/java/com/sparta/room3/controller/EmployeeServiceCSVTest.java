package com.sparta.room3.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sparta.room3.controller.EmployeeServiceCSV.getListFromCSV;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceCSVTest {

    @Test
    @DisplayName("Test That We Do Get List from CSV File")
    void testThatWeDoGetAlIStFrommCSVFILE() {
        String[] test = {"198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294"};
        Assertions.assertArrayEquals(test, getListFromCSV(1));
    }

    @Test
    @DisplayName("Read CSV Can't take an invalid input")
    void readCSVCantTakeAnInvalidInput() {
//        Assertions.assertEquals(getListFromCSV(-4),
//                "Please enter a valid input number");

        var emessage = Assertions.assertThrows(IllegalArgumentException.class, () -> getListFromCSV(-1), "Please enter a valid input number");
        Assertions.assertEquals("Please enter a valid input number", emessage.getMessage());
    }

}