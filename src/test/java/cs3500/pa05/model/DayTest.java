package cs3500.pa05.viewer.model;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Day class.
 */
public class DayTest {

  private Day day;

  @BeforeEach
  void setUp() {
    day = new Day(DayEnum.MONDAY);
  }

  @Test
  void addEvent() {
    // Test adding an event
    Events
        event = new Events("Meeting", "Team meeting",
        DayEnum.MONDAY, LocalTime.of(9, 0), LocalTime.of(1, 0));
    day.addEvent(event);

    List<Events> events = day.getEvents();
    assertTrue(events.contains(event));
  }

  @Test
  void addTask() {
    // Test adding a task
    Task task = new Task("Homework", "Complete assignment", DayEnum.MONDAY, false);
    day.addTask(task);

    List<Task> tasks = day.getTasks();
    assertTrue(tasks.contains(task));
  }

  @Test
  void getDay() {
    // Test getting the day
    assertEquals("MONDAY", day.getDay());
  }

  @Test
  void getEvents() {
    // Test getting events when there are no events
    List<Events> events = day.getEvents();
    assertNotNull(events);
    assertTrue(events.isEmpty());
  }

  @Test
  void getTasks() {
    // Test getting tasks when there are no tasks
    List<Task> tasks = day.getTasks();
    assertNotNull(tasks);
    assertTrue(tasks.isEmpty());
  }

  @Test
  void removeIfFound_TaskFound_RemovesTask() {
    // Test removing a task that exists
    Task task1 = new Task("Task 1", DayEnum.MONDAY);
    Task task2 = new Task("Task 2", DayEnum.MONDAY);
    Task task3 = new Task("Task 3", DayEnum.MONDAY);

    day.addTask(task1);
    day.addTask(task2);
    day.addTask(task3);

    day.removeIfFound(task2);

    List<Task> tasks = day.getTasks();
    assertEquals(2, tasks.size());
    assertTrue(tasks.contains(task1));
    assertFalse(tasks.contains(task2));
    assertTrue(tasks.contains(task3));
  }

  @Test
  void removeIfFound_TaskNotFound_NoChanges() {
    // Test removing a task that does not exist
    Task task1 = new Task("Task 1", DayEnum.MONDAY);
    Task task2 = new Task("Task 2", DayEnum.MONDAY);
    Task task3 = new Task("Task 3", DayEnum.MONDAY);

    day.addTask(task1);
    day.addTask(task3);

    day.removeIfFound(task2);

    List<Task> tasks = day.getTasks();
    assertEquals(2, tasks.size());
    assertTrue(tasks.contains(task1));
    assertFalse(tasks.contains(task2));
    assertTrue(tasks.contains(task3));
  }

  @Test
  void removeIfFound_EventFound_RemovesEvent() {
    // Test removing an event that exists
    Events event1 = new Events("Event 1", "Description 1",
        DayEnum.MONDAY, LocalTime.of(9, 0), LocalTime.of(1, 0));
    Events event2 = new Events("Event 2", "Description 2",
        DayEnum.MONDAY, LocalTime.of(10, 0), LocalTime.of(2, 0));
    Events event3 = new Events("Event 3", "Description 3",
        DayEnum.MONDAY, LocalTime.of(13, 0), LocalTime.of(1, 0));

    day.addEvent(event1);
    day.addEvent(event2);
    day.addEvent(event3);

    day.removeIfFound(event2);

    List<Events> events = day.getEvents();
    assertEquals(2, events.size());
    assertTrue(events.contains(event1));
    assertFalse(events.contains(event2));
    assertTrue(events.contains(event3));
  }

  @Test
  void removeIfFound_EventNotFound_NoChanges() {
    // Test removing an event that does not exist
    Events event1 = new Events("Event 1", "Description 1",
        DayEnum.MONDAY, LocalTime.of(9, 0), LocalTime.of(1, 0));
    Events event2 = new Events("Event 2", "Description 2",
        DayEnum.MONDAY, LocalTime.of(10, 0), LocalTime.of(2, 0));
    Events event3 = new Events("Event 3", "Description 3",
        DayEnum.MONDAY, LocalTime.of(13, 0), LocalTime.of(1, 0));

    day.addEvent(event1);
    day.addEvent(event3);

    day.removeIfFound(event2);

    List<Events> events = day.getEvents();
    assertEquals(2, events.size());
    assertTrue(events.contains(event1));
    assertFalse(events.contains(event2));
    assertTrue(events.contains(event3));
  }
}
