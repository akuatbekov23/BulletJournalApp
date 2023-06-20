package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.event.Event;

/**
 * Represents a day in the week.
 */
public class Day {

  public DayEnum day;
  public List<Events> events;
  public List<Task> tasks;

  /**
   * Constructs a day.
   *
   * @param day      the day of the week
   * @param events   the list of events
   * @param tasks    the list of tasks
   */
  public Day(DayEnum day, List<Events> events, List<Task> tasks) {
    this.day = day;
    this.events = events;
    this.tasks = tasks;
  }

  public Day(DayEnum day) {
    this.day = day;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * adds an events to the list of events.
   */
  public void addEvent(Events events) {
    this.events.add(events);
  }

  /**
   * adds a task to the list of tasks.
   */
  public void addTask(Task task) {
    this.tasks.add(task);
  }

  /**
   * get Day
   *
   * @return the day
   */
  public String getDay() {
    return this.day.toString();
  }

  /**
   * get Events
   *
   * @return the list of events
   */
  public List<Events> getEvents() {
    return this.events;
  }

  /**
   * get Tasks
   *
   * @return the list of tasks
   */
  public List<Task> getTasks() {
    return this.tasks;
  }

  public void removeIfFound(Task t) {
    this.tasks.removeIf(task -> task == t);
  }

  public void removeIfFound(Events e) {
    this.events.removeIf(ev -> ev == e);
  }
}
