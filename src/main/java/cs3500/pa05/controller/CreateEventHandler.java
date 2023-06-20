package cs3500.pa05.controller;

import cs3500.pa05.model.Events;
import cs3500.pa05.viewer.CreateEventDialog;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

/**
 * the event handler
 */
public class CreateEventHandler implements EventHandler {
  List<Events> events;

  public CreateEventHandler(List<Events> events) {
    this.events = events;
  }

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateEventDialog(new Events(null, null,
        null, null, null));
    Optional<Events> result = popup.showAndWait();

    if (result.isPresent()) {
      Events e = result.get();
      System.out.println(e);
      events.add(e);
    }

  }
}
