package cs3500.pa05.controller;

import cs3500.pa05.model.Events;
import cs3500.pa05.viewer.ButtonView;
import cs3500.pa05.viewer.CreateEventDialog;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;

/**
 * the event handler
 */
public class CreateEventHandler implements EventHandler {

  private ListView<String> listView = new ListView<>();

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateEventDialog();
    Optional<Events> result = popup.showAndWait();

    if (result.isPresent()) {
      Events newEvent = result.get();
    }


  }
}
