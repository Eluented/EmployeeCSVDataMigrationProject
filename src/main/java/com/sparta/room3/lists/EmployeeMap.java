package com.sparta.room3.lists;

import com.sparta.room3.controller.Employee;

import java.util.HashMap;


public class EmployeeMap {
    private static EmployeeMap employeeMap;
    private static HashMap<Integer, Employee> mapOfEmployees;

    private EmployeeMap(){}

    public static void addNewEmployeeToList(Integer id, Employee employee){

        if(employeeMap == null)
            employeeMap = new EmployeeMap();

        if(mapOfEmployees == null)
            mapOfEmployees = new HashMap<Integer, Employee>();

        mapOfEmployees.put(id,employee);
    }

    public static HashMap<Integer, Employee> getEmployeeMap(){
        return mapOfEmployees;
    }
}
