package com.db.model;

public record AddressValue(String city, String street, String houseNumber, Integer apartmentNumber) {

  @Override
  public String toString() {
    return city + ", " + street + " " + houseNumber + (apartmentNumber > 0 ? ", apt " + apartmentNumber : "");
  }
}
