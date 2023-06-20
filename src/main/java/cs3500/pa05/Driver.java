package cs3500.pa05;

import static cs3500.pa05.model.Theme.THEME_1_IMAGES;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents a driver for the journal.
 */
public class Driver extends Application {
  @Override
  public void start(Stage stage) {
    Theme theme = new Theme(Color.rgb(255, 255, 255),
         Color.rgb(0, 0, 0), "Arial", THEME_1_IMAGES);
    Task task1 = new Task("OOD HW", DayEnum.SUNDAY);
    Task task2 = new Task("OOD HW 2", DayEnum.MONDAY);
    Events events1 = new Events("OOD Lecture", "",
        DayEnum.SUNDAY, LocalTime.now(), LocalTime.now());
    Day[] days = new Day[] {new Day(DayEnum.SUNDAY, new ArrayList<>(List.of(events1)),
        new ArrayList<>(List.of(task1))), new Day(DayEnum.MONDAY,
        new ArrayList<>(), new ArrayList<>(List.of(task2))),
        new Day(DayEnum.TUESDAY), new Day(DayEnum.WEDNESDAY), new Day(DayEnum.THURSDAY),
        new Day(DayEnum.FRIDAY), new Day(DayEnum.SATURDAY)};

    Week week = new Week("Week", days, new ArrayList<>(), theme, "Test", 3, 3);
//    Week week = new Week("Best Week", theme);
    Controller controller = new JournalController(week);
    Viewer viewer = new WeekView(controller);
    Viewer intro = new IntroView();
    try {
      stage.setScene(intro.load());
      Thread.sleep(2000);
      stage.setScene(viewer.load());
      stage.setTitle("Journal");
      stage.setResizable(false);
      controller.run();
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load GUI.");
    } catch (InterruptedException e) {
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
