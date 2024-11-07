package com.db;

import com.db.model.AddressValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueManagerTest {
  private QueueManager manager;

  @BeforeEach
  public void setUp() {
    manager = new QueueManager();
  }

  @Test
  void testAddPerson() {
    QueuePerson person1 = new QueuePerson("Smith",
        "John",
        "A",
        new AddressValue("New York", "5th Ave", "10", 101),
        3);
    QueuePerson person2 = new QueuePerson("Doe",
        "Jane",
        "B",
        new AddressValue("Los Angeles", "Sunset Blvd", "20", 0),
        1);
    QueuePerson person3 = new QueuePerson("Brown",
        "Charlie",
        "C",
        new AddressValue("Chicago", "Lake St", "30", 202),
        2);

    manager.addPerson(person1);
    manager.addPerson(person2);
    manager.addPerson(person3);

    assertEquals(person2, manager.getQueue().get(0));
    assertEquals(person3, manager.getQueue().get(1));
    assertEquals(person1, manager.getQueue().get(2));
  }

  @Test
  void testChangePriority() {
    QueuePerson person1 = new QueuePerson("Smith",
        "John",
        "A",
        new AddressValue("New York", "5th Ave", "10", 101),
        3);
    QueuePerson person2 = new QueuePerson("Doe",
        "Jane",
        "B",
        new AddressValue("Los Angeles", "Sunset Blvd", "20", 0),
        1);
    QueuePerson person3 = new QueuePerson("Brown",
        "Charlie",
        "C",
        new AddressValue("Chicago", "Lake St", "30", 202),
        2);
    QueuePerson person2WithChangedPriority = new QueuePerson(person2.lastName(),
        person2.firstName(),
        person2.middleName(),
        person2.address(),
        4);

    manager.addPerson(person1);
    manager.addPerson(person2);
    manager.addPerson(person3);
    manager.changePriority("Doe", 4);

    assertEquals(person3, manager.getQueue().get(0));
    assertEquals(person1, manager.getQueue().get(1));
    assertEquals(person2WithChangedPriority, manager.getQueue().get(2));
  }
}
