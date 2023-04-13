ROOM 3: Employee Factory/SQL Project
Omar, Onur, Chloe, Anusha, Katie.

The purpose of this program is to allow a user to uploaded a CSV file of Employees, which can be sperated by corrupted data, duplicate data, or unique data.
Once we have the unique data we can then uploaded it to an SQL database, and use an EmployeeDTO and a EmployeeDAO to modify, retrive or delete data from the datebase.

**PHASE 1**

The first method that is doing the magority of the heavy lifting is the readCSVFile.
It is in this method where the CSV file is read, and the data is seperated.
This is Done by:
- Reading the CSV (skipping the headers).
- Spliting each line into it's own array.
- Checking it index point to see if it what we want. If it's not then that line goes into a CorruptedList Singleton.
- Once it's checked all the data for corruption, we then create Employee Objects.
- We place these Employee objects inside of a HashMap, using the EmployeeID's as keys because these should always be unique.
- If the EmployeeMap is null or if it doesn't contain the EmployeeID key. Then the Employee goes in there.
- If the Key is in there. Then the Employee goes into the DuplicateList.

The Lists and The Map where created as singletons because there will never need to be more than one of them. Each objects has two different methods. One to print out the List or Map itself and one to return the size.

**Tests**

Many test where written for Phase 1. Such as:
- Checking that our List/Map objects where being created when we ran the readCSVFile.
- Checking that the method was correctly sorting our data.
- 