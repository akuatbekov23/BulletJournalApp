package cs3500.pa05.controller;

import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.viewer.CreateTaskDialog;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

/**
 * the event handler for creating tasks
 */
public class CreateTaskHandler implements EventHandler {

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateTaskDialog(new Task(null, null,
        null, false));
    Optional<Task> result = popup.showAndWait();

    if (result.isPresent()) {
      Task task = result.get();
    }
  }
}


