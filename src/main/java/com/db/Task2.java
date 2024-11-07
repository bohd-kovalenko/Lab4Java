package com.db;

import com.db.model.Abonent;

import java.util.Scanner;

public class Task2 {

  public static void main(String[] args) {
    PhoneDirectory phoneDirectory = new PhoneDirectory();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the phone number to search for the subscriber: ");
    String phoneNumber = scanner.nextLine();
    Abonent abonent = phoneDirectory.findAbonent(phoneNumber);
    if (abonent != null) {
      System.out.println("Subscriber information:");
      System.out.println(abonent);
    } else {
      System.out.println("No subscriber found with that phone number.");
    }
    scanner.close();
  }
}
