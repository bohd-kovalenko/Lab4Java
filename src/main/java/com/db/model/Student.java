package com.db.model;

public record Student(String fullName,
                      String groupName,
                      BirthDate birthDate,
                      float averageGrade) {

  @Override
  public String toString() {
    return "Name: " + fullName +
        ", Group: " + groupName +
        ", Birth Date: " + birthDate +
        ", Average Grade: " + averageGrade;
  }
}
