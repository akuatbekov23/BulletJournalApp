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
  public int maxEvent;
  public int maxTask;
  public List<Events> events;
  public List<Task> tasks;

  /**
   * Constructs a day.
   *
   * @param day      the day of the week
   * @param maxEvent the maximum number of events
   * @param maxTask  the maximum number of tasks
   * @param events   the list of events
   * @param tasks    the list of tasks
   */
  public Day(DayEnum day, int maxEvent, int maxTask, List<Events> events, List<Task> tasks) {
    this.day = day;
    this.maxEvent = maxEvent;
    this.maxTask = maxTask;
    this.events = events;
    this.tasks = tasks;
  }

  public Day(DayEnum day) {
    this.day = day;
    this.maxEvent = 3;
    this.maxTask = 3;
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  /**
   * Updates the maximum number of events.
   *
   * @param maxEvent the maximum number of events
   */
  public void updateMaxEvent(int maxEvent) {
    this.maxEvent = maxEvent;
  }

  /**
   * Updates the maximum number of tasks.
   *
   * @param maxTask the maximum number of tasks
   */
  public void updateMaxTask(int maxTask) {
    this.maxTask = maxTask;
  }

  /**
   * returns the Maximum number of events.
   */
  public int getMaxEvent() {
    return this.maxEvent;
  }

  /**
   * returns the Maximum number of tasks.
   */
  public int getMaxTask() {
    return this.maxTask;
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
