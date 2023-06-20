package cs3500.pa05.model;

import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;

/**
 * Represents a task.
 */
public class Task {

  public String name;
  public String description;
  public DayEnum day;
  public Boolean complete;

  /**
   * Constructs a task.
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @param day         the day of the task
   */
  public Task(String name, String description, DayEnum day, Boolean complete) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.complete = false;
  }

  public Task(String name, DayEnum day) {
    this.name = name;
    this.description = "";
    this.day = day;
    this.complete = false;
  }

  public void markComplete() {
    this.complete = true;
  }

  public String getName() {
    return this.name;
  }

  public String getDay() {
    return this.day.toString();
  }

  public String getDescription() {
    return this.description;
  }

  public Boolean getComplete() {
    return this.complete;
  }
}
