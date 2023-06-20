package cs3500.pa05.controller;

import cs3500.pa05.model.Events;
import cs3500.pa05.viewer.CreateEventDialog;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

/**
 * the event handler
 */
public class CreateEventHandler implements EventHandler {

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateEventDialog(new Events(null, null,
        null, null, null));
    Optional<Events> result = popup.showAndWait();

    if (result.isPresent()) {
      Events events = result.get();
    }

  }
}
