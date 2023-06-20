package cs3500.pa05.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
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
  public String notes;
  private int maxEvents;
  private int maxTasks;

  /**
   * Constructs a week.
   *
   * @param title     the title of the week
   * @param days      the days of the week
   * @param taskQueue the task queue
   * @param theme     the theme of the week
   */
  public Week(String title, Day[] days, List<Task> taskQueue, Theme theme, String notes,
              int maxEvents, int maxTasks) {
    this.title = title;
    this.days = days;
    this.taskQueue = new ArrayList<>();
    this.theme = theme;
    this.notes = notes;
    this.maxEvents = maxEvents;
    this.maxTasks = maxTasks;

    for (Day day: days) {
      List<Task> tasks = day.getTasks();
      for (Task t : tasks) {
        addTaskQueue(t);
      }
    }
  }

  public Week(String title, Theme theme) {
    this.title = title;
    this.days = initDays();
    this.taskQueue = new ArrayList<>();
    this.theme = theme;
    this.notes = "";
    this.maxEvents = 3;
    this.maxTasks = 3;
  }

  private Day[] initDays() {
    Day[] days = new Day[7];
    DayEnum[] dayEnums = new DayEnum[] {DayEnum.SUNDAY, DayEnum.MONDAY, DayEnum.TUESDAY,
        DayEnum.WEDNESDAY, DayEnum.THURSDAY, DayEnum.FRIDAY, DayEnum.SATURDAY};
    for (int i = 0; i < dayEnums.length; i++) {
      days[i] = new Day(dayEnums[i]);
    }
    return days;
  }

  public void addTaskQueue(Task task) {
    this.taskQueue.add(task);
  }

  public List<Task> getTaskQueue() {
    return taskQueue;
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

  public String getNotes() {
    return this.notes;
  }

  public void updateNotes(String notes) {
    this.notes = notes;
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

  public int getMaxEvents() {
    return this.maxEvents;
  }

  public int getMaxTasks() {
    return this.maxTasks;
  }

  public void updateTheme(Theme theme) {
    this.theme = theme;
  }

  public void update(Week newWeek) {
    this.title = newWeek.getTitle();
    for (int i = 0; i < 7; i++) {
      this.days[i] = newWeek.getDay(i);
    }
    this.taskQueue = newWeek.getTaskQueue();
    this.theme = newWeek.getTheme();
    this.notes = newWeek.getNotes();;
    this.maxEvents = newWeek.getMaxEvents();
    this.maxTasks = newWeek.getMaxEvents();
  }
}
