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

public class EmployeeFactory {

    private static final Logger logger= LogManager.getLogger(EmployeeFactory.class);
    public static void readCSVFile(String fileName) {

        Set<Employee> employeeSet = new HashSet<>();
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
                SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");

                Date dateOfBirth = formatter.parse(fields[7]);
                Date dateOfJoining = formatter.parse(fields[8]);

                Employee employee = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], dateOfBirth, dateOfJoining, Double.parseDouble(fields[9]));
                employeeSet.add(employee);
                System.out.println(employee);

            }

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(),e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } catch (ParseException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
