package com.sparta.room3.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

    private static Connection connection=null;

    private static final String URL="jdbc:mysql://localhost:3306/csv_employees";

    private static Properties properties=new Properties();

    private ConnectionProvider(){

    }

    public static Connection getConnection(){

        if(connection==null){

            try {
                properties.load(new FileReader("src/main/resources/login.properties"));
                connection= DriverManager.getConnection(URL,properties.getProperty("username"), properties.getProperty("password"));
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }


        }

        return connection;
    }

    public static void closeConnection(){
        if(connection!=null){

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }





}
