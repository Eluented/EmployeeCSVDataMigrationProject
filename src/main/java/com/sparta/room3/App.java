package com.sparta.room3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sparta.room3.controller.EmployeeStarter;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        EmployeeStarter.start("src/main/resources/EmployeeRecords.csv");
        logger.info("Hello, log4j2!");

    }
}
