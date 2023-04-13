# Employee CSV Data Migration

This is a Java project that reads data from a CSV file, parses it, and populates a collection of objects. It then persists the data to a relational database using JDBC. The project follows best practices for object-oriented design, SOLID principles, and design patterns, and includes comprehensive JUnit testing, logging, and exception handling.

## Requirements

- Java Development Kit (JDK) 11 or later
- IntelliJ IDEA or another Java IDE
- MySQL database management system
- Git or another version control system

## Installation

1. Clone the repository from GitHub:
git clone https://github.com/yourusername/employeecsvdatamigration.git

2. Import the project into your Java IDE.

3. Install the necessary dependencies using a build tool such as Maven or Gradle.

4. Create a MySQL database and configure the JDBC driver settings in the DbConnectionUtil class.

5. Run the EmployeeCsvDataMigrationApplication class to start the application.

## Usage

1. Place a CSV file with employee data in the project directory.

2. Run the application and select the CSV file.

3. The application will read the data from the CSV file, parse it, and add it to a collection of objects.

4. The application will persist the data to a MySQL database using JDBC.

5. You can verify that the data was successfully migrated by running the EmployeeDaoTest class, which contains JUnit tests for the DAO pattern implementation.


Project Roles:

| Role                | Contributor        | Contact                        |
|---------------------|--------------------|--------------------------------|
| Scrum & Github Lead | Onur Belek         | Obelek@spartaglobal.com        |
| Dev/Tester          | Anusha Gampa       | AGampa@spartaglobal.com        |
| Dev/Tester          | Chloe Vera Turner  | cturner@spartaglobal.com       |
| Dev/Tester          | Omar Hussain       | ohussain@spartaglobal.com      |
| Dev/Tester          | Katie Olivia Hulme | katiehulme@spartaglobal.com    |
| Dev/Tester          | Ajay Balakrishnan  | abalakrishnan@spartaglobal.com |



**Details of the Functionality in Major Sections:**

EmployeeServiceCSV.java:

     Our EmployeeServiceCSV class reads the provided CSV file and split various details of an employee, while reading it parse the data and check for duplicate data and corrupted data. This corrupted and duplicate data can be handled by respective sets for further analysis.


**Employee.java:**

       This class provides different getters and setters for various fields of an employee.

**Utils Package:**

     This utils package contains different java classes like Corrupted list, Duplicate list, Employee map classes which stores corrupted records, duplicate records, and unique records of the employee csv file respectively.

**ConnectionProvider.java:**

   This class establish connection to the Database to process queries in the Database. And also, it has a method for closing the connection.

**DAO interface:**

  This interface provides some abstract methods for CRUD operations on database, which needs to be implemented in subclasses.

**Employee DAO:**

     This class implements DAO interface, and it has CRUD operations' method implementation in it.

**Employee DTO:**

     This class helps to transfer data between different applications.


**Summary of Testing:**

     We used Junit in our program to test the corrupted list, duplicate list and unique records and also we tested database connection whether it is closing properly after using resources or not.  


