package com.sparta.room3.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeServiceCSV {

    private static final Logger logger= LogManager.getLogger(EmployeeFactory.class);
    public static void readCSVFile(String fileName) {
        SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
        int empId;
        Date dateOfJoining;
        Date dateOfBirth;
        String namePrefix;
        String firstName;
        String middleInitial;
        String lastName;
        String gender;
        String email;
        Double salary;
        int corruptedRecords=0;
        int duplicatedRecords=0;


        Set<Employee> employeeSet = new HashSet<>();
        Set<String> duplicateRecords = new HashSet<>();
        List<String> corruptRecords = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            int iteration = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }


                String[] fields = line.split(",");

                if (fields.length != 10) {
                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }
                try {
                    empId = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }

                namePrefix = fields[1];
                if (namePrefix.equals("Mr.") || namePrefix.equals("Mrs.") || namePrefix.equals("Ms."))

                    continue;

                else
                    corruptRecords.add(line);
                corruptedRecords++;

                firstName = fields[2];
                middleInitial = fields[3];
                if (middleInitial.length() > 1)
                    corruptRecords.add(line);
                corruptedRecords++;
                lastName = fields[4];

                gender = fields[5];
                if (gender.equals('F') || gender.equals('M'))

                    continue;
                else
                    corruptRecords.add(line);

                email = fields[6];
                if (email.contains("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))

                    continue;
                else{
                    corruptRecords.add(line);
                    corruptedRecords++;
                }

                try {
                    dateOfBirth = formatter.parse(fields[7]);
                } catch (ParseException e) {
                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                try {
                    dateOfJoining = formatter.parse(fields[8]);
                } catch (ParseException e) {
                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                salary = Double.parseDouble(fields[9]);


                Employee employee = new Employee(empId, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
                if (employeeSet.contains(employee)) {
                    duplicateRecords.add(line);
                    duplicatedRecords++;
                } else {
                    employeeSet.add(employee);
                }

            }
         //   System.out.println(employeeSet);
            System.out.println("Number of duplicate records: " + duplicatedRecords);
            System.out.println("Number of corrupted records: " + corruptedRecords);
            System.out.println("Number of unique records: " +employeeSet.size());

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(),e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
