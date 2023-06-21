package cs3500.pa05;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Theme;
import cs3500.pa05.viewer.IntroView;
import cs3500.pa05.viewer.Viewer;
import cs3500.pa05.viewer.WeekView;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents a driver for the journal.
 */
public class Driver extends Application {
  @Override
  public void start(Stage stage) {
    Task task1 = new Task("OOD HW", DayEnum.SUNDAY);
    Task task2 = new Task("OOD HW 2", DayEnum.MONDAY);
    Events events1 = new Events("OOD Lecture", "",
        DayEnum.SUNDAY, LocalTime.now(), LocalTime.now());
    Day[] days = new Day[] {new Day(DayEnum.SUNDAY, new ArrayList<>(List.of(events1)),
        new ArrayList<>(List.of(task1))), new Day(DayEnum.MONDAY,
        new ArrayList<>(), new ArrayList<>(List.of(task2))),
        new Day(DayEnum.TUESDAY), new Day(DayEnum.WEDNESDAY), new Day(DayEnum.THURSDAY),
        new Day(DayEnum.FRIDAY), new Day(DayEnum.SATURDAY)};
//    List<Day> days = new ArrayList<>();
//    days.add(new Day(DayEnum.SUNDAY, new ArrayList<>(List.of(events1)),
//        new ArrayList<>(List.of(task1))));
//    days.add(new Day(DayEnum.MONDAY, new ArrayList<>(), new ArrayList<>(List.of(task2))));
//    days.add(new Day(DayEnum.TUESDAY));
//    days.add(new Day(DayEnum.WEDNESDAY));
//    days.add(new Day(DayEnum.THURSDAY));
//    days.add(new Day(DayEnum.FRIDAY));
//    days.add(new Day(DayEnum.SATURDAY));
    Week week = new Week("Title", days,
        new ArrayList<>(new Theme.ThemeBuilder().defaultTheme()),
        0, "Test", 3, 3);
    Controller controller = new JournalController(week);
    Viewer viewer = new WeekView(controller);

    try {
      stage.setScene(viewer.load());
      stage.setTitle("Journal");
      stage.setResizable(false);
      controller.initialize();
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load GUI.");
    }
  }

  /**
   * Main Method
   * @param args cmd-line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}
