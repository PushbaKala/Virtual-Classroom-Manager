# Virtual-Classroom-Manager

This project is a terminal-based Virtual Classroom Manager that handles class scheduling, student attendance, and assignment submissions. The application is designed to run for a long time gathering inputs from users, with proper logging, exception handling, and adherence to best practices.

## Features

1. *Classroom Management*: Add, list, and remove virtual classrooms.
2. *Student Management*: Enroll students into classrooms, and list students in each classroom.
3. *Assignment Management*: Schedule assignments for classrooms and allow students to submit them.
4. *Logging*: Proper logging mechanisms are implemented.
5. *Exception Handling*: Robust exception handling for all operations.
6. *Performance Optimized*: Highly optimized for performance with defensive programming and validations at all levels.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IDE or text editor for Java development

### Running the Program

1. *Clone the Repository*

    bash
    git clone https://github.com/yourusername/virtual-classroom-manager.git
    cd virtual-classroom-manager
    

2. *Compile and Run*

    bash
    javac src/Main.java
    java -cp src Main
    

## Usage

### User Input

1. *Add Classroom*: add_classroom <class_name>
   - Example: add_classroom Math101

2. *Remove Classroom*: remove_classroom <class_name>
   - Example: remove_classroom Math101

3. *List Classrooms*: list_classrooms

4. *Add Student*: add_student <student_id> <class_name>
   - Example: add_student 101 Math101

5. *List Students*: list_students <class_name>
   - Example: list_students Math101

6. *Schedule Assignment*: schedule_assignment <class_name> <assignment_name>
   - Example: schedule_assignment Math101 Homework1

7. *Submit Assignment*: submit_assignment <student_id> <class_name> <assignment_name>
   - Example: submit_assignment 101 Math101 Homework1

8. *Display Assignment Status*: display_assignment_status <assignment_name>
   - Example: display_assignment_status Homework1

### Console Output

- *Classroom Addition*: "Classroom [Name] has been created."
- *Classroom Removal*: "Classroom [Name] removed."
- *Student Addition*: "Student [ID] has been enrolled in [Class Name]."
- *Assignment Scheduled*: "Assignment for [Class Name] has been scheduled."
- *Assignment Submission*: "Assignment submitted by Student [ID] in [Class Name]."
- *Display Assignment Status*: Shows assignment completion status for all students in the classroom.

## Design Principles

- *SOLID Principles*: The application is designed following SOLID principles for maintainability and scalability.
- *Logging*: Uses java.util.logging for comprehensive logging.
- *Exception Handling*: Proper handling of exceptions to ensure the program does not crash unexpectedly.
- *Defensive Programming*: Validations and checks are in place to prevent invalid inputs and states.

## Code Walkthrough

The application consists of the following classes:

### classroom

Manages students and assignments for a classroom.

### Student

Represents a student with an ID and tracks assignment completion status.

### Main

Handles user input and coordinates actions across classrooms, students, and assignments.
