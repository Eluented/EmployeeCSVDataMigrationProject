package com.sparta.room3.lists;

import java.util.ArrayList;

public class CorruptedList {

    private static CorruptedList corruptedList;
    private static ArrayList<String[]> listOfCorruptions;

    private CorruptedList(){}

    public static void addCorruptionsToList(String[] employee){

        if(corruptedList == null)
            corruptedList = new CorruptedList();

        if(listOfCorruptions == null)
            listOfCorruptions = new ArrayList<String[]>();

        listOfCorruptions.add(employee);
    }

    public static ArrayList<String[]> getCorruptList(){

        return listOfCorruptions;

    }


}
