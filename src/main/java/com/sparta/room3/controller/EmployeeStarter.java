package com.sparta.room3.controller;

import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeStarter {
    public static void start() {

        EmployeeServiceCSV.readCSVFile("src/main/resources/EmployeeRecords.csv");

        }


    }

