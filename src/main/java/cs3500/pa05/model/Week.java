package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a week.
 */
public class Week {

  public String title;
  public Day[] days;
  public ObservableList<Task> taskQueue;
  public ObservableList<Theme> themes;
  public int currentTheme;
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
  public Week(String title, Day[] days, List<Task> taskQueue, List<Theme> themes,
              int theme, String notes, int maxEvents, int maxTasks) {
    this.title = title;
    this.days = days;
    this.themes = FXCollections.observableArrayList(themes);
    this.taskQueue = FXCollections.observableArrayList(taskQueue);
    this.currentTheme = theme;
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

  public Week(String title, int theme) {
    this.title = title;
    this.days = initDays();
    this.taskQueue = FXCollections.observableArrayList();
    this.themes = FXCollections.observableList(new Theme.ThemeBuilder().defaultTheme());
    this.currentTheme = theme;
    this.notes = "";
    this.maxEvents = 3;
    this.maxTasks = 3;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
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

  public ObservableList<Task> getTaskQueue() {
    return this.taskQueue;
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
    return this.themes.get(currentTheme);
  }

  public int getMaxEvents() {
    return this.maxEvents;
  }

  public int getMaxTasks() {
    return this.maxTasks;
  }

  public void updateTheme(int theme) {
    this.currentTheme = theme;
  }

  public int getCurrentTheme() {
    return this.currentTheme;
  }

  public ObservableList<Theme> getThemes() {
    return this.themes;
  }

  public void update(Week newWeek) {
    this.title = newWeek.getTitle();
    for (int i = 0; i < 7; i++) {
      this.days[i] = newWeek.getDay(i);
    }
    this.taskQueue = FXCollections.observableArrayList(newWeek.getTaskQueue());
    this.themes = newWeek.getThemes();
    this.currentTheme = newWeek.getCurrentTheme();
    this.notes = newWeek.getNotes();;
    this.maxEvents = newWeek.getMaxEvents();
    this.maxTasks = newWeek.getMaxEvents();
  }
}
