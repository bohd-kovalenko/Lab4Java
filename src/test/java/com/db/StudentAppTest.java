package com.db;

import com.db.model.BirthDate;
import com.db.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentAppTest {

  private StudentApp studentApp;

  @BeforeEach
  public void setUp() {
    studentApp = new StudentApp();
  }

  @Test
  void testInitialDataPopulation() {
    assertEquals(5, studentApp.getStudents().size(), "Initial student list should contain 5 students.");
    Student firstStudent = studentApp.getStudents().get(0);
    assertEquals("John Doe", firstStudent.fullName());
    assertEquals("Group A", firstStudent.groupName());
    assertEquals(3.5f, firstStudent.averageGrade(), 0.01f);

    BirthDate birthDate = firstStudent.birthDate();
    assertEquals(2001, birthDate.year());
    assertEquals(5, birthDate.month());
    assertEquals(15, birthDate.day());
  }

  @Test
  void testAddStudent() {
    int initialSize = studentApp.getStudents().size();
    BirthDate birthDate = new BirthDate(2004, 8, 10);
    Student newStudent = new Student("Eve Adams", "Group F", birthDate, 3.9f);
    studentApp.getStudents().add(newStudent);

    assertEquals(initialSize + 1, studentApp.getStudents().size());

    Student lastStudent = studentApp.getStudents().get(studentApp.getStudents().size() - 1);
    assertEquals("Eve Adams", lastStudent.fullName());
    assertEquals("Group F", lastStudent.groupName());
    assertEquals(3.9f, lastStudent.averageGrade(), 0.01f);
  }

  @Test
  void testDeleteStudent() {
    int initialSize = studentApp.getStudents().size();
    studentApp.getStudents().remove(0);

    assertEquals(initialSize - 1, studentApp.getStudents().size());

    Student newFirstStudent = studentApp.getStudents().get(0);
    assertNotEquals("John Doe", newFirstStudent.fullName());
  }

  @Test
  void testDeleteInvalidIndex() {
    int initialSize = studentApp.getStudents().size();
    try {
      studentApp.getStudents().remove(initialSize + 1);
      fail("Exception should have been thrown for invalid index.");
    } catch (IndexOutOfBoundsException e) {
    }

    assertEquals(initialSize, studentApp.getStudents().size());
  }
}
