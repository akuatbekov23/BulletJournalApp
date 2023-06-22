package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Task class.
 */
public class TaskTest {

  private Task task;

  @BeforeEach
  void setUp() {
    task = new Task("Homework", "Complete math exercises",
        DayEnum.TUESDAY, false);
  }

  @Test
  void testToString() {
    // Test converting the task to a string representation
    assertEquals("Homework, Completed: false", task.toString());
  }

  @Test
  void changeComplete() {
    // Test changing the completion status of the task
    assertFalse(task.getComplete());
    task.changeComplete();
    assertTrue(task.getComplete());
    task.changeComplete();
    assertFalse(task.getComplete());
  }

  @Test
  void getName() {
    // Test getting the task's name
    assertEquals("Homework", task.getName());
  }

  @Test
  void getDay() {
    // Test getting the task's day
    assertEquals("TUESDAY", task.getDay());
  }

  @Test
  void getDescription() {
    // Test getting the task's description
    assertEquals("Complete math exercises", task.getDescription());
  }

  @Test
  void getComplete() {
    // Test getting the task's completion status
    assertFalse(task.getComplete());
  }

  @Test
  void testEquals() {
    // Test equality between two tasks
    Task task1 = new Task("Homework", "Complete math exercises",
        DayEnum.TUESDAY, false);
    Task task2 = new Task("Project", "Finish project report",
        DayEnum.WEDNESDAY, true);
    Task task21 = new Task("Project", "Finish project report",
        DayEnum.MONDAY, true);
    Task task22 = new Task("Project", "Finish project report",
        DayEnum.WEDNESDAY, false);
    Task task23 = new Task("Projects", "Finish project report",
        DayEnum.WEDNESDAY, true);
    Task task24 = new Task("Project", "Finish project reports",
        DayEnum.WEDNESDAY, true);
    Task task3 = new Task("Project", "Finish project report",
        DayEnum.WEDNESDAY, true);
    Task task4 = new Task("Project", "Finish project report",
        DayEnum.THURSDAY, true);
    Task task5 = new Task("Project", "Finish project report",
        DayEnum.FRIDAY, true);
    Task task6 = new Task("Project", "Finish project report",
        DayEnum.SATURDAY, true);
    Task task7 = new Task("Project", "Finish project report",
        DayEnum.SUNDAY, false);
    Task task8 = new Task("Project", "Finish project report",
        DayEnum.MONDAY, true);
    assertTrue(task2.equals(task3));
    assertFalse(task2.equals("Test"));
    assertFalse(task2.equals(task21));
    assertFalse(task2.equals(task22));
    assertFalse(task2.equals(task23));
    assertFalse(task2.equals(task24));

    assertEquals(995431151, task2.hashCode());
    assertEquals(995431151, task3.hashCode());
    assertEquals(995431161, task4.hashCode());
    assertEquals(995431171, task5.hashCode());
    assertEquals(995431181, task6.hashCode());
    assertEquals(995431120, task7.hashCode());
    assertEquals(995431131, task8.hashCode());

    assertEquals(task, task1);
    assertNotEquals(task, task2);
    // Test equality with itself
    assertEquals(task, task);
    // Test equality with another task having the same values

    assertEquals(task1, task);
    // Test inequality with a task having a different name

    assertNotEquals(task2, task);

    // Test inequality with a task having a different completion status
    task2.changeComplete();
    assertNotEquals(task, task2);
    assertNotEquals(task2, task);
  }

  @Test
  void testHashCode() {
    // Test the hash code of the task
    Task task1 = new Task("Homework", "Complete math exercises",
        DayEnum.TUESDAY, false);

    assertEquals(task.hashCode(), task1.hashCode());
  }
}
