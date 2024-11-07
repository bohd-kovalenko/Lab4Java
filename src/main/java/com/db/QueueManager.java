package com.db;

import java.util.LinkedList;
import java.util.List;

public class QueueManager {
  private final List<QueuePerson> queue;

  public QueueManager() {
    this.queue = new LinkedList<>();
  }

  public List<QueuePerson> getQueue() {
    return queue;
  }

  public void addPerson(QueuePerson person) {
    int index = 0;
    for (QueuePerson p : queue) {
      if (person.priority() < p.priority()) {
        break;
      }
      index++;
    }
    queue.add(index, person);
  }

  public void changePriority(String lastName, int newPriority) {
    QueuePerson person = null;
    for (QueuePerson p : queue) {
      if (p.toString().contains(lastName)) {
        person = p;
        break;
      }
    }
    if (person != null) {
      queue.remove(person);
      person = new QueuePerson(person.lastName(),
          person.firstName(),
          person.middleName(),
          person.address(),
          newPriority);
      addPerson(person);
    }
  }

  public void displayQueue() {
    for (QueuePerson p : queue) {
      System.out.println(p);
    }
  }
}
