package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import java.util.List;
import java.util.Objects;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class TaskDeleteHandler implements EventHandler {
  private Task task;
  private Day day;
  private Parent parent;
  private
  List<Task> taskQueueList;
  private VBox taskQueue;

  public TaskDeleteHandler(Task task, Day day, Parent parent,
                           List<Task> taskQueueList, VBox taskQueue) {
    this.task = task;
    this.day = day;
    this.parent = parent;
    this.taskQueueList = taskQueueList;
    this.taskQueue = taskQueue;
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
    for (int i = 0; i < taskQueueList.size(); i++) {
      if (taskQueueList.get(i) == task) {
        remove = i;
      }
    }
    taskQueueList.remove(remove);
    taskQueue.getChildren().remove(remove);
  }
}
