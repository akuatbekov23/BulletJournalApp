package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.CreateTaskDialog;
import cs3500.pa05.viewer.MaxView;
import cs3500.pa05.viewer.TaskView;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;

/**
 * the event handler for creating tasks
 */
public class CreateTaskHandler implements EventHandler {
  List<Task> taskList;
  Day day;
  Week week;
  Dialog dialog;
  Controller controller;
  public CreateTaskHandler(List<Task> taskList, Week week, Day day,
                           Controller controller, Dialog dialog) {
    this.taskList = taskList;
    this.week = week;
    this.day = day;
    this.dialog = dialog;
    this.controller = controller;
  }


  @Override
  public void handle(Event event) {
    CreateTaskDialog popup = new CreateTaskDialog(DayEnum.valueOf(day.getDay()));
    Optional<Task> result = popup.showAndWait();

    result.ifPresent((Task task) -> {
      taskList.add(task);
      week.addTaskQueue(task);
      controller.initialize();
      dialog.close();
    });
  }
}


