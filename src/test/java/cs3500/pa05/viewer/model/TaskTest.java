package cs3500.pa05.viewer.model;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Task;
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
    // Test equality with itself
    assertEquals(task, task);
    // Test equality with another task having the same values
    assertEquals(task, task1);
    assertEquals(task1, task);
    // Test inequality with a task having a different name
    assertNotEquals(task, task2);
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
