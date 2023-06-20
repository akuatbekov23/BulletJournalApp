package cs3500.pa05.controller;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
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
  DayEnum dayEnum;

  public CreateEventHandler(List<Events> events, DayEnum dayEnum) {
    this.events = events;
    this.dayEnum = dayEnum;
  }

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateEventDialog(dayEnum);
    Optional<Events> result = popup.showAndWait();

    result.ifPresent((Events e) -> {
      events.add(e);
    });
  }
}
