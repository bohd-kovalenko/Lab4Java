package com.db;

import com.db.model.AddressValue;

public class Task8 {
  public static void main(String[] args) {
    QueueManager manager = new QueueManager();
    manager.addPerson(new QueuePerson("Smith", "John", "A", new AddressValue("New York", "5th Ave", "10", 101), 3));
    manager.addPerson(new QueuePerson("Doe", "Jane", "B", new AddressValue("Los Angeles", "Sunset Blvd", "20", 0), 1));
    manager.addPerson(new QueuePerson("Brown", "Charlie", "C", new AddressValue("Chicago", "Lake St", "30", 202), 2));
    manager.addPerson(new QueuePerson("Johnson", "Emily", "D", new AddressValue("Houston", "Main St", "40", 0), 5));
    manager.addPerson(new QueuePerson("Taylor", "Chris", "E", new AddressValue("Phoenix", "Broadway", "50", 305), 4));
    System.out.println("Initial Queue:");
    manager.displayQueue();
    System.out.println("\nChanging priority of 'Doe' to 4:");
    manager.changePriority("Doe", 4);
    manager.displayQueue();
  }
}
