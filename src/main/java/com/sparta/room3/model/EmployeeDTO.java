package com.sparta.room3.model;

import java.util.Date;

public class EmployeeDTO {
    private int id;
    private String name_prefix;
    private String first_name;
    private String middle_initial;
    private String last_name;
    private String gender;
    private String email;
    private Date date_of_birth;
    private Date hire_date;
    private Double salary;

    public EmployeeDTO(int id, String name_prefix, String first_name, String middle_initial, String last_name, String gender, String email, Date date_of_birth, Date hire_date, Double salary) {
        this.id = id;
        this.name_prefix = name_prefix;
        this.first_name = first_name;
        this.middle_initial = middle_initial;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.hire_date = hire_date;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNamePrefix() {
        return name_prefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.name_prefix = namePrefix;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddleInitial() {
        return middle_initial;
    }

    public void setMiddleInitial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.date_of_birth = dateOfBirth;
    }

    public Date getHireDate() {
        return hire_date;
    }

    public void setHireDate(Date hireDate) {
        this.hire_date = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
