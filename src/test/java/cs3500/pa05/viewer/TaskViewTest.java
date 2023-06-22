package cs3500.pa05.viewer;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.JournalController;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class TaskViewTest {
//  private TaskView taskView;
//
//  @Start
//  private void start(Stage stage) {
//    Task task = new Task("Test", DayEnum.MONDAY);
//    ObservableList<Task> taskQueue = FXCollections.observableArrayList(task);
//    Week week = new Week("Week", 0);
//    Controller controller = new JournalController(week);
//    Day day = new Day(DayEnum.MONDAY, new ArrayList<>(), new ArrayList<>(List.of(task)));
//    MaxView maxView = new MaxView("Tasks: ", 1, new SimpleStringProperty("3"));
//    taskView = new TaskView(task, taskQueue, controller, day, maxView);
//    stage.setScene(new Scene(new StackPane(taskView), 100,100));
//  }
//
//  @Test
//  void containsText(FxRobot robot) {
//    Assertions.assertThat(robot.lookup("#0").queryAs(Label.class)).hasText("Test");
//  }
}