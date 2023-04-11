package com.sparta.room3.controller;

public class EmployeeStarter {
    public static void start() {

        EmployeeServiceCSV.readCSVFile("src/main/resources/EmployeeRecords.csv");

    }

}
