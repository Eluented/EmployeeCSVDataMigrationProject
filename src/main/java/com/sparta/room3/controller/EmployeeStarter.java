package com.sparta.room3.controller;

import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;
import com.sparta.room3.view.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeStarter {
    public static void start() {

        EmployeeServiceCSV.readCSVFile("EmployeeCSVDataMigrationProject/src/main/resources/EmployeeRecords.csv");

        UserInterface.userInteraction();
        }

    }



