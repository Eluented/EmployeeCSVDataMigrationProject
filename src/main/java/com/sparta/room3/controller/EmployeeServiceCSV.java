package com.sparta.room3.controller;

import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
        int uniqueRecords=0;

//        Set<String> duplicateRecords = new HashSet<>();
//        List<String> corruptRecords = new ArrayList<>();

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
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }
                try {
                    empId = Integer.parseInt(fields[0]);
                } catch (NumberFormatException e) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }

                namePrefix = fields[1];
                if (namePrefix.equals("Mr.") || namePrefix.equals("Mrs.") || namePrefix.equals("Ms.")
                    || namePrefix.equals("Dr.") || namePrefix.equals("Hon.") || namePrefix.equals("Prof."))  {

                } else {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }

                firstName = fields[2];
                middleInitial = fields[3];
                if (middleInitial.length() > 1) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }
                lastName = fields[4];

                gender = fields[5];
                if (!gender.equals("F") && !gender.equals("M")) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                email = fields[6];

                String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                Pattern regexemail = Pattern.compile(regex);
                if (!regexemail.matcher(email).matches()) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }

                try {
                    dateOfBirth = formatter.parse(fields[7]);
                } catch (ParseException e) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                try {
                    dateOfJoining = formatter.parse(fields[8]);
                } catch (ParseException e) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                try {
                    salary = Double.parseDouble(fields[9]);
                    if (salary <= 0.0) {
                        CorruptedList.addCorruptionsToList(fields);
                        corruptedRecords++;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    CorruptedList.addCorruptionsToList(fields);
//                    corruptRecords.add(line);
                    corruptedRecords++;
                    continue;
                }


                Employee employee = new Employee(empId, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
                if (EmployeeMap.getEmployeeMap() == null || !EmployeeMap.getEmployeeMap().containsKey(employee.getEmpID())) {
                    EmployeeMap.addNewEmployeeToList(employee.getEmpID(), employee);

                } else {
                    DuplicateList.addDuplicatesToList(employee);
//                    duplicateRecords.add(line);
                    duplicatedRecords++;

                }

            }
            if (EmployeeMap.getEmployeeMap() != null){
                uniqueRecords = EmployeeMap.getEmployeeMap().size();
            }
         //   System.out.println(employeeSet);
            System.out.println("Number of duplicate records: " + duplicatedRecords);
            System.out.println("Number of corrupted records: " + corruptedRecords);
            System.out.println("Number of unique records: " + uniqueRecords);


        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(),e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
