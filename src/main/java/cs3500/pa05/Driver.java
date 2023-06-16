package cs3500.pa05;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.viewer.Viewer;
import cs3500.pa05.viewer.WeekView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {
  @Override
  public void start(Stage stage) {
    Controller controller = new JournalController();
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
