package com.czetsuyatech.tests.moatable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class ReverseList {
  int id;
  String name;
  Integer subtaskId;

  public ReverseList(int id, String name, Integer subtaskId) {

    this.id = id;
    this.name = name;
    this.subtaskId = subtaskId;
  }

  public static void main(String[] args) {

    ReverseList task1 = new ReverseList(1, "task1", 2);
    ReverseList task2 = new ReverseList(2, "task2", 4);
    ReverseList task3 = new ReverseList(3, "task3", null);
    ReverseList task4 = new ReverseList(4, "task4", 3);
    List<ReverseList> tasks = Arrays.asList(task1, task2, task3, task4);
    System.out.println(finishTask(2, tasks));
  }

  /**
   * Task(1, "task1", 2)
   * Task(2, "task2", 4)
   * Task(3, "task3", null)
   * Task(4, "task4", null)
   *
   * if input=1 --> ["task4", "task2", "task1"]
   * if input=3 --> ["task3"]
   * if there is no task with id = given input --> return an empty list
   * */
  public static List<String> finishTask(int id, List<ReverseList> tasks) {

    List<ReverseList> result = new ArrayList<>();
    // build the list
    buildTheList(result, id, tasks);

    // reverse the list
    Collections.reverse(result);

    result.forEach(e -> System.out.println(e.name));

    return null;
  }

  private static void buildTheList(List<ReverseList> result, int id, List<ReverseList> tasks) {

    Optional<ReverseList> current = tasks.stream().filter(e -> e.id == id)
        .findFirst();
    if (current.isPresent()) {
      ReverseList currentTask = current.get();
      result.add(currentTask);

      if (currentTask.subtaskId != null) {
        buildTheList(result, currentTask.subtaskId, tasks);
      }
    }
  }
}
