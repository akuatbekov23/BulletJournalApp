package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.viewer.CreateEventDialog;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;

/**
 * the event handler
 */
public class CreateEventHandler implements EventHandler {

  private ListView<String> listView = new ListView<>();

  @Override
  public void handle(javafx.event.Event event) {

    Dialog popup = new CreateEventDialog();
    Optional<Event> result = popup.showAndWait();

    if (result.isPresent()) {
      Event newEvent = result.get();
    }


  }
}
