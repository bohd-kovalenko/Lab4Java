package com.db;

import com.db.model.Abonent14;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class LibraryNetworkTest {

  private LibraryNetwork libraryNetwork;

  @BeforeEach
  void setUp() {
    libraryNetwork = new LibraryNetwork();
  }

  @Test
  void testDeleteAbonent_ExistingPhoneNumber() {
    Integer phoneNumber = 123456789;
    assertTrue(libraryNetwork.getAbonents().containsKey(phoneNumber));

    libraryNetwork.deleteAbonent(phoneNumber);

    assertFalse(libraryNetwork.getAbonents().containsKey(phoneNumber));
  }

  @Test
  void testDeleteAbonent_NonExistingPhoneNumber() {
    Integer nonExistentPhoneNumber = 111111111;

    assertFalse(libraryNetwork.getAbonents().containsKey(nonExistentPhoneNumber));

    libraryNetwork.deleteAbonent(nonExistentPhoneNumber);

    assertFalse(libraryNetwork.getAbonents().containsKey(nonExistentPhoneNumber));
  }

  @Test
  void testDisplayAbonentsSortedBySurname() {
    SortedMap<String, Abonent14> sortedAbonents = libraryNetwork.getAbonentsSortedBySurname();

    String[] expectedOrder = {"Brown", "Davis", "Doe", "Johnson", "Smith"};
    int i = 0;
    for (String surname : sortedAbonents.keySet()) {
      assertEquals(expectedOrder[i], surname);
      i++;
    }
  }

  @Test
  void testInitialAbonentsCount() {
    assertEquals(5, libraryNetwork.getAbonents().size());
  }
}
