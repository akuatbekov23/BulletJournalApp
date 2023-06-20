package cs3500.pa05.controller;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.viewer.CreateTaskDialog;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

/**
 * the event handler for creating tasks
 */
public class CreateTaskHandler implements EventHandler {
  List<Task> taskList;
  DayEnum dayEnum;

  public CreateTaskHandler(List<Task> taskList, DayEnum dayEnum) {
    this.taskList = taskList;
    this.dayEnum = dayEnum;
  }


  @Override
  public void handle(Event event) {
    CreateTaskDialog popup = new CreateTaskDialog(dayEnum);
    Optional<Task> result = popup.showAndWait();

    result.ifPresent((Task task) -> {
      System.out.println(task.getName());
      System.out.println(task.getDescription());
      System.out.println(task.getComplete());
      taskList.add(task);
    });
  }
}


