package com.db;

import com.db.model.Abonent14;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LibraryNetwork {
  private final HashMap<Integer, Abonent14> abonents;

  public LibraryNetwork() {
    abonents = new HashMap<>();
    abonents.put(123456789, new Abonent14("Smith",
        "John",
        "A.",
        "123 Main St"));
    abonents.put(987654321, new Abonent14("Doe",
        "Jane",
        "B.",
        "456 Elm St"));
    abonents.put(112233445, new Abonent14("Johnson",
        "Robert",
        "C.",
        "789 Oak St"));
    abonents.put(556677889, new Abonent14("Brown",
        "Alice",
        "D.",
        "101 Maple Ave"));
    abonents.put(667788990, new Abonent14("Davis",
        "Michael",
        "E.",
        "202 Birch Rd"));
  }

  public HashMap<Integer, Abonent14> getAbonents() {
    return abonents;
  }

  public void deleteAbonent(Integer phoneNumber) {
    if (abonents.containsKey(phoneNumber)) {
      abonents.remove(phoneNumber);
      System.out.println("Abonent with phone number " + phoneNumber + " removed.");
    } else {
      System.out.println("Abonent with phone number " + phoneNumber + " not found.");
    }
  }

  public SortedMap<String, Abonent14> getAbonentsSortedBySurname() {
    TreeMap<String, Abonent14> sortedAbonents = new TreeMap<>();
    for (Map.Entry<Integer, Abonent14> entry : abonents.entrySet()) {
      sortedAbonents.put(entry.getValue().lastName(), entry.getValue());
    }
    return sortedAbonents;
  }

  public void displayAbonentsSortedBySurname() {
    SortedMap<String, Abonent14> sortedAbonents = getAbonentsSortedBySurname();
    System.out.println("Abonents sorted by surname:");
    for (Map.Entry<String, Abonent14> entry : sortedAbonents.entrySet()) {
      System.out.println(entry.getValue());
    }
  }

  public void displayAllAbonents() {
    System.out.println("List of all abonents:");
    for (Map.Entry<Integer, Abonent14> entry : abonents.entrySet()) {
      System.out.println("Phone: " + entry.getKey() + ", " + entry.getValue());
    }
  }
}
