package cs3500.pa05.model;

import java.util.List;
import javafx.scene.paint.Color;

/**
 * Represents a week.
 */
public class Week {

  public String title;
  public Day[] days;
  public List<Task> taskQueue;
  public Theme theme;

  /**
   * Constructs a week.
   *
   * @param title     the title of the week
   * @param days      the days of the week
   * @param taskQueue the task queue
   * @param theme     the theme of the week
   */
  public Week(String title, Day[] days, List<Task> taskQueue, Theme theme) {
    this.title = title;
    this.days = days;
    this.taskQueue = taskQueue;
    this.theme = theme;
  }

  /**
   * Sets the title of the week.
   *
   * @param title the title of the week
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the title of the week.
   *
   * @return the title of the week
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Gets the day
   *
   * @param day the day of the week
   * @return the day
   */
  public Day getDay(int day) {
    return this.days[day];
  }

  /**
   * Gets the Theme
   *
   * @return the theme of the week
   */
  public Theme getTheme() {
    return this.theme;
  }


}
