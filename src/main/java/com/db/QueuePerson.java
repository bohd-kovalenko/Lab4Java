package com.db;

import com.db.model.AddressValue;

public record QueuePerson(String lastName,
                          String firstName,
                          String middleName,
                          AddressValue address,
                          int priority) {

  @Override
  public String toString() {
    return lastName + " " + firstName + " " + middleName + ", Address: " + address + ", Priority: " + priority;
  }
}
