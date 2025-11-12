# Employee Management System

##  Overview
This **Employee Management System** is a Java-based console application designed to manage employee records using **Object-Oriented Programming (OOP)** principles, **Collections Framework**, and **File Handling** for data persistence.  
It performs CRUD operations (Create, Read, Update, Delete) and stores data locally through **serialization** without using any database or external dependency.

---

##  Features
- Add, view, update, and delete employee records.
- Persistent storage using `employees.dat` file (serialized objects).
- Modular Java architecture with multiple classes.
- Input validation and error handling for a clean user experience.
- Search functionality by ID or name/role.

---

##  Project Structure

```
EmployeeManagementSystem/
│
├── Employee.java            # Employee model class (Serializable)
├── EmployeeManager.java      # Handles CRUD operations and business logic
├── EmployeeStorage.java      # File-based persistence using serialization
├── InputUtil.java            # Input validation helpers
├── Main.java                 # Entry point with console menu
└── employees.dat             # (Auto-created) serialized data file for persistence
```

---

##  Requirements
- Java Development Kit (JDK) 17 or later
- Any IDE or text editor (Recommended: **Visual Studio Code**)
- Command line (Terminal / PowerShell) access

---

##  How to Run in Visual Studio Code

### Step 1: Setup Project Folder
1. Create a new folder, e.g., `EmployeeManagementSystem`.
2. Place **all `.java` files** inside this folder.

### Step 2: Open in VS Code
- Open the folder in VS Code (`File → Open Folder`).
- Make sure the **Java Extension Pack** is installed.

### Step 3: Compile the Code
Open a terminal inside VS Code and run:
```bash
javac *.java
```

### Step 4: Run the Application
Run the program with:
```bash
java Main
```

### Step 5: Save and Exit
When you choose the **Save & Exit** option from the menu, data is automatically stored in `employees.dat`.  
When you relaunch the program, it loads the saved data.

---

##  Example Console Output
```
=== Employee Management ===
1. Add Employee
2. View All Employees
3. Search Employee (by ID or name/role)
4. Update Employee
5. Delete Employee
6. Save & Exit
Enter choice: 1
Enter ID: 101
Enter Name: John Doe
Enter Role: Developer
Enter Salary: 55000
Employee added.
```

---

##  Concepts Demonstrated
- Object-Oriented Programming (Encapsulation, Classes, and Objects)
- Collections Framework (ArrayList)
- Exception Handling
- File I/O and Serialization
- Modular Java Design
- Command-Line Interface

---

##  Future Enhancements
- Add authentication for admin access.
- Implement sorting/filtering features.
- Integrate a GUI (Swing/JavaFX) for improved usability.
- Optionally connect to a database (MySQL/SQLite).

---

##  Author
**Kurapati Chaitanya Sai**  
B.Tech Computer Science and Engineering  
Amrita Vishwa Vidyapeetham  
Email: chaitanyasaikurapati@gmail.com

---
© 2025 Kurapati Chaitanya Sai. All Rights Reserved.
