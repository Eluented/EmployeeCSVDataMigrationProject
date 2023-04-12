package com.sparta.room3.utils;

import java.util.ArrayList;

public class MissingFieldsList {

    private static MissingFieldsList missingFieldsList;
    private static ArrayList<String[]> listOfMissingFields;
    private MissingFieldsList(){}

    public static void addMissingFieldsToList(String[] employee){

        if(missingFieldsList == null)
            missingFieldsList = new MissingFieldsList();

        if(listOfMissingFields == null)
            listOfMissingFields = new ArrayList<String[]>();

        listOfMissingFields.add(employee);
    }

    public static ArrayList<String[]> getMissingFieldsList(){

        return listOfMissingFields;

    }
}
