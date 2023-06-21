package cs3500.pa05.model;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Represents a week.
 */
public class Week {

  private String title;
  private Day[] days;
  private ObservableList<Task> taskQueue;
  private ObservableList<Theme> themes;
  private int currentTheme;
  private String notes;
  private int maxEvents;
  private int maxTasks;
  private StringProperty weeklyOverview;

  public Week(String title, Day[] days, List<Theme> themes,
              int theme, String notes, int maxEvents, int maxTasks) {
    this.title = title;
    this.days = days;
    this.taskQueue = FXCollections.observableArrayList();
    this.themes = FXCollections.observableList(themes);
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
    this.taskQueue = FXCollections.observableList(newWeek.getTaskQueue());
    this.themes = newWeek.getThemes();
    this.currentTheme = newWeek.getCurrentTheme();
    this.notes = newWeek.getNotes();;
    this.maxEvents = newWeek.getMaxEvents();
    this.maxTasks = newWeek.getMaxEvents();
  }

  public StringProperty getWeeklyOverview() {
    int totalEvents = 0;
    int totalTasks = 0;
    int completedTasks = 0;

    for (Day d : days) {
      totalEvents = totalEvents + d.getEvents().size();
      totalTasks = totalTasks + d.getTasks().size();
    }

    for (Day day : days) {
      List<Task> allTasks = day.getTasks();
      for (Task t : allTasks) {
        if (t.getComplete()) {
          completedTasks++;
        }
      }
    }

    double percentDone = completedTasks / totalTasks;
    percentDone = percentDone * 100;
    Math.floor(percentDone);
    int percentage = (int) percentDone;

    String overview = "Total Events: " + totalEvents + "\n"
        + "Total Tasks: " + totalTasks + "\n"
        + "Percent Completed: " + percentage;

    weeklyOverview = new SimpleStringProperty(overview);

    return weeklyOverview;
  }
}
