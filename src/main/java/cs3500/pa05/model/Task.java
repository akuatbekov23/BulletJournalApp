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

  @Override
  public String toString() {
    return this.name + ", Completed: " + this.complete;
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

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Task t)) {
      return false;
    }

    return this.name.equals(t.name) && this.description.equals(t.description)
        && this.getDay().equals(t.getDay()) && this.complete == t.complete;
  }

  @Override
  public int hashCode() {
    return this.name.hashCode() * 1000 + this.description.hashCode() * 100
        + this.day.hashCode() * 10 + this.complete.hashCode();
  }
}
