package com.sparta.room3.utils;

import com.sparta.room3.controller.Employee;

import java.util.ArrayList;

public class DuplicateList {

    private static DuplicateList duplicateList;
    private static ArrayList<Employee> listOfDuplicates;

    private DuplicateList(){}

    public static void addDuplicatesToList(Employee employee){

        if(duplicateList == null)
            duplicateList = new DuplicateList();

        if(listOfDuplicates == null)
            listOfDuplicates = new ArrayList<Employee>();

        listOfDuplicates.add(employee);
    }

    public static ArrayList<Employee> getDuplicateList(){

        return listOfDuplicates;
    }

    public static int howManyDuplicateEmployees(){
        return listOfDuplicates.size();
    }
}
