package com.sparta.room3.view;

import com.sparta.room3.controller.EmployeeServiceCSV;
import com.sparta.room3.model.EmployeeDAO;
import com.sparta.room3.model.EmployeeDTO;
import com.sparta.room3.utils.CorruptedList;
import com.sparta.room3.utils.DuplicateList;
import com.sparta.room3.utils.EmployeeMap;
import com.sparta.room3.utils.MissingFieldsList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {


    public static void userInteraction() {

        System.out.println("Choose one f option from menu: ");
        System.out.println("Enter 1 for number of unique records in the file: ");
        System.out.println("Enter 2 for number of corrupted records in the file: ");
        System.out.println("Enter 3 for number of duplicated records in the file: ");
        System.out.println("Enter 4 for number of records with missing fields in the file: ");
        System.out.println("Enter 5 to search employee records");


        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            if (EmployeeMap.getEmployeeMap() != null) {
                System.out.println("Number of unique records is: " + EmployeeMap.getEmployeeMap().size());

            } else {
                System.out.println("Number of unique records is: 0");
            }
        }
        if (input == 2) {
            if (CorruptedList.getCorruptList() != null) {
                System.out.println("Number of corrupted records is: " + CorruptedList.getCorruptList().size());
            } else {
                System.out.println("Number of corrupted records is: 0");
            }
        }
        if (input == 3) {
            if (DuplicateList.getDuplicateList() != null) {
                System.out.println("Number of duplicated records is: " + DuplicateList.getDuplicateList().size());
            } else {
                System.out.println("Number of duplicated records is: 0");
            }
        }
        if (input == 4) {
            if (MissingFieldsList.getMissingFieldsList() != null) {
                System.out.println("Number of records with missing fields is: " + MissingFieldsList.getMissingFieldsList().size());
            } else {
                System.out.println("Number of records with missing fields is: 0");
            }
        }

        if (input == 5) {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            System.out.println("Enter 1 to search for employee by id");
            System.out.println("Enter 2 to update employee by id");
            System.out.println("Enter 3 to delete employee by id");

            int dbInput = scanner.nextInt();
            if (dbInput == 1) {
                System.out.println("Enter id to search for employee");

                int employeeId = scanner.nextInt();
                System.out.println(employeeId);
                EmployeeDTO foundEmployee = EmployeeDAO.findEmployeeById(employeeId);
                if (foundEmployee != null) {
                    System.out.println("ID: " + foundEmployee.getID());
                    System.out.println("Title: " + foundEmployee.getNamePrefix());
                    System.out.println("First name: " + foundEmployee.getFirstName());
                    System.out.println("Middle initial: " + foundEmployee.getMiddleInitial());
                    System.out.println("Last name: " + foundEmployee.getLastName());
                    System.out.println("Gender: " + foundEmployee.getGender());
                    System.out.println("Email address: " + foundEmployee.getEmail());
                    System.out.println("Date of Birth: " + foundEmployee.getDateOfBirth());
                    System.out.println("Hire Date: " + foundEmployee.getHireDate());
                } else {
                    System.out.println("Employee not found");
                }
            }
            if (dbInput == 2) {
                System.out.println("Enter id for employee to update");
                int employeeId = scanner.nextInt();

                System.out.println("Enter prefix");
                int prefix = scanner.nextInt();

                System.out.println("Enter first name");
                String firstName = scanner.nextLine();

                System.out.println("Enter Middle Initial");
                String initial = scanner.nextLine();

                System.out.println("Enter last name");
                String lastName = scanner.nextLine();

                System.out.println("Enter gender");
                String gender = scanner.nextLine();

                System.out.println("Enter email address");
                String email = scanner.nextLine();

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                System.out.println("Enter date of birth");
                String dateOfBirthString = scanner.nextLine();
                Date dateOfBirth = null;
                try {
                    dateOfBirth = formatter.parse(dateOfBirthString);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Enter hire date");
                String hireDateString = scanner.nextLine();
                Date hireDate = null;
                try {
                    hireDate = formatter.parse(hireDateString);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }


                EmployeeDTO employeeToUpdate = new EmployeeDTO(employeeId, prefix, firstName, initial, lastName, gender, email, dateOfBirth, hireDate);

                EmployeeDTO foundEmployeeBeforeUpdate = EmployeeDAO.findEmployeeById(employeeId);
                if (foundEmployeeBeforeUpdate != null) {
                    EmployeeDAO.updateEmployee(employeeToUpdate);
                    EmployeeDTO foundEmployee = EmployeeDAO.findEmployeeById(employeeId);
                    System.out.println("ID: " + foundEmployee.getID());
                    System.out.println("Title: " + foundEmployee.getNamePrefix());
                    System.out.println("First name: " + foundEmployee.getFirstName());
                    System.out.println("Middle initial: " + foundEmployee.getMiddleInitial());
                    System.out.println("Last name: " + foundEmployee.getLastName());
                    System.out.println("Gender: " + foundEmployee.getGender());
                    System.out.println("Email address: " + foundEmployee.getEmail());
                    System.out.println("Date of Birth: " + foundEmployee.getDateOfBirth());
                    System.out.println("Hire Date: " + foundEmployee.getHireDate());

                } else {
                    System.out.println("Employee not found");
                }
            }
            if (dbInput == 3) {
                System.out.println("Enter id to delete employee");
                int employeeId = scanner.nextInt();
                EmployeeDTO foundEmployee = EmployeeDAO.findEmployeeById(employeeId);
                if (foundEmployee != null) {
                    EmployeeDAO.deleteEmployee(employeeId);
                    System.out.println("Query executed, employee deleted");
                } else {
                    System.out.println("Employee not found");
                }

            }


        }

    }
}


