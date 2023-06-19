package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class EventDeleteHandler implements EventHandler {
  Events events;
  Day day;
  Parent parent;

  public EventDeleteHandler(Events events, Day day, Parent parent) {
    this.events = events;
    this.day = day;
    this.parent = parent;
  }

  /**
   * Invoked when a specific event of the type for which this handler is
   * registered happens.
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(Event event) {
    day.removeIfFound(events);
    ((VBox) this.parent.getParent()).getChildren().remove(this.parent);
  }
}
