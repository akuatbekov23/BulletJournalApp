package cs3500.pa05.model;

/**
 * Represents a task.
 */
public class Task {

  public String name;
  public String description;
  public String day;
  public Boolean complete;

  /**
   * Constructs a task.
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @param day         the day of the task
   * @param complete    the completion status of the task
   */
  public Task(String name, String description, String day, Boolean complete) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.complete = complete;
  }

  public void markComplete() {
    this.complete = true;
  }

}
