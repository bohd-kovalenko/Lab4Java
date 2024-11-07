package com.db;

import com.db.model.BirthDate;
import com.db.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
  private final ArrayList<Student> students;

  public StudentApp() {
    students = new ArrayList<>();
    populateInitialData();
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  public void populateInitialData() {
    students.add(new Student("John Doe",
        "Group A",
        new BirthDate(2001, 5, 15),
        3.5f));
    students.add(new Student("Jane Smith",
        "Group B",
        new BirthDate(2000, 7, 20),
        4.0f));
    students.add(new Student("Alice Johnson",
        "Group C",
        new BirthDate(2002, 3, 12),
        3.7f));
    students.add(new Student("Bob Brown",
        "Group D",
        new BirthDate(1999, 9, 5),
        3.2f));
    students.add(new Student("Carol White",
        "Group E",
        new BirthDate(2003, 1, 25),
        3.8f));
  }

  public void viewStudents() {
    if (students.isEmpty()) {
      System.out.println("No students in the list.");
    } else {
      for (int i = 0; i < students.size(); i++) {
        System.out.println((i + 1) + ". " + students.get(i));
      }
    }
  }

  public void addStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Full Name: ");
    String fullName = scanner.nextLine();
    System.out.print("Enter Group Name: ");
    String groupName = scanner.nextLine();
    System.out.print("Enter Birth Year: ");
    int year = scanner.nextInt();
    System.out.print("Enter Birth Month: ");
    int month = scanner.nextInt();
    System.out.print("Enter Birth Day: ");
    int day = scanner.nextInt();
    System.out.print("Enter Average Grade: ");
    float averageGrade = scanner.nextFloat();
    BirthDate birthDate = new BirthDate(year, month, day);
    students.add(new Student(fullName, groupName, birthDate, averageGrade));
    System.out.println("Student added successfully.");
  }

  public void deleteStudent() {
    Scanner scanner = new Scanner(System.in);
    viewStudents();
    System.out.print("Enter the student number to delete: ");
    int index = scanner.nextInt() - 1;
    if (index >= 0 && index < students.size()) {
      students.remove(index);
      System.out.println("Student deleted successfully.");
    } else {
      System.out.println("Invalid student number.");
    }
  }

  public void displayMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\nStudent Management App");
      System.out.println("1. View Students");
      System.out.println("2. Add Student");
      System.out.println("3. Delete Student");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> viewStudents();
        case 2 -> addStudent();
        case 3 -> deleteStudent();
        case 4 -> {
          System.out.println("Exiting the application.");
          return;
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }

}
