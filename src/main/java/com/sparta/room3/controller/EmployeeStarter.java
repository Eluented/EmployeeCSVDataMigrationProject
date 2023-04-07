package com.sparta.room3.controller;

public class EmployeeStarter {
    public static void start() {
        EmployeeFactory.readCSVFile("src/main/resources/EmployeeRecords.csv");

    }

}
