package com.sparta.room3.utils;

import com.sparta.room3.controller.Employee;

import java.util.ArrayList;


public class EmployeeList {
    private static EmployeeList employeeList;
    private static ArrayList<Employee> listOfEmployees;

    private EmployeeList(){}

    public static void addNewEmployeeToList(Employee employee){

        if(employeeList == null)
            employeeList = new EmployeeList();

        if(listOfEmployees == null)
            listOfEmployees = new ArrayList<Employee>();

        listOfEmployees.add(employee);
    }
}
