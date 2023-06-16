package cs3500.pa05;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Theme;
import cs3500.pa05.viewer.Viewer;
import cs3500.pa05.viewer.WeekView;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represents a driver for the journal.
 */
public class Driver extends Application {
  @Override
  public void start(Stage stage) {
    Theme theme = new Theme(new Color(1, 1, 1, 1),
        new Color(0, 0, 0, 1), "Arial");
    Week week = new Week("Best Week", new Day[7], new ArrayList<>(), theme);
    Controller controller = new JournalController(week);
    Viewer viewer = new WeekView(controller);
    try {
      stage.setScene(viewer.load());
      controller.run();
      stage.show();
    } catch (IllegalStateException e) {
      System.err.println("Unable to load GUI.");
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
