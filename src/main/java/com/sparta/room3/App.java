package com.sparta.room3;

import static com.sparta.room3.controller.EmployeeServiceCSV.getListFromCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] test = getListFromCSV(5);
        for (String word : test) {
            System.out.println(word);
        }
        

//        System.out.println( "Hello World!" );
    }
}
