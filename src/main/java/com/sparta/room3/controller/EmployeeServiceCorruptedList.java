//package com.sparta.room3.controller;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class EmployeeServiceCorruptedList {
//    private static final Logger logger = LogManager.getLogger(EmployeeServiceCorruptedList.class);
//
//    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    private Set<String> duplicateRecords = new HashSet<>();
//    private List<Employee> uniqueEmployeeList = new ArrayList<>();
//    private List<String> corruptRecords = new ArrayList<>();
//
//    public void readEmployeeData(String filePath) {
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                int id;
//                String namePrefix=values[1];
//                String firstName = values[2];
//                String lastName = values[4];
//                String middleInitial=val;
//                Date dob;
//                if (values.length != 10) {
//                    corruptRecords.add(line);
//                    continue;
//                }
//
//
//                try {
//                    id = Integer.parseInt(values[0]);
//                } catch (NumberFormatException e) {
//                    corruptRecords.add(line);
//                    continue;
//                }
//
//
//                if(namePrefix.equals("Mr.")||namePrefix.equals("Mrs.")||namePrefix.equals("Ms."))
//                   Employee employee=new Employee(id,namePrefix,firstName,middleInitial,lastName,)
//
//
//
//
//
//                try {
//                    dob = dateFormat.parse(values[3]);
//                } catch (ParseException e) {
//                    corruptRecords.add(line);
//                    continue;
//                }
//                Date doj;
//                try {
//                    doj = dateFormat.parse(values[4]);
//                } catch (ParseException e) {
//                    corruptRecords.add(line);
//                    continue;
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage(), e);
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
//}