# Student Management Project

## Description
This project is a Java desktop application for managing student records, developed using the MVC (Model-View-Controller) architecture. It provides functionalities to manage student data, including:
- Adding, updating, and deleting student records.
- Searching for students based on multiple criteria.
- Saving and loading student data using files or a MySQL database.

## Features
- **Student Information Management**:
  - Store and manage data such as student ID, name, hometown, date of birth, gender, class ID, and grades for three subjects.
- **Search Functionality**:
  - Filter students by hometown, student ID, or class ID.
- **Data Persistence**:
  - Save data to local files or a MySQL database.
- **User Interface**:
  - A Swing-based GUI with features like tables, forms, and menus.

## Technologies Used
- **Programming Language**: Java
- **GUI Library**: Swing
- **Database**: MySQL
- **Build Tool**: Java SE

## Installation

### Prerequisites
- [JDK 8 or later](https://www.oracle.com/java/technologies/javase-downloads.html)
- MySQL Server

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   ```
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
3. Configure the database:
   - Create a MySQL database named `qlsv`.
   - Import the `qlsv.sql` script (if provided) to set up the necessary tables.
   - Update the database credentials in the `JDBCUtil` class:
     ```java
     String url = "jdbc:mysql://localhost:3306/qlsv";
     String username = "root";
     String password = "";
     ```
4. Compile and run the project.

## Usage
1. Launch the application by running the `QLSVTest` class.
2. Use the menu options and forms to:
   - Add or update student details.
   - Search for students.
   - Save or load data from a file or database.
3. View the student records in the table.

## Project Structure
- **Model**: Contains data models like `ThiSinh` (Student) and `Tinh` (Province).
- **View**: Implements the GUI using Swing components.
- **Controller**: Handles user interactions and updates the model or view accordingly.
- **Database**: Includes the `JDBCUtil` class for database connectivity.
- **DAO**: Manages database operations for the `ThiSinh` model.
- **Test**: Entry point to launch the application.

## Screenshots
![{6EB8AC13-470C-4BCB-87D9-97A71242D408}](https://github.com/user-attachments/assets/f7db4ead-7952-4536-af83-62302206fe30)

## Future Enhancements
- Add user authentication.
- Enhance error handling.
- Implement REST APIs for web-based integration.

## License
This project is licensed under the MIT License.

## Author
[Lê Phi Anh](https://github.com/LePhiAnhDev)

