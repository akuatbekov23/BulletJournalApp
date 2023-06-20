package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import cs3500.pa05.viewer.ChooseNewDialog;
import java.time.LocalTime;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

public class ChooseNewHandler implements EventHandler {
  Day day;

  public ChooseNewHandler(Day day) {
    this.day = day;
  }

  @Override
  public void handle(Event event) {

    Dialog popup = new ChooseNewDialog(day);
    Optional<Events> result = popup.showAndWait();

    if (result.isPresent()) {
      result.get();
    }
  }
}
