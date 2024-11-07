package com.db.model;

public record Abonent(String lastName, String firstName, String middleName, String address) {

  @Override
  public String toString() {
    return "Surname: " + lastName + ", name: " + firstName + ", middle name: " + middleName + ", address: " + address;
  }
}
