package com.db;

import com.db.model.Abonent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDirectoryTest {
  private PhoneDirectory phoneDirectory;

  @BeforeEach
  public void setUp() {
    phoneDirectory = new PhoneDirectory();
  }

  @Test
  void testFindAbonentExistingPhoneNumber() {
    String phoneNumber = "123-456-7890";
    Abonent result = phoneDirectory.findAbonent(phoneNumber);

    assertNotNull(result);
    assertEquals("Іванов", result.lastName());
    assertEquals("Іван", result.firstName());
    assertEquals("Іванович", result.middleName());
    assertEquals("Київ, вул. Хрещатик, 1", result.address());
  }

  @Test
  void testFindAbonentNonExistingPhoneNumber() {
    String phoneNumber = "999-999-9999";
    Abonent result = phoneDirectory.findAbonent(phoneNumber);

    assertNull(result);
  }

  @Test
  void testFindAbonentEmptyPhoneNumber() {
    String phoneNumber = "";
    Abonent result = phoneDirectory.findAbonent(phoneNumber);

    assertNull(result);
  }

  @Test
  void testFindAbonentPhoneNumberWithExtraSpaces() {
    String phoneNumber = " 123-456-7890 ";
    Abonent result = phoneDirectory.findAbonent(phoneNumber.trim());

    assertNotNull(result);
    assertEquals("Іванов", result.lastName());
  }
}
