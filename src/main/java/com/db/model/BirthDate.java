package com.db.model;

public record BirthDate(int year, int month, int day) {

  @Override
  public String toString() {
    return day + "/" + month + "/" + year;
  }
}
