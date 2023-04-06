package com.sparta.room3.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceCSV {
    public static String[] getListFromCSV(int n)  {
        if (n <= 0 || n >= 1000) {
           throw new IllegalArgumentException("Please enter a valid input number");
        }
        // Unsure if in requirements, can be change if need be.
        // We need to be user is not entering a number below 0 and a to high number may take a long time;
        // Do you think we need a null check?
        String employeeLine;
        List<String> employeeListFromCSV = new ArrayList<>();
        // Should we through or catch Exeption here??
        try (BufferedReader inputFromCSV = new BufferedReader(new FileReader("src/main/resources/EmployeeRecords.csv"));) {
            int iteration = 0;
            while ((employeeLine = inputFromCSV.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                employeeListFromCSV.add(employeeLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeListFromCSV.subList(0,n).toArray(new String[0]);
    }
// Katie AND CHLOE
//    READ CSV FILE METHOD
}
