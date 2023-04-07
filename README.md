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


Credits
This project was created by Group3 and is maintained by Group3.
