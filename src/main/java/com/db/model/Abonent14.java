package com.db.model;

public record Abonent14(String lastName,
                        String firstName,
                        String patronymic,
                        String address) {

  @Override
  public String toString() {
    return lastName + " " + firstName + " " + patronymic + ", Address: " + address;
  }
}
