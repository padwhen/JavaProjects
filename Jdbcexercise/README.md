***JDBC Exercises***
This repository contains my solutions for the JDBC exercises from my Java course.

**Contents**
The repository contains the following assignments:

Simple CRUD Programs
SimpleStudentListProgram - Lists all students
SimpleStudentSearchProgram - Retrieves a student by ID
SimpleStudentInsertProgram - Inserts a new student
SimpleStudentDeleteProgram - Deletes a student by ID
DAO Based CRUD Programs
StudentDAO - The data access object for students
StudentListProgram - Lists students using StudentDAO
StudentSearchProgram - Finds a student by ID using StudentDAO
StudentJSONProgram - Gets students as JSON using StudentDAO
StudentInsertProgram - Inserts a new student using StudentDAO
StudentDeleteProgram - Deletes a student by ID using StudentDAO
StudentUpdateProgram - Updates a student using StudentDAO

**Running the Programs**
To run the programs, you need:

Eclipse or another Java IDE
JDK 8+
SQLite JDBC driver library added to build path
The GSON library for JSON parsing added to build path
Import the project into your IDE as a Java project. Configure the build path to include the JARs in the lib folder.

Run each Java program file to test out the different CRUD operations. All programs are located in the src folder.

**Database**
The programs connect to a SQLite database file StudentDatabase.sqlite located in the databases folder.

The database contains a single Student table defined as:

**CREATE TABLE Student (
  id INTEGER PRIMARY KEY, 
  firstname VARCHAR(100) NOT NULL,
  lastname VARCHAR(100) NOT NULL,
  streetaddress VARCHAR(100) NOT NULL,
  postcode CHAR(5) NOT NULL,
  postoffice VARCHAR(100) NOT NULL  
)**

The table is populated with initial test data by running the SQL script populate_db.sql located in the databases folder.

