package com.sparta.room3.controller;

import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeStarter {
    public static void start() {

        EmployeeServiceCSV.readCSVFile("src/main/resources/EmployeeRecords.csv");
//        System.out.println(EmployeeMap.getEmployeeMap());
        List<String[]> list = CorruptedList.getCorruptList();
        for (String[] pip : list) {
            System.out.println(Arrays.toString(pip));
    }
        }

    }



