package com.db;

import com.db.model.Abonent;

import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {
  private Map<String, Abonent> directory;

  public PhoneDirectory() {
    directory = new HashMap<>();
    initializeDirectory();
  }

  private void initializeDirectory() {
    directory.put("123-456-7890", new Abonent("Іванов", "Іван", "Іванович", "Київ, вул. Хрещатик, 1"));
    directory.put("098-765-4321", new Abonent("Петров", "Петро", "Петрович", "Львів, вул. Шевченка, 5"));
    directory.put("111-222-3333", new Abonent("Сидоренко", "Сидір", "Сидорович", "Одеса, вул. Дерибасівська, 10"));
    directory.put("222-333-4444", new Abonent("Коваленко", "Олексій", "Олексійович", "Харків, вул. Сумська, 15"));
    directory.put("333-444-5555", new Abonent("Кузьменко", "Олена", "Миколаївна", "Дніпро, вул. Центральна, 20"));
  }

  public Abonent findAbonent(String phoneNumber) {
    return directory.get(phoneNumber);
  }
}
