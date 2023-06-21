package cs3500.pa05.model;

/**
 * Represents a task.
 */
public class Task {

  public String name;
  public String description;
  public DayEnum day;
  public Boolean complete;

  public Task(String name, String description, DayEnum day, Boolean complete) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.complete = complete;
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

  public void changeComplete() {
    this.complete = !this.complete;
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
