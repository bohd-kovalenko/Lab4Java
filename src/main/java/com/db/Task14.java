package com.db;

public class Task14 {

  public static void main(String[] args) {
    LibraryNetwork libraryNetwork = new LibraryNetwork();
    System.out.println("Abonents before deletion");
    libraryNetwork.displayAllAbonents();
    libraryNetwork.deleteAbonent(112233445);
    System.out.println("Abonents after deletion");
    libraryNetwork.displayAllAbonents();
    libraryNetwork.displayAbonentsSortedBySurname();
  }
}
