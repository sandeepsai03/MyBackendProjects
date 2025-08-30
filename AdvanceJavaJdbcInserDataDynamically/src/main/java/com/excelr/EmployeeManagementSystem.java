package com.excelr;

///by using prepared statement we can insert the data dynamically
///this prepared statement is a pre-compiled .
///By using this we can interact with the already existing database.
import java.sql.*;

import java.util.Scanner;

public class EmployeeManagementSystem {
  
  private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
  private static final String USER = "root";
  private static final String PASSWORD = "saiDATABASE123"; 

  private static Connection connection = null;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
      try {
          // Establishing the connection to MySQL
          connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
          System.out.println("Connected to the database.");

          while (true) {
              displayMenu();
              int choice = scanner.nextInt();
              scanner.nextLine();  // Consume newline

              switch (choice) {
                  case 1:
                      addEmployee();
                      break;
                  case 2:
                      updateEmployee();
                      break;
                  case 3:
                      deleteEmployee();
                      break;
                  case 4:
                      displayAllEmployees();
                      break;
                  case 5:
                      System.out.println("Exiting...");
                      return;
                  default:
                      System.out.println("Invalid choice. Please try again.");
              }
          }
      } catch (SQLException e) {
          System.out.println("Database connection failed: " + e.getMessage());
      } finally {
          try {
              if (connection != null) {
                  connection.close();
                  System.out.println("Connection closed.");
              }
          } catch (SQLException e) {
              System.out.println("Error closing connection: " + e.getMessage());
          }
      }
  }

  private static void displayMenu() {
      System.out.println("\n--- Employee Management System ---");
      System.out.println("1. Add a new employee");
      System.out.println("2. Update employee details");
      System.out.println("3. Delete an employee");
      System.out.println("4. Display all employees");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
  }

  private static void addEmployee() {
      System.out.print("Enter Employee ID: ");
      int id = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      System.out.print("Enter Employee Name: ");
      String name = scanner.nextLine();
      System.out.print("Enter Department: ");
      String department = scanner.nextLine();
      System.out.print("Enter Salary: ");
      double salary = scanner.nextDouble();
      ////insert the data dynamically into the database
      String query = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
          statement.setInt(1, id);
          statement.setString(2, name);
          statement.setString(3, department);
          statement.setDouble(4, salary);
          int rowsAffected = statement.executeUpdate();
          System.out.println(rowsAffected + " employee(s) added.");
      } catch (SQLException e) {
          System.out.println("Error adding employee: " + e.getMessage());
      }
  }
 //update the data to the database
  private static void updateEmployee() {
      System.out.print("Enter Employee ID to update: ");
      int id = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      System.out.print("Enter new Employee Name: ");
      String name = scanner.nextLine();
      System.out.print("Enter new Department: ");
      String department = scanner.nextLine();
      System.out.print("Enter new Salary: ");
      double salary = scanner.nextDouble();

      String query = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
          statement.setString(1, name);
          statement.setString(2, department);
          statement.setDouble(3, salary);
          statement.setInt(4, id);
          int rowsAffected = statement.executeUpdate();
          System.out.println(rowsAffected + " employee(s) updated.");
      } catch (SQLException e) {
          System.out.println("Error updating employee: " + e.getMessage());
      }
  }
//delete  the data from the database
  private static void deleteEmployee() {
      System.out.print("Enter Employee ID to delete: ");
      int id = scanner.nextInt();

      String query = "DELETE FROM employees WHERE id = ?";
      try (PreparedStatement statement = connection.prepareStatement(query)) {
          statement.setInt(1, id);
          int rowsAffected = statement.executeUpdate();
          System.out.println(rowsAffected + " employee(s) deleted.");
      } catch (SQLException e) {
          System.out.println("Error deleting employee: " + e.getMessage());
      }
  }
//Retrieve the data from the database
  private static void displayAllEmployees() {
      String query = "SELECT * FROM employees";
      try (Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(query)) {
          System.out.println("\nEmployee List:");
          while (resultSet.next()) {
              int id = resultSet.getInt("id");
              String name = resultSet.getString("name");
              String department = resultSet.getString("department");
              double salary = resultSet.getDouble("salary");
              System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
          }
      } catch (SQLException e) {
          System.out.println("Error fetching employees: " + e.getMessage());
      }
  }
}


