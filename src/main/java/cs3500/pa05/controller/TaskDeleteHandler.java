package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import cs3500.pa05.viewer.MaxView;
import java.util.List;
import java.util.Objects;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class TaskDeleteHandler implements EventHandler {
  private Task task;
  private Day day;
  private Parent parent;
  private MaxView maxView;
  private ObservableList<Task> taskQueue;

  public TaskDeleteHandler(Task task, ObservableList<Task> taskQueue,
                           Day day, Parent parent, MaxView maxView) {
    this.task = task;
    this.taskQueue = taskQueue;
    this.day = day;
    this.parent = parent;
    this.maxView = maxView;
  }

  /**
   * Invoked when a specific event of the type for which this handler is
   * registered happens.
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(Event event) {
    day.removeIfFound(task);
    ((VBox) this.parent.getParent()).getChildren().remove(this.parent);
    int remove = 0;
    this.taskQueue.remove(task);
    maxView.subtract();
  }
}
